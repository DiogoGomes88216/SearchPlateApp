package com.example.searchplate.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun VehicleInfoScreen(
    viewModel: VehicleInfoViewModel = hiltViewModel(),
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
                        viewModel.onQueryChange(it)
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
                    onClick = { viewModel.onSearch(uiState.searchQuery) },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .weight(1f),
                ) {

                }
            }
            Text(
                text = "Marca : ${uiState.info.brand}",
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 1,
            )
            Text(
                text = "Vin : ${uiState.info.vin}",
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 1,
            )
        }
    }
}