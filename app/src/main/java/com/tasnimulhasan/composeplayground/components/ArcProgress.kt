package com.tasnimulhasan.composeplayground.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ArcProgress() {

    val startAngle = 150f
    val sweepAngle = 240f
    val progress = remember { mutableFloatStateOf(0.9f) }
    val progressSweepAngle = remember { mutableFloatStateOf(sweepAngle * progress.floatValue) }

    val animatedSweepAngle by animateFloatAsState(
        targetValue = progressSweepAngle.floatValue,
        animationSpec = tween(durationMillis = 1000)
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .padding(32.dp)
        ) {
            val screenWidth = size.width
            val screenHeight = size.height

            val lightStadiumGreen = Color(0xFF4CBB17)
            val darkStadiumGreen = Color(0xFF3A9D23)

            drawArc(
                color = darkStadiumGreen,
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = false,
                size = Size(screenWidth, screenHeight),
                topLeft = Offset(0f, screenHeight / 2 - screenHeight / 2.6f),
                style = Stroke(24.dp.toPx(), cap = StrokeCap.Round)
            )

            drawArc(
                color = lightStadiumGreen,
                startAngle = startAngle,
                sweepAngle = animatedSweepAngle,
                useCenter = false,
                size = Size(screenWidth, screenHeight),
                topLeft = Offset(0f, screenHeight / 2 - screenHeight / 2.6f),
                style = Stroke(16.dp.toPx(), cap = StrokeCap.Round)
            )
        }
    }

}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun PreviewArcProgress() {
    ArcProgress()
}