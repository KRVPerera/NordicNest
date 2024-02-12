package com.krvperera.nordicnest

import android.content.ContentResolver
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun rememberResourceUri(resourceId: Int): Uri {
    val context = LocalContext.current

    return remember(resourceId) {
        with(context.resources) {
            Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(getResourcePackageName(resourceId))
                .appendPath(getResourceTypeName(resourceId))
                .appendPath(getResourceEntryName(resourceId))
                .build()
        }
    }
}

@Composable
fun SettingsScreen(navController: NavController) {
//    var isInternetPermissionGiven by remember { mutableStateOf(false) }
    Column (modifier = Modifier.padding(all = 8.dp)) {
        Title("Settings")
        Spacer(modifier = Modifier.height(8.dp))
        Column (modifier = Modifier.align(Alignment.CenterHorizontally)) {
            ProfilePicture()
        }
        Spacer(modifier = Modifier.fillMaxSize(0.5f))
        NavButtons(navController, "SETTINGS")
    }
}


