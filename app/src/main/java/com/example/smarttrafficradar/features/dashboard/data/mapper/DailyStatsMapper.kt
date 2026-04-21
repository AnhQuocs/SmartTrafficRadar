package com.example.smarttrafficradar.features.dashboard.data.mapper

import com.example.smarttrafficradar.features.dashboard.data.dto.DailyStatsDto
import com.example.smarttrafficradar.features.dashboard.domain.model.DailyStats

fun DailyStatsDto.toDomain(nodeId: String, date: String): DailyStats {
    return DailyStats(
        nodeId = nodeId,
        date = date,
        averageSpeed = average_speed ?: 0.0,
        peakHour = peak_hour ?: "N/A",
        totalVehicles = total_vehicles ?: 0,
        totalViolations = total_violations ?: 0
    )
}