package com.lovisgod.movemate.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.lovisgod.movemate.data.model.TabItem
import com.lovisgod.movemate.ui.theme.LightGrey
import com.lovisgod.movemate.ui.theme.PurpleBackground
import com.lovisgod.movemate.ui.theme.WhiteText
import com.lovisgod.movemate.ui.theme.orangeColor

@Composable
fun ShipmentsTabs(
    tabs: List<TabItem>,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    ScrollableTabRow(
        modifier = Modifier.background(color = PurpleBackground),
        containerColor = PurpleBackground,
        selectedTabIndex = selectedTabIndex,
        edgePadding = 8.dp,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                color = orangeColor // Your purple color
            )
        },
    ) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { onTabSelected(index) },
                text = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = tab.title, color = WhiteText)
                        Spacer(modifier = Modifier.width(4.dp))
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(if (selectedTabIndex == index) orangeColor else Color.Gray) // Orange background
                                .padding(horizontal = 6.dp)
                        ) {
                            Text(text = tab.count.toString(), color = Color.White)
                        }
                    }
                },
                selectedContentColor = WhiteText,
                unselectedContentColor = WhiteText
            )
        }
    }
}
