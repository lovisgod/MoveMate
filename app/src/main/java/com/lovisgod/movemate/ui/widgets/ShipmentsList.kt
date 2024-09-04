package com.lovisgod.movemate.ui.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lovisgod.movemate.data.dataSource.DataSource
import com.lovisgod.movemate.data.model.ShipmentItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShipmentsList(shipments: List<ShipmentItem>) {
    LazyColumn(
//        modifier = Modifier.animateContentSize(
//            animationSpec = tween(
//                durationMillis = 500,
//                easing = LinearOutSlowInEasing,
//            )
//        )
    ) {
        itemsIndexed(shipments) { index, item ->
            val visible = remember { mutableStateOf(false) } // Keeps visibility state

            AnimatedVisibility(
                visible = visible.value,
                enter = slideInVertically(
                    initialOffsetY = { it }, // Slide in from bottom
                    animationSpec = tween(
                        durationMillis = 600,
                        delayMillis = index * 100 // Staggered appearance
                    )
                ),
                exit = slideOutVertically(
                    targetOffsetY = { it }, // Slide out towards bottom
                    animationSpec = tween(durationMillis = 300)
                )
            ){
                ShipmentCard(
                    item = item
                )
            }

            LaunchedEffect(Unit) {
                visible.value = true
            }

        }
    }
}

@Composable
fun ShipmentsScreen(){
    val shipments = DataSource().getShipments() // this will be replaced by viewmodel
    ShipmentsList(shipments = shipments)
}

@Preview(showBackground = true)
@Composable
fun PreviewShipmentsScreen() {
    ShipmentsScreen()
}

