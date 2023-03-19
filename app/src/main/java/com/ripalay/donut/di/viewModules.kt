package com.ripalay.donut.di

import com.ripalay.donut.ui.demo_task_fragment.DemoFragment
import com.ripalay.donut.ui.demo_task_fragment.DemoViewModel
import com.ripalay.donut.ui.home_fragment.HomeViewModel
import com.ripalay.donut.ui.my_tasks_fragment.MyTasksViewModel
import com.ripalay.donut.ui.profile_fragment.ProfileViewModel
import com.ripalay.donut.ui.reg_fragment.RegisterViewModel
import com.ripalay.donut.ui.sign_fragment.SignViewModel
import com.ripalay.donut.ui.start_fragment.StartViewModel
import com.ripalay.donut.ui.tasks_fragment.TasksViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModules: Module = module {
    viewModel { StartViewModel(get()) }
    viewModel { RegisterViewModel(get()) }
    viewModel { SignViewModel(get()) }
    viewModel { ProfileViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { TasksViewModel(get()) }
    viewModel { DemoViewModel(get()) }
    viewModel { MyTasksViewModel(get()) }

}