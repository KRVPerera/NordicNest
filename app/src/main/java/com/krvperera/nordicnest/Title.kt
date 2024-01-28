package com.krvperera.nordicnest

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.krvperera.nordicnest.ui.theme.NordicNestTheme

@Composable
fun Title(title: String) {
    Surface(
        shadowElevation = 1.dp,
        color = MaterialTheme.colorScheme.inversePrimary,
        modifier = Modifier
            .animateContentSize()
            .padding(1.dp)
    ) {
        Text(
            text = "$title",
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun PreviewTitle() {
    NordicNestTheme {
        Title("This is my title")
    }
}