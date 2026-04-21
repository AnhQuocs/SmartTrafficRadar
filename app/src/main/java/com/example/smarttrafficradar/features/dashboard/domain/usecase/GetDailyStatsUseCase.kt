package com.example.smarttrafficradar.features.dashboard.domain.usecase

import com.example.smarttrafficradar.features.dashboard.domain.model.DailyStats
import com.example.smarttrafficradar.features.dashboard.domain.repository.DailyStatsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDailyStatsUseCase @Inject constructor(
    private val repository: DailyStatsRepository
) {
    operator fun invoke(nodeId: String, date: String): Flow<DailyStats> {
        return repository.getDailyStatsFlow(nodeId, date)
    }
}