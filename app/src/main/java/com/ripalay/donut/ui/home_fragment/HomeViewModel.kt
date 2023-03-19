package com.ripalay.donut.ui.home_fragment

import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.ripalay.donut.core.repository.Repository
import com.ripalay.donut.core.models.Tasks
import com.ripalay.donut.core.ui.BaseViewModel

class HomeViewModel(private val repository: Repository): BaseViewModel() {
    var loading = MutableLiveData<Boolean>()

    fun getTasks(collect: String, db:FirebaseFirestore): MutableLiveData<ArrayList<Tasks>> {
        return repository.getTasks(collect, db)
    }

}