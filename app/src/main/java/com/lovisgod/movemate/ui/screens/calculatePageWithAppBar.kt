package com.lovisgod.movemate.ui.screens


import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lovisgod.movemate.R
import com.lovisgod.movemate.data.model.FreightOption
import com.lovisgod.movemate.data.model.TrackingInfo
import com.lovisgod.movemate.ui.NavigationItem
import com.lovisgod.movemate.ui.icons.Scan
import com.lovisgod.movemate.ui.theme.PurpleBackground
import com.lovisgod.movemate.ui.theme.WhiteText
import com.lovisgod.movemate.ui.widgets.FreightOptionsList
import com.lovisgod.movemate.ui.widgets.GenericInputField
import com.lovisgod.movemate.ui.widgets.LastOrderWidget
import com.lovisgod.movemate.ui.widgets.ShipmentsScreenWithTabs
import com.lovisgod.movemate.ui.widgets.ShippingCalculatorScreen
import com.lovisgod.movemate.viewmodel.MoveMateViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatePageWithAppBar(
    navController: NavController?,
    context: Context?,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                                navController?.navigate(NavigationItem.Home.route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        inclusive = true
                                    }
                                }
                        },
                        modifier = Modifier
                            .size(35.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.KeyboardArrowLeft,
                            contentDescription = "Navigating Icon",
                            tint = Color.White,
                            modifier = Modifier.size(35.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PurpleBackground,
                    titleContentColor = WhiteText,
                    navigationIconContentColor = WhiteText,
                    actionIconContentColor = WhiteText
                ),
                modifier = Modifier
                    .background(PurpleBackground)
                    .padding(end = 10.dp),
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                        Text(text = "Calculate", fontSize = 16.sp)
                    }
                },
                actions = {

                }
            )
        },
        content = {
          ShippingCalculatorScreen(modifier = Modifier.padding(it))
        }
    )
}




@Preview
@Composable
fun CalculatePagePreview() {
    CalculatePageWithAppBar(
        context = null,
        navController = null
    )
}
