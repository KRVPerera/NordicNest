package com.krvperera.nordicnest

import android.Manifest
import android.content.ContentResolver
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import java.io.File


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
//    fun checkPermissionForInternet(permission: String): Boolean {
//        return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
//    }
}


