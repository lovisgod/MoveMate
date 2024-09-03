package com.lovisgod.movemate.ui.widgets

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lovisgod.movemate.data.dataSource.DataSource
import com.lovisgod.movemate.data.model.ShipmentItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShipmentsList(shipments: List<ShipmentItem>) {
    LazyColumn(
        modifier = Modifier.animateContentSize()
    ) {
        items(shipments) { item ->
            ShipmentCard(item = item)

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

