package com.lovisgod.movemate.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.lovisgod.movemate.R
import com.lovisgod.movemate.ui.icons.Package_2
import com.lovisgod.movemate.ui.icons.Package_2_white
import com.lovisgod.movemate.ui.screens.CalculatePageWithAppBar
import com.lovisgod.movemate.ui.theme.LightPurple
import com.lovisgod.movemate.ui.theme.WhiteText

@Composable
fun PackageItem(
    title: String,
    trackingNumber: String,
    route: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = WhiteText)
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        // Icon with circular background
            // Placeholder for the icon, replace with your icon
        Image(
                imageVector = Package_2_white,
                contentDescription = "Package icon",
                modifier = Modifier
                    .padding(3.dp)
                    .background(
                        color = LightPurple,
                        shape = CircleShape
                    )
                    .size(35.dp)
        )

        Spacer(modifier = Modifier.width(5.dp))

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(fontSize = 16.sp),
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Row {
                Text(
                    text = trackingNumber,
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = route,
                    style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Divider(thickness = 0.5.dp, color = Color.Gray)
        }
    }
}

@Preview
@Composable
fun PackageItemPreview() {
   PackageItem(title = "Summer Linen Jacket", trackingNumber = "#NEJ209994389232", route ="Barcelona → Paris" )
}
