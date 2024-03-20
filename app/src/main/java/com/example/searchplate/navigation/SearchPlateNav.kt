package com.example.searchplate.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.searchplate.presentation.plateScanner.PlateScannerScreen
import com.example.searchplate.presentation.vehicleInfo.VehicleInfoScreen

@Composable
fun SearchPlateNav() {
    val navController = rememberNavController()
    NavHost(
        navController,
        startDestination = Screens.VehicleInfo.route
    ) {
        composable(
            route = Screens.VehicleInfo.route,
            arguments = listOf(
                navArgument(Screens.PLATE_KEY) {
                    type = NavType.StringType
                }
            )
        ) {
            VehicleInfoScreen(
                onNavigateToScanner = {
                    navController.navigate(Screens.PlateScanner.route)
                }
            )
        }

        composable(
            route = Screens.PlateScanner.route,
        ) {
            PlateScannerScreen(
                onFinishScanning = { plate ->
                    navController.navigate(Screens.VehicleInfo.createRoute(plate))
                },
                onNavigateBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}