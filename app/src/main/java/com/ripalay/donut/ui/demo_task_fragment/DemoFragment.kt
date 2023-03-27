package com.ripalay.donut.ui.demo_task_fragment

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.firebase.auth.FirebaseAuth
import com.ripalay.donut.R
import com.ripalay.donut.core.models.Tasks
import com.ripalay.donut.core.ui.BaseFragment
import com.ripalay.donut.databinding.FragmentDemoBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DemoFragment : BaseFragment<DemoViewModel, FragmentDemoBinding>(R.layout.fragment_demo) {
    private lateinit var auth: FirebaseAuth
    private lateinit var navController: NavController
    override val viewModel: DemoViewModel by viewModel()
    override val binding: FragmentDemoBinding by viewBinding()

    override fun initNavController() {
        super.initNavController()
        navController = findNavController()
    }
    override fun initViews() {
        super.initViews()
        auth = FirebaseAuth.getInstance()
        val task: Tasks? = requireArguments().getSerializable("task") as Tasks?
        binding.describeTv.text = task?.describe
        binding.tasksTv.text = task?.task
        binding.authorTv.text = task?.author
        binding.priceTv.text = task?.price.toString()

    }

    override fun initListeners() {
        super.initListeners()

    }
}