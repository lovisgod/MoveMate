 package com.lovisgod.movemate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bottombar.AnimatedBottomBar
import com.example.bottombar.components.BottomBarItem
import com.example.bottombar.model.IndicatorStyle
import com.example.bottombar.model.VisibleItem
import com.lovisgod.movemate.ui.NavigationItem
import com.lovisgod.movemate.ui.routeDefinition.mainScreens
import com.lovisgod.movemate.ui.screens.CalculatePageWithAppBar
import com.lovisgod.movemate.ui.screens.ShipmentPageWithAppBar
import com.lovisgod.movemate.ui.screens.landingPageWithAppBar
import com.lovisgod.movemate.ui.theme.LightGrey
import com.lovisgod.movemate.ui.theme.MoveMateTheme
import com.lovisgod.movemate.ui.theme.PurpleBackground
import com.lovisgod.movemate.ui.widgets.TopSection
import dagger.hilt.android.AndroidEntryPoint

 @AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoveMateTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)) {
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentRoute = navBackStackEntry?.destination?.route?.substringBeforeLast("/")
                    val navigationItems = listOf(NavigationItem.Home, NavigationItem.Calculate, NavigationItem.Shipment, NavigationItem.Profile)
                    var selectedItem by remember { mutableIntStateOf(0) }
                    // A surface container using the 'background' color from the theme
                    Scaffold(
                        bottomBar = {
                            AnimatedBottomBar(
                                modifier = Modifier.shadow(elevation = 5.dp),
                                bottomBarHeight = 70.dp,
                                selectedItem = selectedItem,
                                itemSize = navigationItems.take(4).size,
                                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                                indicatorStyle = IndicatorStyle.LINE,
                                indicatorColor = PurpleBackground
                            ) {
                                navigationItems.take(4).forEachIndexed { index, navigationItem ->
                                    val selected = currentRoute == navigationItem.route
                                    BottomBarItem(
                                        selected = selected,
                                        onClick = {
                                            if (currentRoute != navigationItem.route) {
                                                selectedItem = index
                                                navController.popBackStack()
                                                navController.navigate(navigationItem.route) {
                                                    navController.graph.startDestinationRoute?.let { route ->
                                                        popUpTo(route) {
                                                            saveState = true
                                                        }
                                                    }
                                                    launchSingleTop = true
                                                    restoreState = true
                                                }
                                            }
                                        },
                                        iconColor = if (selected) PurpleBackground else Color.Gray,
                                        textColor = if (selected) PurpleBackground else Color.Gray,
                                        imageVector = navigationItem.icon,
                                        label = navigationItem.title,
                                        visibleItem = VisibleItem.BOTH
                                    )
                                }
                            }
                        }
                    ) {
                        Surface(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(it)
                                .background(color = Color.White),
                        ) {
                            NavHost(
                                navController = navController,
                                startDestination = NavigationItem.Home.route
                            ) {
                                composable(route = NavigationItem.Home.route) {
                                    landingPageWithAppBar(
                                        navController = navController,
                                        context = LocalContext.current
                                    )
                                }
                                composable(
                                    NavigationItem.Calculate.route,
                                    enterTransition = {
                                        fadeIn(
                                            animationSpec = tween(
                                                300, easing = LinearEasing
                                            )
                                        ) + slideIntoContainer(
                                            animationSpec = tween(300, easing = EaseIn),
                                            towards = AnimatedContentTransitionScope.SlideDirection.Start
                                        )
                                    },
                                    exitTransition = {
                                        fadeOut(
                                            animationSpec = tween(
                                                300, easing = LinearEasing
                                            )
                                        ) + slideOutOfContainer(
                                            animationSpec = tween(300, easing = EaseOut),
                                            towards = AnimatedContentTransitionScope.SlideDirection.End
                                        )
                                    }
                                    ) {
                                    CalculatePageWithAppBar(
                                        navController = navController,
                                        context = LocalContext.current
                                    )
                                }
                                composable(NavigationItem.Shipment.route) {
                                    ShipmentPageWithAppBar(
                                        navController = navController,
                                        context = LocalContext.current
                                    )
                                }

                                composable(NavigationItem.Profile.route) {
                                    landingPageWithAppBar(
                                        navController = navController,
                                        context = LocalContext.current
                                    )
                                }
                            }

                            BackHandler {
                                // If the current screen is not the home screen, navigate to the home screen
                                if (currentRoute != NavigationItem.Home.route) {
                                    navController.navigate(NavigationItem.Home.route) {
                                        popUpTo(navController.graph.startDestinationId) {
                                            inclusive = true
                                        }
                                    }
                                } else {
                                    // If it's the home screen, finish the activity
                                    finish()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}