package com.example.smarttrafficradar.features.dashboard.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.smarttrafficradar.components.AppHeader
import com.example.smarttrafficradar.features.dashboard.presentation.viewmodel.DailyStatsState
import com.example.smarttrafficradar.ui.dimens.AppSpacing
import com.example.smarttrafficradar.ui.dimens.Dimen

@Composable
fun DashboardSection(state: DailyStatsState) {
    when (state) {
        is DailyStatsState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                FivePetalSpiralLoader()
            }
        }

        is DailyStatsState.Success -> {
            val dailyStats = state.data

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = Dimen.PaddingM),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DashboardHeader()

                RadarView()


            }
        }

        is DailyStatsState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                AppHeader(
                    text = state.uiText.asString(),
                    color = Color.Red
                )
            }
        }
    }
}