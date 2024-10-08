package com.lovisgod.movemate.ui.routeDefinition

sealed class mainScreens(val route: String) {
   object landingScreen: mainScreens("landing_screen")
   object summaryScreen: mainScreens("summary_screen")

   object filteredPackageScreen: mainScreens("filtered_package_screen")
}