package com.example.smarttrafficradar.features.dashboard.domain.repository

import com.example.smarttrafficradar.features.dashboard.domain.model.DailyStats
import kotlinx.coroutines.flow.Flow

interface DailyStatsRepository {
    fun getDailyStatsFlow(nodeId: String, date: String): Flow<DailyStats>
}