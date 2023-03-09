package com.ripalay.donut.ui.profile_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.donut.R
import com.ripalay.donut.core.ui.BaseFragment
import com.ripalay.donut.databinding.FragmentProfileBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : BaseFragment<ProfileViewModel, FragmentProfileBinding>(R.layout.fragment_profile) {
    override val viewModel: ProfileViewModel by viewModel()
    override val binding: FragmentProfileBinding by viewBinding()

}