package com.rouge41.kmm.compose.test.demos

import com.rouge41.kmm.compose.foundation.layout.*
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.foundation.shape.RoundedCornerShape
import com.rouge41.kmm.compose.material.*
import com.rouge41.kmm.compose.ui.*
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.unit.dp

object Game2048 {
    val board = arrayOf(
        intArrayOf(4, 0, 0, 0),
        intArrayOf(0, 0, 2, 0),
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 2, 0, 2)
    )
    const val BOARD_SIZE = 4
}

object ProjectColors {
    val amber = Color(0xFFECCC5F)
    val white = Color.White
    val brown = Color(0xFF3D3A33)
    val orangeLight = Color(0xFFF75E3E)
    val surface = Color(0xFFA4937F)
    val text = Color(0xFF6F665E)
    val piece = Color(0xFFEEE1CE)
    val background = Color(0xFFFCF9F0)
}

val largeShape = RoundedCornerShape(8.dp)

@Composable
fun Board2048() {

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        Board(Game2048.board)
        Row {
            ActionButton("Left")
            ActionButton("Right")
        }
        Row {
            ActionButton("Top")
            ActionButton("Bottom")
        }
    }
}

@Composable
fun Board(board: Array<IntArray>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.clip(largeShape).background(color = ProjectColors.surface).padding(8.dp).fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        repeat(Game2048.BOARD_SIZE) { row ->
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                repeat(Game2048.BOARD_SIZE) { col ->
                    Cell(board[row][col], modifier = Modifier.weight(1.0f))
                }
            }
        }
    }
}

@Composable
fun Cell(num: Int, modifier: Modifier) {
    Box(
        modifier = modifier.background(ProjectColors.piece).aspectRatio(1.0f),
        contentAlignment = Alignment.Center
    ) {
        if (num > 0) {
            Text(
                text = "$num",
            )
        }
    }
}

@Composable
fun ActionButton(text: String, action: (() -> Unit)? = null) {
    Button(
        onClick = { action?.invoke() },
        colors = ButtonDefaults.buttonColors(backgroundColor = ProjectColors.amber)
    ) {
        Text(text, color = Color.White)
    }
}
