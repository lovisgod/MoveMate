package com.lovisgod.movemate.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lovisgod.movemate.data.dataSource.DataSource
import com.lovisgod.movemate.data.model.ShipmentItem
import com.lovisgod.movemate.data.model.TabItem
import com.lovisgod.movemate.viewmodel.MoveMateViewModel

@Composable
fun ShipmentsScreenWithTabs(
    modifier: Modifier? = null
) {
        val viewModel: MoveMateViewModel = hiltViewModel()

    LaunchedEffect(key1 = "getShipments") {
        viewModel.getShipments()
    }

    val shipmentsx = viewModel.shipmentsState.collectAsState()
    val tabs = listOf(
        TabItem("All", 4),
        TabItem("Completed", 4),
        TabItem("In progress", 4),
        TabItem("Pending", 4)
    )
    
    var selectedTabIndex by remember { mutableStateOf(0) }
    
    Column(modifier = Modifier.padding(top = 60.dp)) {
        // Tabs
        ShipmentsTabs(
            tabs = tabs,
            selectedTabIndex = selectedTabIndex,
            onTabSelected = { index ->
                selectedTabIndex = index
                println("this selected index   ${selectedTabIndex}")
                // Update shipments based on the selected tab
                viewModel.getShipments()
            }
        )
        
        // Shipment Items
        val shipments = DataSource().getShipments()
        
//        ShipmentsList(shipments = shipments)

        ShipmentsList(shipments = shipmentsx.value)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewShipmentsScreenWithTabs() {
    ShipmentsScreenWithTabs()
}

