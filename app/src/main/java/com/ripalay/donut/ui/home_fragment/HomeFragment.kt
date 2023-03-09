package com.ripalay.donut.ui.home_fragment

import android.util.Log
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ripalay.donut.R
import com.ripalay.donut.core.ui.BaseFragment
import com.ripalay.donut.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(R.layout.fragment_home) {
    private lateinit var auth: FirebaseAuth

    override val viewModel: HomeViewModel by viewModel()
    override val binding: FragmentHomeBinding by viewBinding()

    override fun initNavController() {
        super.initNavController()
        auth = Firebase.auth
        val user = auth.currentUser
        Log.e("requireContext()", user?.uid.toString())
    }
}