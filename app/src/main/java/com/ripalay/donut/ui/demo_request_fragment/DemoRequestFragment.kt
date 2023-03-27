package com.ripalay.donut.ui.demo_request_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.ripalay.donut.R
import com.ripalay.donut.core.models.Tasks
import com.ripalay.donut.core.ui.BaseFragment
import com.ripalay.donut.databinding.FragmentDemoRequestBinding
import com.ripalay.donut.ui.demo_task_fragment.DemoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DemoRequestFragment : BaseFragment<DemoViewModel,FragmentDemoRequestBinding>(R.layout.fragment_demo_request) {
    override val viewModel: DemoViewModel by viewModel()
    override val binding: FragmentDemoRequestBinding by viewBinding()

    var task: Tasks? = null
    val db = Firebase.firestore
    private lateinit var navController: NavController
    private lateinit var auth: FirebaseAuth

    override fun initNavController() {
        super.initNavController()
        navController = findNavController()
    }
    override fun initViews() {
        super.initViews()
        auth = FirebaseAuth.getInstance()
        task = requireArguments().getSerializable("task") as Tasks?
        binding.describeTv.text = task?.describe
        binding.tasksTv.text = task?.task
        binding.authorTv.text = task?.author
        binding.priceTv.text = task?.price.toString()

    }

    override fun initListeners() {
        super.initListeners()
        binding.acceptBtn.setOnClickListener {
            db.collection("tasks").add(task!!)
            db.collection("requestTasks").document(task!!.id.toString()).delete()
            navController.popBackStack()
        }
        binding.cancelBtn.setOnClickListener {
            db.collection("requestTasks").document(task!!.id.toString()).delete()
            navController.popBackStack()
        }
    }

}