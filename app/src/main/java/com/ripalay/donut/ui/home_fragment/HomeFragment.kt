package com.ripalay.donut.ui.home_fragment

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
import com.ripalay.donut.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(R.layout.fragment_home) {
    private lateinit var auth: FirebaseAuth
    private lateinit var adapter: HomeTasksAdapter
    private lateinit var navController: NavController

    val db = Firebase.firestore
    val a = Tasks(null, "Помой полы", "Илья", 100, "Помойте, пожалуйста, посуду до моего прихода. Я собираюсь готовить и мне нужна будет свободная раковина.", "all")
    override val viewModel: HomeViewModel by viewModel()
    override val binding: FragmentHomeBinding by viewBinding()

    override fun initNavController() {
        super.initNavController()
        navController = findNavController()
        auth = Firebase.auth
        val user = auth.currentUser

    }

    override fun initViews() {
        super.initViews()
        /*for (i in 0..4) {
             db.collection("tasks").add(a).addOnCompleteListener { documentReference ->
                 Log.e("TAG", "DocumentSnapshot added with ID: ")
             }.addOnFailureListener { e ->
                 Log.e("TAG", "Error adding document", e)
             }
         }*/
        initAdapter()

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

    override fun initListeners() {
        super.initListeners()
    }
    private fun initAdapter() {
        adapter = HomeTasksAdapter()
        binding.tasksRv.adapter = adapter
    }
}
