package com.krvperera.nordicnest

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.krvperera.nordicnest.ui.theme.NordicNestTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


@Composable
fun SettingsScreen(navController: NavController) {
    var fabHeight by remember { mutableStateOf(0.dp) }
    Column (modifier = Modifier.padding(all = 8.dp)) {
        Title("Settings")
        Spacer(modifier = Modifier.height(8.dp))
        Column (modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Image(
                painter = painterResource(R.drawable.me),
                contentDescription = null,
                modifier = Modifier
                    .size(300.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
                    .align(Alignment.CenterHorizontally)
            )
            FloatingActionButton(
                shape = CircleShape,
                onClick = {},
                modifier = Modifier.onGloballyPositioned { coordinates ->
                    // Update the state with the height of the FAB
                    fabHeight = coordinates.size.height.dp
                }.offset(y = (-fabHeight/2))
                    .align(Alignment.CenterHorizontally)
            ) {
            Icon(Icons.Filled.Add, "Floating action button.")
        }
        }
        Spacer(modifier = Modifier.fillMaxSize(0.5f))
        NavButtons(navController, "SETTINGS")
    }
}

@Composable
@Preview
fun PreviewSettingsScreen() {
    NordicNestTheme {
        val navController = rememberNavController()
        // A surface container using the 'background' color from the theme
        Surface {
            SettingsScreen(navController)
        }
    }
}