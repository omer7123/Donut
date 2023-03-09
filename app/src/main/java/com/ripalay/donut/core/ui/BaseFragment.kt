package com.ripalay.donut.core.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding>(layoutID: Int)
    : Fragment(layoutID) {

    protected abstract val viewModel: VM
    protected abstract val binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavController()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
        initListeners()
    }

    open fun initNavController() {}

    open fun initViews() {}

    open fun initListeners() {}

    open fun initObservers() {}
}