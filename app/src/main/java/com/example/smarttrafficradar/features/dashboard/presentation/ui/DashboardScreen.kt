package com.example.smarttrafficradar.features.dashboard.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.smarttrafficradar.features.dashboard.presentation.viewmodel.DailyStatsViewModel

@Composable
fun DashboardScreen(
    dailyStatsViewModel: DailyStatsViewModel = hiltViewModel()
) {
    val dailyStatsState by dailyStatsViewModel.dailyStatsState.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        DashboardSection(state = dailyStatsState)
    }
}