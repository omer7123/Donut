package com.ripalay.donut.ui.reg_fragment

import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.donut.R
import com.ripalay.donut.core.ui.BaseFragment
import com.ripalay.donut.databinding.FragmentRegisterBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterFragment : BaseFragment<RegisterViewModel, FragmentRegisterBinding>(R.layout.fragment_register) {
    private lateinit var navController: NavController
    override val viewModel: RegisterViewModel by viewModel()
    override val binding: FragmentRegisterBinding by viewBinding()

    override fun initNavController() {
        super.initNavController()
        navController = findNavController()
    }

    override fun initListeners() {
        super.initListeners()
        binding.signinTv.setOnClickListener {
            navController.popBackStack()
            navController.navigate(R.id.signFragment)
        }
    }
}