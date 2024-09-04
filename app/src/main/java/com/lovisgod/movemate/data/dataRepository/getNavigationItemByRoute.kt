package com.lovisgod.movemate.data.dataRepository

import com.lovisgod.movemate.ui.NavigationItem

fun getNavigationItemByRoute(route: String, navigationItems: List<NavigationItem>): NavigationItem? {
    return navigationItems.find { it.route == route }
}