package com.lovisgod.movemate.data.dataSource

import androidx.compose.material.icons.Icons
import com.lovisgod.movemate.R
import com.lovisgod.movemate.data.model.FreightOption
import com.lovisgod.movemate.data.model.ShipmentItem
import com.lovisgod.movemate.data.model.ShipmentStatus
import com.lovisgod.movemate.ui.icons.Done_all
import com.lovisgod.movemate.ui.icons.Downloading
import com.lovisgod.movemate.ui.icons.History
import com.lovisgod.movemate.ui.icons.Progress_activity

class DataSource {

    fun getFrieghtsOption(): List<FreightOption> {
        return listOf(
            FreightOption("Ocean Freight", "International", R.drawable.sea_cargo),
            FreightOption("Cargo Freight", "Reliable", R.drawable.cargo_truck),
            FreightOption("Air Freight", "International", R.drawable.air_freight))
    }

    fun getShipments() : List<ShipmentItem> {
        val shipments = listOf(
            ShipmentItem(
                status = ShipmentStatus.InProgress,
                title = "Arriving today!",
                description = "Your delivery, #NEJ20089934122231 from Atlanta, is arriving today!",
                amount = "$1400 USD",
                date = "Sep 20, 2023",
                imageRes =  Progress_activity// Replace with your drawable
            ),
            ShipmentItem(
                status = ShipmentStatus.Pending,
                title = "Arriving today!",
                description = "Your delivery, #NEJ20089934122231 from Atlanta, is arriving today!",
                amount = "$650 USD",
                date = "Sep 20, 2023",
                imageRes = History // Replace with your drawable
            ),
            ShipmentItem(
                status = ShipmentStatus.Loading,
                title = "Arriving today!",
                description = "Your delivery, #NEJ20089934122231 from Atlanta, is arriving today!",
                amount = "$650 USD",
                date = "Sep 20, 2023",
                imageRes = Downloading // Replace with your drawable
            ),
            ShipmentItem(
                status = ShipmentStatus.Completed,
                title = "Arriving today!",
                description = "Your delivery, #NEJ20089934122233 from Atlanta, is arriving today!",
                amount = "$650 USD",
                date = "Sep 20, 2023",
                imageRes = Done_all // Replace with your drawable
            )
        )

        return shipments
    }
}