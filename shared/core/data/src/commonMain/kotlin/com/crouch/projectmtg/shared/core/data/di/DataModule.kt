package com.crouch.projectmtg.shared.core.data.di

import com.crouch.projectmtg.shared.core.dataStore.di.DataStoreModule
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Configuration
import org.koin.core.annotation.Module

@Module(includes = [DataStoreModule::class])
@Configuration
@ComponentScan("com.crouch.projectmtg.shared.core.data")
class DataModule
