package com.example.searchplate.data

import android.graphics.Bitmap
import android.graphics.Rect
import androidx.core.graphics.toRect
import com.google.android.gms.vision.Frame
import com.google.android.gms.vision.text.TextRecognizer
import org.tensorflow.lite.support.image.ImageProcessor
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.task.vision.detector.ObjectDetector
import javax.inject.Inject

class PlateScannerRepository @Inject constructor(
    private val detector: ObjectDetector,
    private val textRecognizer: TextRecognizer,
    private val imageProcessor: ImageProcessor
) {

    fun detect(bitmap: Bitmap): Rect? {

        val tensorImage = imageProcessor.process(TensorImage.fromBitmap(bitmap))
        val results = detector.detect(tensorImage)

        return  results.firstOrNull()?.boundingBox?.toRect()
    }

    fun characterRecognition(bitmap: Bitmap): String? {

        val frame = Frame.Builder().setBitmap(bitmap).build()
        val items = textRecognizer.detect(frame)

        return items.takeIf { items.size() > 0 }?.valueAt(0)?.value
    }


    fun formatPtLicensePlate(input: String): String? {

        val pattern = Regex(
            "[A-Z]{2}\\d{2}\\d{2}|" + //Until 1992
                "\\d{2}\\d{2}[A-Z]{2}|" + //1992 - 2005
                "\\d{2}[A-Z]{2}\\d{2}|" + //2005 - 2020
                "[A-Z]{2}\\d{2}[A-Z]{2}" //2020 Onwards
        )
        val cleaned = input
            .replace("-", "")
            .replace(" ", "")

        val matchResult = pattern.find(cleaned)

        return matchResult?.value?.chunked(2)?.joinToString(separator = "-")
    }
}