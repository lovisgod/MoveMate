package com.lovisgod.movemate.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lovisgod.movemate.data.model.ShipmentStatus
import com.lovisgod.movemate.ui.icons.History
import com.lovisgod.movemate.ui.screens.landingPageWithAppBar
import com.lovisgod.movemate.ui.theme.DarkGrey
import com.lovisgod.movemate.ui.theme.LightGrey

@Composable
fun ShipmentStatusTag(status: ShipmentStatus, imageVector: ImageVector) {
    Box(
        modifier = Modifier
            .background(color = Color.Gray, shape = RoundedCornerShape(12.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(imageVector = imageVector, contentDescription = status.label, modifier =  Modifier.size(10.dp))
            Spacer(modifier = Modifier.width(3.dp))
            Text(
                text = status.label,
                color = status.color,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

@Preview
@Composable
fun ShipmentStatusTagPreview() {
    ShipmentStatusTag(
        ShipmentStatus.Loading,
        imageVector = History
    )
}
