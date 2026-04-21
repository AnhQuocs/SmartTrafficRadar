package com.example.smarttrafficradar.features.dashboard.data.dto

data class DailyStatsDto(
    val average_speed: Double? = null,
    val peak_hour: String? = null,
    val total_vehicles: Int? = null,
    val total_violations: Int? = null
)