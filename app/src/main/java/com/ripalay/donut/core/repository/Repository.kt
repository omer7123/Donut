package com.ripalay.donut.core.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.ripalay.donut.core.models.Tasks

class Repository {
    private lateinit var auth: FirebaseAuth
    val mutList = MutableLiveData<ArrayList<Tasks>>()
    val user = MutableLiveData<FirebaseUser>()
    fun postLogin(email: String, password: String): MutableLiveData<FirebaseUser> {

//        var user: FirebaseUser? = null
        auth = Firebase.auth

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                user.postValue(auth.currentUser!!)
                Log.e("FireAuth", user.toString())
            } else {
                Log.e("FIre", "Authentication failed.")
            }
        }
        return user
    }

    fun getTasks(collect: String, db: FirebaseFirestore): MutableLiveData<ArrayList<Tasks>> {
        auth = FirebaseAuth.getInstance()

        val list = ArrayList<Tasks>()
        db.collection(collect)
            .addSnapshotListener { snapshots, e ->

                for (document in snapshots!!) {
                    val task = document.toObject(Tasks::class.java)
                    Log.e("eeee",auth.currentUser?.displayName.toString())
                    if ((task.recipient == "all") || (task.recipient == auth.currentUser?.email)) {
                        task.id = document.id
                        list.add(task)
                        Log.e("ololo", list.toString())
                    }
                }
                mutList.postValue(list)
            }
        return mutList
    }
}