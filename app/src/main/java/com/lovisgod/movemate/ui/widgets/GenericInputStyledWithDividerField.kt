package com.lovisgod.movemate.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lovisgod.movemate.ui.theme.DarkGrey
import com.lovisgod.movemate.ui.theme.milkyWhiteColor
import com.lovisgod.movemate.ui.theme.orangeColor


@Composable
fun GenericInputWithStyledDividerField(
    header: String,
    footer: String? = "",
    hint: String,
    inputWidth: Dp,
    hintColor: Color? = Color.Gray,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions = KeyboardActions(),
    onInputValueChange:  (textInside: String) -> Unit,
    rightIcon: ImageVector?  = null,
    leftIcon: ImageVector?  = null,
    enable: Boolean = true,
    text: String = "",
    righIconClikced: () -> Boolean = { false },
    leftIconClicked: () -> Unit = {},
    readOnly: Boolean = false,
    modifier: Modifier = Modifier
) {
    var textState by remember { mutableStateOf(TextFieldValue(text.uppercase())) }
    var visualTransformation by remember { mutableStateOf(VisualTransformation.None) }
    return Column(
        modifier = modifier
            .fillMaxWidth()
            .offset(x = 0.dp, y = 0.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,

    ) {
            // Child views.
       BasicTextField (
        modifier = Modifier.fillMaxWidth(),
        value = textState,
        readOnly = readOnly,
        enabled = enable,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        onValueChange = { it: TextFieldValue ->
            textState = it
            onInputValueChange(it.text.uppercase())
        },
        visualTransformation = visualTransformation,
        decorationBox = { innerTextField ->
               Box(
                   modifier = Modifier
                       .fillMaxWidth()
                       .background(
                           color = Color(0xFFF3F5F6),
                           shape = RoundedCornerShape(size = 10.dp)
                       )
                       .border(
                           width = 0.5.dp,
                           color = Color(0xFFF3F5F6),
                           shape = RoundedCornerShape(size = 10.dp)
                       )
                       .padding(end = 16.dp, top = 12.dp, bottom = 12.dp), // inner padding
               ) {

                   Row(
                       verticalAlignment = Alignment.CenterVertically,
                       modifier = Modifier
                           .padding(start = 10.dp)
                           .align(Alignment.CenterStart)
                   ) {
                       if (leftIcon != null) {
                           IconButton(
                               onClick = {
                                   leftIconClicked()
                               },
                               modifier = Modifier
                                   .size(24.dp)
                           ) {
                               Icon(
                                   tint = Color.Gray,
                                   imageVector = leftIcon,
                                   contentDescription = "left icon",
                               )
                           }
                       }
                       Spacer(modifier = Modifier.width(8.dp))
                       Box(
                           modifier = Modifier
                               .width(1.dp)
                               .height(24.dp)
                               .background(color = Color.Gray)
                       )
                       Spacer(modifier = Modifier.width(8.dp))


                       if (text.isEmpty()) {
                           Text(
                               text = hint,
                               fontSize = 12.sp,
                               fontWeight = FontWeight.Normal,
                               color = hintColor ?: Color.Gray
                           )
                       }
                   }


                   if (rightIcon != null) {
                       IconButton(
                           onClick = {

                           },
                           modifier = Modifier
                               .align(Alignment.CenterEnd)
                               .size(30.dp)
                       ) {
                           Icon(
                               imageVector = rightIcon,
                               contentDescription = "right icon",
                               modifier = Modifier.size(20.dp)
                           )
                       }
                   }
                   Box(modifier = Modifier.padding(start = 45.dp, end = 5.dp).align(Alignment.CenterStart)) {
                       innerTextField()
                   }
               }
           }
      )
    }
}



@Preview(showBackground = true)
@Composable
fun GenericInputWithStyledDividerFieldPreview() {
    GenericInputWithStyledDividerField(
      header = "Sample header",
      footer = "Tap dropdown to see lists of route",
      inputWidth = 288.dp,
      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
      hint = "Enter your email",
      leftIcon = Icons.Default.Search,
      rightIcon = Icons.Filled.ShoppingCart,
      onInputValueChange = {},

    )
}
