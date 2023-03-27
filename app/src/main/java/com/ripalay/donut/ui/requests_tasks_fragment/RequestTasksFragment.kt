package com.ripalay.donut.ui.requests_tasks_fragment

import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.ripalay.donut.R
import com.ripalay.donut.core.models.Tasks
import com.ripalay.donut.core.ui.BaseFragment
import com.ripalay.donut.databinding.FragmentRequestTasksBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RequestTasksFragment :
    BaseFragment<RequestTasksViewModel, FragmentRequestTasksBinding>(R.layout.fragment_request_tasks) {
    override val viewModel: RequestTasksViewModel by viewModel()
    override val binding: FragmentRequestTasksBinding by viewBinding()
    private val list: ArrayList<Tasks> = ArrayList<Tasks>()

    val db = Firebase.firestore
    private lateinit var adapter: RequestTasksAdapter
    private lateinit var navController: NavController

    override fun initNavController() {
        super.initNavController()
        navController = findNavController()
    }

    override fun initViews() {
        super.initViews()
        initAdapter()

    }

    override fun initObservers() {
        super.initObservers()

        db.collection("requestTasks")
            .addSnapshotListener { snapshots, e ->
                list.clear()
                for (document in snapshots!!) {
                    val task = document.toObject(Tasks::class.java)
                    //Log.e("eeee", auth.currentUser?.displayName.toString())
                    //if ((task.recipient == "all") || (task.recipient == auth.currentUser?.email)) {
                    task.id = document.id
                    list?.add(task)
                    Log.e("ololo", list.toString())
                    //}
                }
                list?.let { adapter.addItems(it) }

            }
      /*  viewModel.getTasksRequest("requestTasks", db).observe(requireActivity()) {
            Log.e("viewModel", it.toString())
            val tasks = it
            if (tasks != null) {
                adapter.addItems(tasks)
            }
        }*/
    }

    private fun initAdapter() {
        adapter = RequestTasksAdapter(this::clickListener)
        binding.tasksRv.adapter = adapter

    }

    private fun clickListener(task: Tasks, status: Int) {
        when (status) {
            0 -> {
                db.collection("requestTasks").document(task.id.toString()).delete()
                }
            1 ->{
                db.collection("tasks").add(task)
                db.collection("requestTasks").document(task.id.toString()).delete()
            }
            2->{
                val bundle = Bundle()
                bundle.putSerializable("task", task)
                navController.popBackStack()
                navController.navigate(R.id.demoRequestFragment, bundle)
            }
        }
    }

}