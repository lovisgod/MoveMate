package com.lovisgod.movemate.data.dataRepository

import com.lovisgod.movemate.data.dataSource.DataSource

class DataRepo(val dataSource: DataSource) {

    fun getFreightOptions() = dataSource.getFrieghtsOption()
}