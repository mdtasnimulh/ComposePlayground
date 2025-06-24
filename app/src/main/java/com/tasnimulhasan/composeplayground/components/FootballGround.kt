package com.tasnimulhasan.composeplayground.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.AndroidPath
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FootballGround() {

    Box(
        modifier = Modifier,
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val screenWidth = size.width
            val screenHeight = size.height

            val lightStadiumGreen = Color(0xFF4CBB17)
            val darkStadiumGreen = Color(0xFF3A9D23)

            val rectHeight = screenHeight / 10

            for (ground in 0 until 10) {
                val groundColor = if (ground % 2 == 0) lightStadiumGreen else darkStadiumGreen
                drawRect(
                    color = groundColor,
                    topLeft = Offset(0f, ground * rectHeight),
                    size = Size(screenWidth, rectHeight)
                )
            }

            val pitchOutline = AndroidPath().apply {
                moveTo(50f, 50f)
                lineTo(screenWidth - 50f, 50f)
                lineTo(screenWidth - 50f, screenHeight - 50f)
                lineTo(50f, screenHeight - 50f)
                close()
                moveTo(50f, screenHeight / 2)
                lineTo(screenWidth - 50f, screenHeight / 2)
            }

            drawPath(path = pitchOutline, color = Color.White, style = Stroke(3.dp.toPx()))

            drawCircle(
                color = Color.White,
                radius = 10f,
                center = Offset(screenWidth / 2, screenHeight / 2)
            )
            
            drawCircle(
                color = Color.White,
                radius = 100f,
                center = Offset(screenWidth / 2, screenHeight / 2),
                style = Stroke(3.dp.toPx())
            )

            drawArc(
                color = Color.White,
                startAngle = 0f,
                sweepAngle = 90f,
                useCenter = false,
                size = Size(100f, 100f),
                topLeft = Offset(0f, 0f),
                style = Stroke(3.dp.toPx())
            )

            drawArc(
                color = Color.White,
                startAngle = 90f,
                sweepAngle = 90f,
                useCenter = false,
                size = Size(100f, 100f),
                topLeft = Offset(screenWidth - 100f, 0f),
                style = Stroke(3.dp.toPx())
            )

            drawArc(
                color = Color.White,
                startAngle = 180f,
                sweepAngle = 90f,
                useCenter = false,
                size = Size(100f, 100f),
                topLeft = Offset(screenWidth - 100f, screenHeight - 100f),
                style = Stroke(3.dp.toPx())
            )

            drawArc(
                color = Color.White,
                startAngle = 270f,
                sweepAngle = 90f,
                useCenter = false,
                size = Size(100f, 100f),
                topLeft = Offset(0f, screenHeight - 100f),
                style = Stroke(3.dp.toPx())
            )

            drawRect(
                color = Color.White,
                topLeft = Offset(screenWidth / 2 - 100f, 50f),
                size = Size(200f, 100f),
                style = Stroke(3.dp.toPx())
            )

            drawRect(
                color = Color.White,
                topLeft = Offset(screenWidth / 2 - 300f, 50f),
                size = Size(600f, 300f),
                style = Stroke(3.dp.toPx())
            )

            drawRect(
                color = Color.White,
                topLeft = Offset(screenWidth / 2 - 100f, screenHeight - 150f),
                size = Size(200f, 100f),
                style = Stroke(3.dp.toPx())
            )

            drawRect(
                color = Color.White,
                topLeft = Offset(screenWidth / 2 - 300f, screenHeight - 350f),
                size = Size(600f, 300f),
                style = Stroke(3.dp.toPx())
            )

            drawCircle(
                color = Color.White,
                radius = 10f,
                center = Offset(screenWidth / 2, 200f)
            )

            drawCircle(
                color = Color.White,
                radius = 10f,
                center = Offset(screenWidth / 2, screenHeight - 200f)
            )

            drawArc(
                color = Color.White,
                startAngle = 0f,
                sweepAngle = 180f,
                useCenter = false,
                size = Size(200f, 100f),
                topLeft = Offset(screenWidth / 2 - 100f, 300f),
                style = Stroke(3.dp.toPx())
            )

            drawArc(
                color = Color.White,
                startAngle = 180f,
                sweepAngle = 180f,
                useCenter = false,
                size = Size(200f, 100f),
                topLeft = Offset(screenWidth / 2 - 100f, screenHeight - 400f),
                style = Stroke(3.dp.toPx())
            )
        }
    }

}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun PreviewCircularProgressIndicator() {
    FootballGround()
}