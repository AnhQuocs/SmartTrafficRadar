package com.example.smarttrafficradar.features.dashboard.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smarttrafficradar.R
import com.example.smarttrafficradar.features.dashboard.domain.model.DailyStats
import com.example.smarttrafficradar.features.dashboard.domain.usecase.GetDailyStatsUseCase
import com.example.smarttrafficradar.utils.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

sealed class DailyStatsState {
    object Loading : DailyStatsState()
    data class Success(val data: DailyStats) : DailyStatsState()
    data class Error(val uiText: UiText) : DailyStatsState()
}

@HiltViewModel
class DailyStatsViewModel @Inject constructor(
    private val getDailyStatsUseCase: GetDailyStatsUseCase
) : ViewModel() {

    private val _dailyStatsState = MutableStateFlow<DailyStatsState>(DailyStatsState.Loading)
    val dailyStatsState = _dailyStatsState.asStateFlow()

    init {
        val today = LocalDate.now().toString()

        getDailyStats("radar_node_01", "2026-04-17")
    }

    fun getDailyStats(nodeId: String, date: String) {
        viewModelScope.launch {
            // 1. Bật trạng thái Loading mỗi khi bắt đầu gọi hàm
            _dailyStatsState.value = DailyStatsState.Loading

            // 2. Gọi Use Case và lắng nghe "dòng chảy" dữ liệu
            getDailyStatsUseCase(nodeId, date)
                .catch { e ->
                    _dailyStatsState.value = DailyStatsState.Error(
                        uiText = UiText.StringResource(R.string.error_unexpected)
                    )
                }
                .collect { data ->
                    // 4. Khi có dữ liệu mới đổ về, cập nhật trạng thái Success
                    _dailyStatsState.value = DailyStatsState.Success(data)
                }
        }
    }
}