package com.example.jetnote.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetnote.domain.model.NoteModel
import ui.components.ColorItem

@Composable
fun Note(
    item: NoteModel
) {
    val backgroundShape: Shape = RoundedCornerShape(4.dp);
    Row(
        modifier = Modifier
            .padding(7.dp)
            .shadow(1.dp, backgroundShape)
            .fillMaxWidth()
            .heightIn(min = 64.dp)
            .background(
                Color.White, backgroundShape
            )
    )
    {
        ColorItem(color = item.color, onColorSelect = {})
        Column(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = item.title,
                maxLines = 1,
                color = Color.Black,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    letterSpacing = 0.15.sp
                )
            )
            Text(
                text = item.content,
                maxLines = 1,
                color = Color.Black.copy(alpha = 0.75f),
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    letterSpacing = 0.25.sp
                )
            )

        }
        Checkbox(
            checked = item.isCheckedOff ?: false,
            onCheckedChange = {},
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NotePreview() {
    Note(NoteModel(3, "hgfhgf", "fgdfg"))
}