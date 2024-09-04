package com.lovisgod.movemate.ui.screens


import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.navigation.NavOptions
import com.lovisgod.movemate.R
import com.lovisgod.movemate.data.model.FreightOption
import com.lovisgod.movemate.data.model.ItemData
import com.lovisgod.movemate.data.model.TrackingInfo
import com.lovisgod.movemate.ui.NavigationItem
import com.lovisgod.movemate.ui.icons.Scan
import com.lovisgod.movemate.ui.theme.LightGrey
import com.lovisgod.movemate.ui.theme.PurpleBackground
import com.lovisgod.movemate.ui.theme.WhiteText
import com.lovisgod.movemate.ui.widgets.FilteredSearchBar
import com.lovisgod.movemate.ui.widgets.FreightOptionsList
import com.lovisgod.movemate.ui.widgets.GenericInputField
import com.lovisgod.movemate.ui.widgets.LastOrderWidget
import com.lovisgod.movemate.ui.widgets.PackageItem
import com.lovisgod.movemate.ui.widgets.ShipmentsScreenWithTabs
import com.lovisgod.movemate.ui.widgets.ShippingCalculatorScreen
import com.lovisgod.movemate.viewmodel.MoveMateViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilteredPackagePageWithAppBar(
    navController: NavController?,
    context: Context?,
) {
    var query by remember { mutableStateOf("") }

    val allItems = listOf(
        ItemData("Summer linen jacket", "#NEJ2008993231", "Barcelona → Paris"),
        ItemData("Tapered-fit jeans AW", "#NEJ3580278659", "Colombia → Paris"),
        ItemData("Macbook Pro M2", "#NIL437340857904", "Paris → Morocco"),
        ItemData("Macbook Pro M1", "#NEF356540857904", "Nigeria → Morocco")
    )

    var filteredItems = allItems.filter {
        it.title.contains(query, ignoreCase = true) ||
                it.trackingNumber.contains(query, ignoreCase = true)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                          navController?.popBackStack()
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
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp, bottom = 5.dp),
                        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                        FilteredSearchBar(query = query, onQueryChanged = {
                            query = it
                        })
                    }
                },
                actions = {

                }
            )
        },
        content = {
            Column(modifier = Modifier
                .padding(it)) {
                Spacer(modifier = Modifier.height(30.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .background(color = Color.White)
                        .padding(
                            start = 15.dp, end = 15.dp, bottom = 15.dp, top = 15.dp
                        ),
                    shape = RoundedCornerShape(16.dp), // Rounded corners for the whole card
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.background(color = WhiteText)) {
                        Spacer(modifier = Modifier.height(25.dp))

                        LazyColumn(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            items(filteredItems.size) { index ->
                                val visible = remember { mutableStateOf(false) } // Keeps visibility state

                                androidx.compose.animation.AnimatedVisibility(
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
                                ) {
                                    PackageItem(
                                        title = filteredItems[index].title,
                                        trackingNumber = filteredItems[index].trackingNumber,
                                        route = filteredItems[index].route
                                    )
                                }

                                LaunchedEffect(Unit) {
                                    visible.value = true
                                }
                              }
                        }
                        Spacer(modifier = Modifier.height(25.dp))
                    }
                }
            }
        }
    )
}




@Preview
@Composable
fun FilteredPackagePageWithAppBarPreview() {
    FilteredPackagePageWithAppBar(
        context = null,
        navController = null
    )
}
