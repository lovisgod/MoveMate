package com.lovisgod.movemate.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lovisgod.movemate.R
import com.lovisgod.movemate.data.model.ShipmentItem
import com.lovisgod.movemate.data.model.ShipmentStatus
import com.lovisgod.movemate.ui.icons.History
import com.lovisgod.movemate.ui.theme.DarkGrey
import com.lovisgod.movemate.ui.theme.LightPurple
import com.lovisgod.movemate.ui.theme.WhiteText

@Composable
fun ShipmentCard(item: ShipmentItem) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = WhiteText)
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = WhiteText)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Status Tag
            Column(
                modifier = Modifier.weight(1f)
            ) {
                ShipmentStatusTag(status = item.status, item.imageRes)
                Spacer(modifier = Modifier.width(10.dp))
                // Title
                Text(text = item.title, style = MaterialTheme.typography.titleMedium)
                // Description
                Text(text = item.description, style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.width(240.dp))
                Spacer(modifier = Modifier.height(8.dp))
                // Amount and Date
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = item.amount, style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold), color = LightPurple)
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(text = item.date, style = MaterialTheme.typography.bodySmall, color = DarkGrey)
                }
            }

            // Image
            Image(
                painter = painterResource(id = R.drawable.shipment_icon),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
        }
    }
}

@Preview
@Composable
fun ShipmentCardPreview() {
    ShipmentCard(
        ShipmentItem(
            status = ShipmentStatus.Loading,
            title = "Arriving today",
            description = "This is a sample description and it will be as long as this possibly",
            amount = "$550 USD",
            date = "Sep 20,2024",
            imageRes = History
        )
    )
}
