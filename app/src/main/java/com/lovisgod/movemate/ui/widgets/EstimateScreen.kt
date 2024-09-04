package com.lovisgod.movemate.ui.widgets

import android.content.Context
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.lovisgod.movemate.R
import com.lovisgod.movemate.ui.NavigationItem
import com.lovisgod.movemate.ui.theme.WhiteText
import com.lovisgod.movemate.ui.theme.orangeColor
import kotlinx.coroutines.delay

@Composable
fun EstimateScreen(
    navController: NavController? = null,
    context: Context? = null
) {
    var isPressed by remember { mutableStateOf(false) }

    var isVisibleImage by remember { mutableStateOf(false) }

    // Animate the scale from 0 to 1 when the image becomes visible
    val imageScale by animateFloatAsState(
        targetValue = if (isVisibleImage) 1f else 0f
    )

    // Animatable for smooth animation
    val animatable = remember { Animatable(0f) }

    // LaunchedEffect to start the animation
    val targetValue = 1454
    LaunchedEffect(targetValue) {
        // Animate from 0 to targetValue over specified duration
        animatable.animateTo(
            targetValue = targetValue.toFloat(),
            animationSpec = tween(durationMillis = 2000, easing = LinearEasing)
        )
    }
    // Animatable for scale animation
    val scaleButton = remember { Animatable(1f) }

    val targetScale = 1.1f

    // Start animation when button is pressed
    LaunchedEffect(isPressed) {
        if (isPressed) {
            // Animate the scale
            scaleButton.animateTo(
                targetValue = 0.9f,
                animationSpec = tween(durationMillis = 300)
            )

            // Reset scale to 1
            scaleButton.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis = 300)
            )

            // Perform navigation after animation
            navController?.navigate(
                NavigationItem.Home.route,
                NavOptions.Builder()
                    .setPopUpTo(NavigationItem.Home.route, false).build())

            // Reset isPressed to false
            isPressed = false
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Top Logo
            Image(
                painter = painterResource(id = R.drawable.ic_logo), // Replace with your logo resource
                contentDescription = "Logo",
                modifier = Modifier.size(120.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Box with Icon
            Image(
                painter = painterResource(id = R.drawable.delivery), // Replace with your box icon resource
                contentDescription = "Box",
                modifier = Modifier.size(150.dp).scale(imageScale).background(color = WhiteText)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Total Estimated Amount Section
            Text(
                text = "Total Estimated Amount",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = "$${animatable.value.toInt().toString()} USD",
                fontSize = 28.sp,
                color = Color(0xFF4CAF50), // Green color for the amount
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Text(
                text = "This amount is estimated and may vary based on location or weight.",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(vertical = 8.dp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Button
            Button(
                onClick = {
                   isPressed = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = orangeColor), // Orange color
                modifier = Modifier.fillMaxWidth().scale(scaleButton.value)
            ) {
                Text(
                    text = "Back to Home",
                    color = Color.White,
                    modifier = Modifier.padding(8.dp)
                )
            }

            LaunchedEffect(Unit) {
                delay(200) // Adjust the delay duration as needed
                isVisibleImage = true
            }

//            if (isPressed) {
//                LaunchedEffect(Unit) {
//                    delay(100) // Adjust the delay duration as needed
//                    isPressed = false
//
//                }
//            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun EstimateScreenPreview() {
    EstimateScreen()
}
