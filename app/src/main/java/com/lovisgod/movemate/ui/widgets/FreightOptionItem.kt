package com.lovisgod.movemate.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lovisgod.movemate.R
import com.lovisgod.movemate.data.model.FreightOption
import com.lovisgod.movemate.ui.screens.landingPageWithAppBar
import com.lovisgod.movemate.ui.theme.WhiteText

@Composable
fun FreightOptionItem(freightOption: FreightOption) {
    ElevatedCard(
       modifier = Modifier.background(Color.White, RoundedCornerShape(8.dp))
    ) {
        Box(
            modifier = Modifier
                .background(color = Color.White)
                .width(150.dp)
                .height(150.dp)// Set a fixed width for each item
                .padding(top = 10.dp, start = 10.dp) // Padding inside the item
        ) {
            Column(
                modifier = Modifier.align(Alignment.TopStart)
            ) {
                BasicText(
                    text = freightOption.title,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                BasicText(
                    text = freightOption.subtitle,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 10.sp,
                        color = Color.Gray
                    )
                )
            }

            Image(
                painter = painterResource(id = freightOption.imageRes),
                contentDescription = freightOption.title,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(80.dp)
                    .background(color = WhiteText)
                    .align(Alignment.BottomEnd) // Set a fixed size for the image
            )
        }
    }
}

@Preview
@Composable
fun FreightOptionWidgetPreview() {
    FreightOptionItem(
        freightOption = FreightOption("Ocean Freight", "International", R.drawable.pushing_truck)
    )
}
