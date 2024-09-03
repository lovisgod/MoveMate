package com.lovisgod.movemate.data.dataSource

import com.lovisgod.movemate.R
import com.lovisgod.movemate.data.model.FreightOption

class DataSource {

    fun getFrieghtsOption(): List<FreightOption> {
        return listOf(
            FreightOption("Ocean Freight", "International", R.drawable.sea_cargo),
            FreightOption("Cargo Freight", "Reliable", R.drawable.cargo_truck),
            FreightOption("Air Freight", "International", R.drawable.air_freight))
    }
}