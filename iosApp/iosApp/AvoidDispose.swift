//
//  AvoidDispose.swift
//  iosApp
//
//  Created by Clem on 27.10.22.
//  Copyright © 2022 orgName. All rights reserved.
//

import UIKit

// ComposeWindow is disposed on viewDidDisappear so but it inside a container view:
// https://github.com/JetBrains/androidx/blob/jb-main/compose/ui/ui/src/uikitMain/kotlin/androidx/compose/ui/window/ComposeWindow.uikit.kt

class AvoidDispose: UIViewController {
    let controller: UIViewController
    
    init(_ controller: UIViewController) {
        self.controller = controller
        super.init(nibName: nil, bundle: nil)
        view.backgroundColor = .red
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        addChild(controller)
        view.addSubview(controller.view)
        controller.view.frame = view.safeAreaLayoutGuide.layoutFrame
        controller.view.backgroundColor = .blue
        //kotlin compose refresh
        //controller.view.touchesCancelled([UITouch()], with: UIEvent())
        view.isHidden = true
        print("\(view.bounds) \(view.safeAreaInsets)")
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        view.isHidden = false
    }
    
    override func viewDidDisappear(_ animated: Bool) {
        super.viewDidDisappear(animated)
        controller.removeFromParent()
        controller.view.removeFromSuperview()
    }
    
    override func viewSafeAreaInsetsDidChange() {
        super.viewSafeAreaInsetsDidChange()
        view.setNeedsLayout()
        controller.view.setNeedsLayout()
        controller.viewWillAppear(false)
    }
    
}
