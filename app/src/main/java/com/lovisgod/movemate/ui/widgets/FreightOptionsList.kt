package com.lovisgod.movemate.ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.lovisgod.movemate.data.model.FreightOption

@Composable
fun FreightOptionsList(freightOptions: List<FreightOption>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(freightOptions.size) { index ->
            FreightOptionItem(freightOption = freightOptions[index])
        }
    }
}
