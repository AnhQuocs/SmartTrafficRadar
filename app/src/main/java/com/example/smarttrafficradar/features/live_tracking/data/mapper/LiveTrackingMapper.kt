package com.example.smarttrafficradar.features.live_tracking.data.mapper

import com.example.smarttrafficradar.features.live_tracking.data.dto.LiveTrackingDto
import com.example.smarttrafficradar.features.live_tracking.domain.model.LastVehicle
import com.example.smarttrafficradar.features.live_tracking.domain.model.LiveTracking

fun LiveTrackingDto.toDomain(nodeId: String): LiveTracking {
    val lastVehicle = latestVehicle?.let { dto ->
        LastVehicle(
            isViolation = dto.isViolation ?: false,
            speedKmh = dto.speedKmh ?: 0.0,
            timestamp = dto.timestamp ?: 0L,
            vehicleId = dto.vehicleId ?: "Unknown"
        )
    } ?: LastVehicle(
        isViolation = false,
        speedKmh = 0.0,
        timestamp = 0L,
        vehicleId = "No Data"
    )

    val recentSpeeds = recentVehicles?.values
        ?.filter { it.timestamp != null }
        ?.sortedByDescending { it.timestamp }
        ?.take(10)
        ?.map { it.speedKmh ?: 0.0 }
        ?.reversed()
        ?: emptyList()

    return LiveTracking(
        nodeId = nodeId,
        lastVehicle = lastVehicle,
        recentSpeeds = recentSpeeds
    )
}