package com.ripalay.donut.ui.sign_fragment

import android.util.Log
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ripalay.donut.R
import com.ripalay.donut.core.ui.BaseFragment
import com.ripalay.donut.databinding.FragmentSignBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignFragment : BaseFragment<SignViewModel, FragmentSignBinding>(R.layout.fragment_sign) {
    private lateinit var navController: NavController

    override val viewModel: SignViewModel by viewModel()
    override val binding: FragmentSignBinding by viewBinding()

    override fun initNavController() {
        super.initNavController()
        navController = findNavController()

    }

    override fun initListeners() {
        super.initListeners()
        binding.registrTv.setOnClickListener {
            navController.popBackStack()
            navController.navigate(R.id.registerFragment)
        }
        binding.signInBtn.setOnClickListener {
            navController.popBackStack()
            navController.navigate(R.id.homeFragment)
        }
    }
}