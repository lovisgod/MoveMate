package com.lovisgod.movemate.ui.screens


import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.input.KeyboardCapitalization
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
import com.lovisgod.movemate.ui.icons.Scan
import com.lovisgod.movemate.ui.routeDefinition.mainScreens
import com.lovisgod.movemate.ui.theme.PurpleBackground
import com.lovisgod.movemate.ui.theme.WhiteText
import com.lovisgod.movemate.ui.widgets.FreightOptionsList
import com.lovisgod.movemate.ui.widgets.GenericInputField
import com.lovisgod.movemate.ui.widgets.LastOrderWidget
import com.lovisgod.movemate.viewmodel.MoveMateViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun landingPageWithAppBar(
    navController: NavController?,
    viewModel: MoveMateViewModel = hiltViewModel(),
    context: Context?,
) {
    Scaffold(
        topBar = {
            TopAppBar(
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
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            // Profile icon and location details
                            Image(
                                painter = painterResource(id = R.drawable.profile),
                                contentDescription = "Profile Icon",
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .background(Color.White) // Optional: Add a background to the profile icon
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Column {
                                Text(
                                    text = "Your location",
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        color = Color.White.copy(alpha = 0.7f)
                                    )
                                )
                                Text(
                                    text = "Wertheimer, Illinois",
                                    style = MaterialTheme.typography.bodyLarge.copy(
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }

//                            Spacer(modifier = Modifier.weight(1f))
                        }

                },
                actions = {
                    IconButton(
                        onClick = { /* Handle notification click */ },
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.notification),
                            contentDescription = "Notification Icon",
                            tint = Color.Black,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            )
        },
        content = {
            landingPage(
                navController = navController,
                context = context,
                viewModel = viewModel,
                modifier = Modifier
                    .padding(it)
                    .background(color = Color.White)
            )
        }
    )
}

@Composable
fun landingPage(
    navController: NavController? = null,
    context: Context? = null,
    viewModel: MoveMateViewModel? = null,
    modifier: Modifier = Modifier
) {

    LaunchedEffect(key1 = "getFreightOptions") {
        viewModel?.getFreightOptions()
    }

    val freightOption = viewModel?.freightOptionsState?.collectAsState()

    var text by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color(0xFFFFFFFF))
            .padding(bottom = 59.dp),
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .background(PurpleBackground) // Purple background color
                .padding(16.dp), // Padding inside the container
            color = Color.Transparent // Ensure the Surface background is transparent to show the purple color
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().clickable {
                    navController?.navigate(mainScreens.filteredPackageScreen.route)
                }
            ) {
                GenericInputField(
                    header = "Sample header",
                    footer = "Tap dropdown to see lists of route",
                    inputWidth = 288.dp,
                    enable = false,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, capitalization = KeyboardCapitalization.Characters),
                    hint = "Enter your receipt number ...",
                    leftIcon = Icons.Default.Search,
                    rightIcon = Scan,
                    text = text,
                    onInputValueChange = {
                        text = it
                    },
                 )

            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            color = Color.Black,
            text = "Tracking",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 15.dp)
        )

        LastOrderWidget(
            trackingInfo = TrackingInfo(
                sender = "Atlanta, 5244",
                receiver = "Chicago, 6343",
                status = "Waiting",
                time = "2 days -3 days"
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            color = Color.Black,
            text = "Available vehicles",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 15.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        FreightOptionsList(freightOptions = freightOption?.value ?: listOf(FreightOption()) )

//        FreightOptionsList(freightOptions = listOf(
//            FreightOption(), FreightOption(), FreightOption()) )

    }

}


@Preview
@Composable
fun landingPagePreview() {
    landingPageWithAppBar(
        context = null,
        navController = null
    )
}
