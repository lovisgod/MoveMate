package com.lovisgod.movemate.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.lovisgod.movemate.ui.icons.Calculate
import com.lovisgod.movemate.ui.icons.History

sealed class NavigationItem (
    val title: String,
    val route: String,
    val icon: ImageVector,
) {
    data object Home : NavigationItem(
        title = "Home",
        route = "landing_screen",
        icon = Icons.Outlined.Home,
    )

    data object Calculate : NavigationItem(
        title = "Calculate",
        route = "calculate_screen",
        icon = com.lovisgod.movemate.ui.icons.Calculate,
    )

    data object Shipment : NavigationItem(
        title = "Shipment",
        route = "shipment_screen",
        icon = History,
    )

    data object Profile : NavigationItem(
        title = "Profile",
        route = "profile_screen",
        icon = Icons.Outlined.Person,
    )

}