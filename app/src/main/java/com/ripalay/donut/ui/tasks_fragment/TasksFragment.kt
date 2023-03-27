package com.ripalay.donut.ui.tasks_fragment

import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.ripalay.donut.R
import com.ripalay.donut.core.models.Tasks
import com.ripalay.donut.core.ui.BaseFragment
import com.ripalay.donut.databinding.FragmentTasksBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TasksFragment : BaseFragment<TasksViewModel, FragmentTasksBinding>(R.layout.fragment_tasks) {
    private lateinit var adapter: TasksAdapter
    private lateinit var navController: NavController
    val db = Firebase.firestore
    private lateinit var auth: FirebaseAuth



    override val viewModel: TasksViewModel by viewModel()
    override val binding: FragmentTasksBinding by viewBinding()

    override fun initNavController() {
        super.initNavController()
        navController = findNavController()
        auth = Firebase.auth
        val user = auth.currentUser
        Log.e("Start", "START")
    }

    override fun initViews() {
        super.initViews()
        initAdapter()
    }

    private fun initAdapter() {
        adapter = TasksAdapter(this::clickListener)
        binding.tasksRv.adapter = adapter
    }

    private fun clickListener(task:Tasks) {
        val bundle = Bundle()
        bundle.putSerializable("task", task)
        navController.popBackStack()
        navController.navigate(R.id.demoFragment, bundle)

    }

    override fun initObservers() {
        super.initObservers()
        viewModel.getTasks("tasks", db).observe(requireActivity()) {
            Log.e("viewModel", it.toString())
            val tasks = it
            if (tasks != null) {
                adapter.addItems(tasks)
            }
        }
    }
}