package com.lovisgod.movemate.di


import com.lovisgod.movemate.data.dataRepository.DataRepo
import com.lovisgod.movemate.data.dataSource.DataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoveMateModule {



    @Provides
    @Singleton
    fun provideAppDataSource() : DataSource {
        return DataSource()
    }

    @Provides
    @Singleton
    fun provideAppRepository(dataSource: DataSource) : DataRepo {
        return DataRepo(dataSource = dataSource)
    }

}