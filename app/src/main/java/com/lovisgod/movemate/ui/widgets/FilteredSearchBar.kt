package com.lovisgod.movemate.ui.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lovisgod.movemate.ui.icons.Scan

@Composable
fun FilteredSearchBar(query: String, onQueryChanged: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        GenericInputField(
            header = "Sample header",
            footer = "Tap dropdown to see lists of route",
            inputWidth = 288.dp,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, capitalization = KeyboardCapitalization.Characters),
            hint = "Enter your receipt number ...",
            leftIcon = Icons.Default.Search,
            rightIcon = Scan,
            text = query,
            onInputValueChange = {
                onQueryChanged(it)
            },
        )

    }
}

@Preview(showBackground = true)
@Composable
fun FilteredSearchBarPreview() {
    FilteredSearchBar(query = "NIJK", onQueryChanged = {})
}
