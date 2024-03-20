package com.example.searchplate.presentation.plateScanner

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.example.searchplate.data.PlateScannerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PlateScannerViewModel @Inject constructor(
    @ApplicationContext context: Context,
    private val repository: PlateScannerRepository,
): ViewModel() {

    private val _plateScannerState = MutableStateFlow(PlateScannerState())
    val plateScannerState: StateFlow<PlateScannerState> by lazy {
        _plateScannerState
    }
    private var _finishedScan = MutableStateFlow(false)
    var finishedScan : StateFlow<Boolean> = _finishedScan.asStateFlow()

    val hasCameraPermission = ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED


    private val analyzer = LicensePlateImageAnalyzer(
        repo = repository,
        onResults = {result ->
            _plateScannerState.update { it.copy(detection = result) }
            _finishedScan.value = true
        }
    )

    val controller = LifecycleCameraController(context).apply {
        setEnabledUseCases(CameraController.IMAGE_ANALYSIS)
        setImageAnalysisAnalyzer(
            ContextCompat.getMainExecutor(context),
            analyzer
        )
    }

}