package com.rouge41.kmm.compose

import cocoapods.YogaKit.*
import kotlinx.cinterop.ExportObjCClass
import kotlinx.cinterop.useContents
import platform.CoreGraphics.CGFloat
import platform.Foundation.NSIndexPath
import platform.Foundation.NSLog
import platform.UIKit.*
import platform.darwin.NSInteger
import platform.darwin.NSObject

@Composable
actual fun LazyColumn(
    modifier: Modifier,
    state: LazyListState,
    contentPadding: PaddingValues,
    reverseLayout: Boolean,
    verticalArrangement: ArrangementVertical,
    horizontalAlignment: AlignmentHorizontal,
    content: LazyListScope.() -> Unit
) {
    val controller = state
    controller.tableView.setFrame(getCurrentView().bounds)
    addSubview(controller.tableView) {
        addController(controller) {
            controller.items.clear()
            content.invoke(iosLazyListScope())
            controller.tableView.reloadData()
        }
    }
}

actual typealias LazyListState = ComposeTableViewController
actual class InteractionState
actual fun rememberLazyListState(
    initialFirstVisibleItemIndex: Int,
    initialFirstVisibleItemScrollOffset: Int,
    interactionState: InteractionState?
): LazyListState = remember { ComposeTableViewController() }

actual interface LazyListScope {
    actual fun <T> items(
        items: List<T>,
        itemContent: @Composable LazyItemScope.(item: T) -> Unit
    )

    actual fun item(content: @Composable LazyItemScope.() -> Unit)
    actual fun <T> itemsIndexed(
        items: List<T>,
        itemContent: @Composable LazyItemScope.(index: Int, item: T) -> Unit
    )
}

class iosLazyListScope : LazyListScope {
    override fun <T> items(items: List<T>, itemContent: LazyItemScope.(item: T) -> Unit) {
        val controller = getCurrentController()
        if (controller is ComposeTableViewController) {
            for (item in items) {
                controller.items.add {
                    itemContent.invoke(this, item)
                }
            }
        }
    }

    override fun item(content: LazyItemScope.() -> Unit) {
        val controller = getCurrentController()
        if (controller is ComposeTableViewController) {
            controller.items.add(content)
        }
    }

    override fun <T> itemsIndexed(
        items: List<T>,
        itemContent: LazyItemScope.(index: Int, item: T) -> Unit
    ) {
        val controller = getCurrentController()
        if (controller is ComposeTableViewController) {
            for ((index, item) in items.withIndex()) {
                controller.items.add {
                    itemContent.invoke(this, index, item)
                }
            }
        }
    }

}

actual interface LazyItemScope
class iosLazyItemScope : LazyItemScope

private val cellIdentifier = "lazyCell"

class ComposeTableViewController() : UIViewController(nibName = null, bundle = null), UITableViewDataSourceProtocol {
    var items =  mutableListOf<@Composable LazyItemScope.() -> Unit>()
    var heights = mutableMapOf<Long, CGFloat>()
    val tableView = UITableView()
    var delegate: ComposeTableViewDelegate

    init {
        tableView.estimatedRowHeight = 44.0
        tableView.dataSource = this
        tableView.tableFooterView = UIView()
        delegate = ComposeTableViewDelegate(this)
        tableView.delegate = delegate
        tableView.registerClass(cellClass = ComposeTableViewCell(UITableViewCellStyle.UITableViewCellStyleDefault, null)::`class`.invoke(), forCellReuseIdentifier = cellIdentifier)
    }

    override fun tableView(tableView: UITableView, numberOfRowsInSection: NSInteger): NSInteger {
        return items.size.toLong()
    }

    override fun tableView(tableView: UITableView, cellForRowAtIndexPath: NSIndexPath): UITableViewCell {
        var cell = tableView.dequeueReusableCellWithIdentifier(cellIdentifier, cellForRowAtIndexPath)
        if (cell == null) {
            cell = UITableViewCell(UITableViewCellStyle.UITableViewCellStyleDefault, cellIdentifier)
            cell.contentView.configureLayoutWithBlock { layout ->
                layout?.isEnabled = true
                layout?.width = YGPercentValue(100.0)
            }
        }
        cell.selectionStyle = UITableViewCellSelectionStyle.UITableViewCellSelectionStyleNone
        cell.separatorInset = UIEdgeInsetsMake(0.0, 0.0, 0.0, CGFloat.MAX_VALUE)
        addViewAndLayout(cell.contentView) {
            items[cellForRowAtIndexPath.row.toInt()].invoke(iosLazyItemScope())
        }
        val height = contentSize(cell.contentView).useContents { height }
        heights[cellForRowAtIndexPath.row] = height
        return cell
    }
}

class ComposeTableViewDelegate(val controller: ComposeTableViewController): NSObject(), UITableViewDelegateProtocol {
    override fun tableView(tableView: UITableView, heightForRowAtIndexPath: NSIndexPath): CGFloat {
        return controller.heights[heightForRowAtIndexPath.row] ?: 44.0
    }
}

@ExportObjCClass
class ComposeTableViewCell: UITableViewCell {
    init {
        if (DEBUG_COMPOSE) NSLog("🔴 [init ComposeTableViewCell]")
        contentView.configureLayoutWithBlock { layout ->
            layout?.isEnabled = true
            layout?.width = YGPercentValue(100.0)
        }
    }

    @OverrideInit constructor(style: UITableViewCellStyle, reuseIdentifier: String?) : super(style, reuseIdentifier)
}