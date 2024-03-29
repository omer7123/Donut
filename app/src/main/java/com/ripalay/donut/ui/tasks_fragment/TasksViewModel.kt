package com.ripalay.donut.ui.tasks_fragment

import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.ripalay.donut.core.models.Tasks
import com.ripalay.donut.core.repository.Repository
import com.ripalay.donut.core.ui.BaseViewModel

class TasksViewModel(private val repository: Repository):BaseViewModel() {
    fun getTasks(collect: String, db: FirebaseFirestore): MutableLiveData<ArrayList<Tasks>> {
        return repository.getTasks(collect, db)
    }
}