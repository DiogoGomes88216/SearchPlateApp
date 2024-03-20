package com.example.searchplate.navigation

internal sealed class Screens(val route: String) {
    object VehicleInfo: Screens("vehicle_info/{${PLATE_KEY}}") {
        fun createRoute(plate: String) = "vehicle_info/$plate"
    }
    object PlateScanner: Screens("plate_scanner")

    companion object {
        const val PLATE_KEY = "plate"
    }
}