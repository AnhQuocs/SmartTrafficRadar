package com.example.smarttrafficradar.features.dashboard.di

import com.example.smarttrafficradar.features.dashboard.data.repository.DailyStatsRepositoryImpl
import com.example.smarttrafficradar.features.dashboard.domain.repository.DailyStatsRepository
import com.google.firebase.database.FirebaseDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DailyStatsModule {

    @Binds
    @Singleton
    abstract fun bindDailyStatsRepository(
        dailyStatsRepositoryImpl: DailyStatsRepositoryImpl
    ): DailyStatsRepository

    companion object {

        @Provides
        @Singleton
        fun provideFirebaseDatabase(): FirebaseDatabase {
            return FirebaseDatabase.getInstance()
        }
    }
}