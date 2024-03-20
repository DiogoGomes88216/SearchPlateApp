package com.example.searchplate.presentation.vehicleInfo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage


@Composable
fun VehicleInfoScreen(
    viewModel: VehicleInfoViewModel = hiltViewModel(),
    onNavigateToScanner: () -> Unit
) {
    val uiState by viewModel.vehicleInfoState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ){

                OutlinedTextField(
                    value = uiState.searchQuery,
                    onValueChange = {
                        viewModel.onQueryChange(it.uppercase())
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .weight(2f),
                    placeholder = {
                        Text(text = "XX-XX-XX")
                    },
                    maxLines = 1,
                    singleLine = true,
                )
                Button(
                    onClick = {
                        if(uiState.searchQuery != "")
                            viewModel.onSearch(uiState.searchQuery)
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .weight(1f),
                    
                ) {
                    Icon(
                        Icons.Filled.Search,
                        contentDescription = "Search",
                        tint = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .size(32.dp)
                    )
                }

                Button(
                    onClick = {
                        onNavigateToScanner()
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .weight(1f),

                    ) {
                    Icon(
                        Icons.Filled.Camera,
                        contentDescription = "Search",
                        tint = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .size(32.dp)
                    )
                }
            }
            Text(
                text = "Vin : ${uiState.info.vin}",
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 1,
            )
            Text(
                text = "Marca : ${uiState.info.make}",
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 1,
            )
            Text(
                text = "Modelo : ${uiState.info.model}",
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 1,
            )
            Text(
                text = "Cilindrada : ${uiState.info.engineDisplCm3}",
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 1,
            )
            AsyncImage(
                model = uiState.info.logo,
                contentDescription = uiState.info.make,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    //.size(250.dp)
            )

            if(uiState.hasError)
            {
                Text(
                    text = "MSG : ${uiState.error?.message}",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                )
            }
        }
    }
}