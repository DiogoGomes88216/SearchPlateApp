package com.example.searchplate.presentation.plateScanner

import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.example.searchplate.data.PlateScannerRepository
import com.example.searchplate.presentation.crop
import com.example.searchplate.presentation.rotate
import com.google.android.gms.vision.Frame

class LicensePlateImageAnalyzer (
    private val repo: PlateScannerRepository,
    private val onResults: (String) -> Unit,
) : ImageAnalysis.Analyzer {

    private var frameSkipCounter = 0


    override fun analyze(image: ImageProxy) {
        if(frameSkipCounter % 20 == 0) {

            //rotate
            val rotationDegrees = image.imageInfo.rotationDegrees
            val bitmap = image.toBitmap()
                .rotate(rotationDegrees)

            // Detector
            val boundingBox = repo.detect(bitmap)

            if(boundingBox != null)
            {
                val recon = repo.characterRecognition(
                    bitmap.crop(boundingBox)
                )
                //String Check
                if(recon != null)
                {
                    val plate = repo.formatPtLicensePlate(recon)
                    if (plate != null) {
                        onResults(plate)
                    }
                }
            }
        }

        frameSkipCounter++
        image.close()
    }
}