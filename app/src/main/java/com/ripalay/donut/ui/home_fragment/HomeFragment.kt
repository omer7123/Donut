package com.ripalay.donut.ui.home_fragment

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
import com.ripalay.donut.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(R.layout.fragment_home) {
    private lateinit var auth: FirebaseAuth
    private lateinit var adapter: HomeTasksAdapter
    private lateinit var navController: NavController

    val db = Firebase.firestore
    val a = Tasks(
        null,
        "Запрос",
        "Илья",
        200,
        "Помойте, пожалуйста, посуду до моего прихода. Я собираюсь готовить и мне нужна будет свободная раковина.",
        "all"
    )
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
        /*for (i in 0..10) {
            a.task = a.task+i
            db.collection("requestTasks").add(a).addOnCompleteListener { documentReference ->
                Log.e("TAG", "DocumentSnapshot added with ID: ")
                a.id = documentReference.getResult().id
                db.collection("requestTasks").document(a.id.toString()).update("id",a.id)
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

    private fun initAdapter() {
        adapter = HomeTasksAdapter(this::clickListener)
        binding.tasksRv.adapter = adapter
    }
    fun clickListener(tasks: Tasks) {
        val bundle = Bundle()
        bundle.putSerializable("task", tasks)
        navController.navigate(R.id.demoFragment, bundle)
    }
}


