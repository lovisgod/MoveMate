package com.lovisgod.movemate.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lovisgod.movemate.R
import com.lovisgod.movemate.ui.theme.PurpleBackground
import com.lovisgod.movemate.ui.theme.WhiteText

@Composable
fun TopSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = PurpleBackground)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        // Top Row with Profile Icon, Location Column, Notification Icon
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Profile Icon
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile Icon",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            // Location Column (Text inside a Column)
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Your location",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = WhiteText,
                        fontSize = 14.sp
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Wertheimer, Illinois",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = WhiteText,
                        fontSize = 16.sp
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }

            // Notification Icon
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(36.dp) // Set the size of the circle
                    .background(color = Color.White, shape = CircleShape) // White circular background
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.notification),
                    contentDescription = "Notification Icon",
                    tint = PurpleBackground, // Set the icon color to match your theme or desired color
                    modifier = Modifier.size(20.dp) // Adjust the icon size
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Search Bar
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    text = "Enter the receipt number...",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = WhiteText.copy(alpha = 0.7f)
                    )
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search Icon",
                    tint = WhiteText
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White.copy(alpha = 0.2f), shape = MaterialTheme.shapes.small),
            colors = TextFieldDefaults.colors(
                cursorColor = WhiteText,
                focusedContainerColor = WhiteText.copy(alpha = 0.5f),
                unfocusedContainerColor = WhiteText.copy(alpha = 0.2f)
            )
        )
    }
}

@Preview
@Composable
fun PreviewTopSection() {
    TopSection()
}
