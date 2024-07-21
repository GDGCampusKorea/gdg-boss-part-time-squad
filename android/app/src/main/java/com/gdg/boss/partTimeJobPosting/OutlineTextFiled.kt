package com.gdg.boss.partTimeJobPosting

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlineTextFiled(
    modifier: Modifier,
    label: String,
    value: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.White,
            errorBorderColor = Color.Red,
            disabledTextColor = Color.Gray,
            disabledBorderColor = Color.Gray,
            unfocusedBorderColor = Color.Gray,
            focusedBorderColor = Color.Gray,
        ),
        label = { Text(text = label) },
        shape = RoundedCornerShape(8.dp),
        visualTransformation = visualTransformation
    )
}