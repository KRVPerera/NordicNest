package com.krvperera.nordicnest

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.krvperera.nordicnest.ui.theme.NordicNestTheme

@Composable
fun DetailedScreen(navController: NavController) {
    Column (modifier = Modifier.padding(all = 8.dp)) {
        Title("Details")
        Spacer(modifier = Modifier.fillMaxSize(0.9f))
        NavButtons(navController, "DETAILED")
    }
}

@Composable
@Preview
fun PreviewDetailedScreen() {
    NordicNestTheme {
        val navController = rememberNavController()
        // A surface container using the 'background' color from the theme
        Surface {
            DetailedScreen(navController)
        }
    }
}