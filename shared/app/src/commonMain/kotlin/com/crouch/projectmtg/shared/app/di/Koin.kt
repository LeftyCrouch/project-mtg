package com.crouch.projectmtg.shared.app.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Configuration
import org.koin.core.annotation.KoinApplication
import org.koin.core.annotation.Module
import org.koin.core.logger.Level
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.includes
import org.koin.plugin.module.dsl.startKoin

@KoinApplication
@ComponentScan("com.crouch.projectmtg")
class MTGApp

@Module
@Configuration
@ComponentScan("com.crouch.projectmtg.shared.app")
class AppModule

fun initKoin(configuration: KoinAppDeclaration? = null) {
    startKoin<MTGApp> {
        includes(configuration)
        printLogger(Level.DEBUG)
    }
}
