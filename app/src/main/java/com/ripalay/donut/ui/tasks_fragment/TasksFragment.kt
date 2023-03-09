package com.ripalay.donut.ui.tasks_fragment

import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.donut.R
import com.ripalay.donut.core.ui.BaseFragment
import com.ripalay.donut.databinding.FragmentTasksBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TasksFragment : BaseFragment<TasksViewModel, FragmentTasksBinding>(R.layout.fragment_tasks) {
    override val viewModel: TasksViewModel by viewModel()
    override val binding: FragmentTasksBinding by viewBinding()


}