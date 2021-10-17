package com.example.jetnote.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.jetnote.R

@Composable
fun TopAppBar(
    title: String,
    icon: ImageVector,
    onIconClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.colorPrimary)),
    )
    {
        Button(
            onClick = onIconClick,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(
                    id = R.color.colorPrimary
                )
            ),
            border = null
        )
        {
            Image(
                imageVector = icon,
                contentDescription = "Drawer Header Icon",
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface),
                modifier = Modifier.padding(16.dp),
                )
        }
        Text(
            text = title,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Preview
@Composable
fun TopAppBarPreview() {
    TopAppBar(
        title = "JetNotes",
        icon = Icons.Filled.List,
        onIconClick = {}
    )
}