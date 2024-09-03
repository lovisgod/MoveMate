package com.lovisgod.movemate.ui.routeDefinition

sealed class mainScreens(val route: String) {
   object landingScreen: mainScreens("landing_screen")
}