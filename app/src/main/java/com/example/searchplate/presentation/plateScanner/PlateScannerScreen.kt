package com.example.searchplate.presentation.plateScanner

import android.Manifest
import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PlateScannerScreen(
    viewModel: PlateScannerViewModel = hiltViewModel(),
    onFinishScanning: (String) -> Unit,
    onNavigateBack: () -> Unit
) {
    val uiState by viewModel.plateScannerState.collectAsState()
    val finishedScan by viewModel.finishedScan.collectAsState()

    LaunchedEffect(key1 = finishedScan){
        if(finishedScan){
            onFinishScanning(uiState.detection)
        }
    }


    val activity = LocalContext.current as Activity
    if(!viewModel.hasCameraPermission) {
        ActivityCompat.requestPermissions(
            activity, arrayOf(Manifest.permission.CAMERA), 0
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        CameraPreview(
            controller = viewModel.controller,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        ) {

            Text(
                text = uiState.detection,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(8.dp),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}

