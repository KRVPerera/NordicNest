package com.krvperera.nordicnest

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.krvperera.nordicnest.ui.theme.NordicNestTheme


@Composable
fun NavButtons(navController: NavController) {
    Surface {
        Row(
            modifier = Modifier.padding(all = 8.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Absolute.Left
        ) {
            Button(
                onClick = {
                    navController.navigate(Screen.MainScreen.route)
                },
                modifier = Modifier.align(Alignment.Bottom)
            ) {
                Text(text = "Home")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    navController.navigate(Screen.DetailedScreen.route)
                },
                modifier = Modifier.align(Alignment.Bottom)
            ) {
                Text(text = "Details")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    navController.navigate(Screen.DetailedScreen.route)
                },
                modifier = Modifier.align(Alignment.Bottom)
            ) {
                Text(text = "Settings")
            }
        }
    }
}

@Preview
@Composable
fun PreviewNavButtons() {
    val navController = rememberNavController()
    NordicNestTheme {
        NavButtons(navController)
    }
}