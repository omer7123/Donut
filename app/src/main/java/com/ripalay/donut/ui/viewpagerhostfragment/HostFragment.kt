package com.ripalay.donut.ui.viewpagerhostfragment

import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.ripalay.donut.R
import com.ripalay.donut.core.ui.BaseFragment
import com.ripalay.donut.databinding.FragmentHostBinding
import com.ripalay.donut.ui.demo_task_fragment.DemoViewModel
import com.ripalay.donut.ui.my_tasks_fragment.MyTasksFragment
import com.ripalay.donut.ui.reg_fragment.RegisterFragment
import com.ripalay.donut.ui.requests_tasks_fragment.RequestTasksFragment
import com.ripalay.donut.ui.tasks_fragment.TasksFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class HostFragment : BaseFragment<HostViewModel, FragmentHostBinding>(R.layout.fragment_host) {


    override val viewModel: HostViewModel by viewModel()
    override val binding: FragmentHostBinding by viewBinding()

    private val adapter: ViewPagerAdapter by lazy { ViewPagerAdapter(this) }
    private lateinit var tabLayout: TabLayout
    private val tabNames: Array<String> = arrayOf(
        "Задачи",
        "Созданные",
        "Запросы"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initFragment()
        //adapter.ref()
    }

    override fun initViews() {
        super.initViews()
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager){tab, position->
            tab.text = tabNames[position]
        }.attach()

    }


    private fun initFragment() {
        adapter.list.add(TasksFragment())
        adapter.list.add(MyTasksFragment())
        adapter.list.add(RequestTasksFragment())
    }
}