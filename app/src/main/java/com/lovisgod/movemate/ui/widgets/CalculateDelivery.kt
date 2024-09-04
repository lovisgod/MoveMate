package com.lovisgod.movemate.ui.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.runtime.Composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lovisgod.movemate.R
import com.lovisgod.movemate.data.model.ShipmentItem
import com.lovisgod.movemate.data.model.ShipmentStatus
import com.lovisgod.movemate.ui.icons.Archive
import com.lovisgod.movemate.ui.icons.Experiment
import com.lovisgod.movemate.ui.icons.History
import com.lovisgod.movemate.ui.theme.DarkGrey
import com.lovisgod.movemate.ui.theme.LightPurple
import com.lovisgod.movemate.ui.theme.WhiteText
import com.lovisgod.movemate.ui.theme.orangeColor

@Composable
fun ShippingCalculatorScreen(modifier: Modifier) {
    Column(
        modifier = Modifier
            .background(color = WhiteText)
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 75.dp)
    ) {
        Text(
            text = "Destination",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(15.dp))

        DestinationSection()

        PackagingSection()

        CategoriesSection()
        Button(onClick = {  },
            colors = ButtonDefaults.buttonColors(
                containerColor = orangeColor,
                contentColor = WhiteText
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    shape = RoundedCornerShape(30.dp),
                    color = orangeColor
                )) {
            Text(text = "Continue")
        }
    }
}



@Composable
fun DestinationSection() {
    Column(
        modifier = Modifier.padding(bottom = 16.dp)
    ) {

        GenericInputWithStyledDividerField(
            header = "Sample header",
            footer = "",
            inputWidth = 288.dp,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            hint = "Sender Location",
            leftIcon = Archive,
            onInputValueChange = {},
            )

        Spacer(modifier = Modifier.height(10.dp))


        GenericInputWithStyledDividerField(
            header = "Sample header",
            footer = "",
            inputWidth = 288.dp,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            hint = "Receiver Location",
            leftIcon = Archive,
            onInputValueChange = {},

            )

        Spacer(modifier = Modifier.height(10.dp))

        GenericInputWithStyledDividerField(
            header = "Sample header",
            footer = "",
            inputWidth = 288.dp,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            hint = "Approx Weight",
            leftIcon = Experiment,
            onInputValueChange = {},

            )
    }
}

@Composable
fun PackagingSection() {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Select an option") }
    Column(
        modifier = Modifier.padding(bottom = 16.dp)
    ) {
        Text(
            text = "Packaging",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold
            )
        )

        Text(
            text = "What are you Sending",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(10.dp))
        GenericInputWithStyledDividerField(
            header = "Sample header",
            footer = "Tap dropdown to see lists of route",
            inputWidth = 288.dp,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            hint = "Box",
            hintColor = Color.Black,
            enable = false,
            leftIcon = Icons.Default.Search,
            rightIcon = Icons.Outlined.KeyboardArrowDown,
            onInputValueChange = {},

            )
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun CategoriesSection() {
    var selectedChips by remember { mutableStateOf(setOf<String>()) }
    var isVisible by remember { mutableStateOf(false) }

    val chipOptions = listOf("Documents", "Glass", "Liquid", "Food", "Electronic", "Product", "Others")
    Column(
        modifier = Modifier.padding(bottom = 16.dp)
    ) {
        Text(
            text = "Categories",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold
            ),
            color = Color.Black,
        )

        Text(
            text = "What are you Sending",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(10.dp))

        LaunchedEffect(Unit) {
            isVisible = true
        }
        FlowRow(
            modifier = Modifier.width(350.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            chipOptions.forEachIndexed { index, option ->
                AnimatedVisibility(
                    visible = isVisible,
                    enter = slideInHorizontally(
                        initialOffsetX = { fullWidth -> fullWidth + (index * 20) },
                        animationSpec = tween(durationMillis = 400)
                    )
                ) {
                FilterChip(
                    modifier = Modifier.animateContentSize(),
                    label = { Text(text = option) },
                    leadingIcon = if (selectedChips.contains(option)) {
                        {
                            Icon(
                                imageVector = Icons.Filled.Done,
                                contentDescription = "Done icon",
                                modifier = Modifier.size(FilterChipDefaults.IconSize)
                            )
                        }
                    } else {
                        null
                    },
                    selected = selectedChips.contains(option),
                    onClick = {
                        selectedChips = if (selectedChips.contains(option)) {
                            selectedChips - option
                        } else {
                            selectedChips + option
                        }
                    }
                )}
            }
        }

            // Add more chips for other categories
        }
    }

@Preview
@Composable
fun PreviewCalculateDelivery() {
    ShippingCalculatorScreen(modifier = Modifier)
}