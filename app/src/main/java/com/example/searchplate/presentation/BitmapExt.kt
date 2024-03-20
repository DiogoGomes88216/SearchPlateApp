package com.example.searchplate.presentation

import android.graphics.Bitmap
import android.graphics.Matrix
import android.graphics.Rect
import kotlin.math.absoluteValue

fun Bitmap.crop(boundingRect: Rect): Bitmap {

    if(boundingRect.left < 0 || boundingRect.top < 0 || boundingRect.bottom < 0 || boundingRect.right < 0) {
        boundingRect.left = 0
        boundingRect.top = 0
        boundingRect.bottom = 1
        boundingRect.right = 1

    }

    return Bitmap.createBitmap(
        this,
        boundingRect.left,
        boundingRect.top,
        boundingRect.width(),
        boundingRect.height()
    )
}

fun Bitmap.rotate(degrees: Int): Bitmap {
    val matrix = Matrix().apply { postRotate(degrees.toFloat()) }
    return Bitmap.createBitmap(this, 0, 0, width, height, matrix, true)
}