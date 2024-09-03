package com.lovisgod.movemate.data.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.lovisgod.movemate.ui.theme.PurpleBackground

data class ShipmentItem(
    val status: ShipmentStatus,
    val title: String,
    val description: String,
    val amount: String,
    val date: String,
    val imageRes: ImageVector // Resource ID for the image
)

enum class ShipmentStatus(val label: String, val color: Color) {
    InProgress("in-progress", Color(0xFF4CAF50)), // Green
    Pending("pending", Color(0xFFFFA726)),       // Orange
    Loading("loading", Color(0xFF42A5F5)),       // Blue
    Completed("completed", PurpleBackground)    // Grey
}
