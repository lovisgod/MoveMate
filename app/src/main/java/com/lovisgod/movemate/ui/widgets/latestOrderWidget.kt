package com.lovisgod.movemate.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lovisgod.movemate.R
import com.lovisgod.movemate.data.model.TrackingInfo
import com.lovisgod.movemate.ui.theme.orangeColor
import com.lovisgod.movemate.ui.theme.veryLightBlueColor
import com.lovisgod.movemate.ui.theme.veryLightOrangeColor

@Composable
fun LastOrderWidget(trackingInfo: TrackingInfo) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White, shape = RoundedCornerShape(size = 10.dp))
            .padding(15.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(10.dp)
        ) {

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column {
                    Text(
                        text = "Shipment Number",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        color = Color.Black,
                        text = trackingInfo.shipmentNumber,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.pushing_truck),
                    contentDescription = "Pushing truck icon",
                    modifier = Modifier.size(40.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Divider(color = Color.LightGray, thickness = 0.5.dp)

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    IconButton(
                        onClick = {

                        },
                        modifier = Modifier
                            .background(veryLightOrangeColor, CircleShape)
                            .clip(CircleShape)
                            .size(30.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.present),
                            tint = orangeColor,
                            contentDescription = "sender icon",
                            modifier = Modifier.size(15.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(5.dp))

                    Column(
                        modifier = Modifier.padding(end = 16.dp)
                    ) {
                        Text(
                            text = "Sender",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )

                        Text(
                            text = trackingInfo.sender,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Black
                        )
                    }
                }

                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.width(100.dp)
                ) {

                    Text(
                        text = "Time",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )

                    Text(
                        text = trackingInfo.time,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Black
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Divider(color = Color.LightGray, thickness = 0.5.dp)

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    IconButton(
                        onClick = {

                        },
                        modifier = Modifier
                            .background(veryLightBlueColor, CircleShape)
                            .clip(CircleShape)
                            .size(30.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.present),
                            tint = orangeColor,
                            contentDescription = "sender icon",
                            modifier = Modifier.size(15.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(5.dp))

                    Column(
                        modifier = Modifier.padding(end = 16.dp)
                    ) {

                        Text(
                            text = "Receiver",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )

                        Text(
                            text = "Chicago, 6342",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Black
                        )
                    }
                }
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.width(100.dp)
                ) {
                    Text(
                        text = "Status",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )

                    Text(
                        text = trackingInfo.status,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Black
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Divider(color = Color.LightGray, thickness = 0.5.dp)

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                fontSize = 15.sp,
                text = "+ Add Stop",
                style = MaterialTheme.typography.bodySmall,
                color = orangeColor
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LastOrderPreview() {
    LastOrderWidget(
        trackingInfo = TrackingInfo(
            sender = "Atlanta, 5243",
            receiver = "Chicago, 6342",
            status = "Waiting to collect",
            time = "2 days -3 days"
        )
    )
}