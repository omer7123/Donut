package com.ripalay.donut.ui.create_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.donut.R
import com.ripalay.donut.core.ui.BaseFragment
import com.ripalay.donut.databinding.FragmentCreateTaskBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateTaskFragment : BaseFragment<CreateViewModel, FragmentCreateTaskBinding>(R.layout.fragment_create_task) {
    override val viewModel: CreateViewModel by viewModel()
    override val binding: FragmentCreateTaskBinding by viewBinding()


}

