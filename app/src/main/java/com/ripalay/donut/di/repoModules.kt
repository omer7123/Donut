package com.ripalay.donut.di

import com.ripalay.donut.core.repository.Repository
import org.koin.core.module.Module
import org.koin.dsl.module

val repoModules: Module = module {
    single { Repository() }
}