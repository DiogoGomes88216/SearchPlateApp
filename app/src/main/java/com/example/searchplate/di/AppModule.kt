package com.example.searchplate.di

import android.content.Context
import com.example.searchplate.data.network.apis.PlateApi
import com.example.searchplate.data.network.apis.VinApi
import com.example.searchplate.util.Constants.INFO_URL
import com.example.searchplate.util.Constants.PLATE_URL
import com.google.android.gms.vision.text.TextRecognizer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.tensorflow.lite.support.image.ImageProcessor
import org.tensorflow.lite.task.core.BaseOptions
import org.tensorflow.lite.task.vision.detector.ObjectDetector
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesPlateApi(): PlateApi {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        return Retrofit.Builder()
            .baseUrl(PLATE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(PlateApi::class.java)
    }

    @Provides
    @Singleton
    fun providesVinApi(): VinApi {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        return Retrofit.Builder()
            .baseUrl(INFO_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(VinApi::class.java)
    }

    @Singleton
    @Provides
    fun providesTextRecognizer(
        @ApplicationContext appContext: Context,
    ): TextRecognizer {
        return TextRecognizer.Builder(appContext).build()
    }

    @Singleton
    @Provides
    fun providesImageProcessor(
    ): ImageProcessor{
        return ImageProcessor.Builder().build()
    }

    @Singleton
    @Provides
    fun providesPlateDetector(
        @ApplicationContext appContext: Context,
    ): ObjectDetector {

        val baseOptions = BaseOptions.builder()
            .setNumThreads(2)
            .useNnapi()
            .build()

        val options = ObjectDetector.ObjectDetectorOptions.builder()
            .setBaseOptions(baseOptions)
            .setMaxResults(1)
            .setScoreThreshold(0.7f)
            .build()

        return ObjectDetector.createFromFileAndOptions(
            appContext,
            "detect.tflite",
            options
        )
    }
}