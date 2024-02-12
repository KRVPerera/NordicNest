package com.krvperera.nordicnest

import android.Manifest
import android.content.ContentResolver
import android.net.Uri
import android.service.quicksettings.Tile
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
fun ProfilePicture() {
    var fabHeight by remember { mutableStateOf(0.dp) }
    val context = LocalContext.current
    val targetFile = File(context.filesDir, "user-profile.jpg")
    var imageRequest by remember {
        mutableStateOf<ImageRequest>(
            ImageRequest.Builder(context)
                .data(Uri.fromFile(targetFile))
                .data(if (targetFile.exists()) Uri.fromFile(targetFile) else R.drawable.me)
                .build()
        )
    }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri: Uri? ->
            uri?.let {
                val saveTarget = File(context.filesDir, "user-profile.jpg")
                context.contentResolver.openInputStream(uri).use { inputStream ->
                    saveTarget.outputStream().use { fileOutputStream ->
                        inputStream?.copyTo(fileOutputStream)
                    }
                }
                // Update the imageRequest to reflect the new image
                imageRequest = ImageRequest.Builder(context)
                    .data(Uri.fromFile(saveTarget))
                    .build()
            }
        })

    Column() {
//    Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
        SubcomposeAsyncImage(
            model = imageRequest,
            loading = {
                CircularProgressIndicator()
            },
            contentScale = ContentScale.FillWidth,
            contentDescription = "Asd",
            modifier = Modifier
                .size(300.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
                .align(Alignment.CenterHorizontally)
        )
        FloatingActionButton(
            shape = CircleShape,
            onClick = {
                imagePicker.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            },
            modifier = Modifier
                .onGloballyPositioned { coordinates ->
                    // Update the state with the height of the FAB
                    fabHeight = coordinates.size.height.dp
                }
                .offset(y = (-fabHeight / 2))
                .align(Alignment.CenterHorizontally)
        ) {
            Icon(Icons.Filled.Add, "Floating action button.")
        }
    }

//    fun checkPermissionForInternet(permission: String): Boolean {
//        return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
//    }
}


