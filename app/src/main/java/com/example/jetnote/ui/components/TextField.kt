package com.example.jetnote.ui.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import com.example.jetnote.R


@Composable
fun MyTextField(label: String, field: MutableState<String>, type:KeyboardType) {
    val primaryColor = colorResource(id = R.color.colorPrimary)
    OutlinedTextField(
        value = field.value,
        onValueChange = {
            field.value = it
        },
        label = {
            Text(text = label)
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = type
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = primaryColor,
            unfocusedLabelColor = primaryColor,
            cursorColor = primaryColor
        )
    )
}