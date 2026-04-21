package com.example.smarttrafficradar.features.dashboard.domain.model

data class DailyStats(
    val nodeId: String,
    val date: String,
    val averageSpeed: Double,
    val peakHour: String,
    val totalVehicles: Int,
    val totalViolations: Int
)