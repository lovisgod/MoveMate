package com.lovisgod.movemate.data.model

data class TrackingInfo(
    val shipmentNumber: String = "N2389876676656545",
    val sender: String,
    val receiver: String,
    val time: String,
    val status: String
)