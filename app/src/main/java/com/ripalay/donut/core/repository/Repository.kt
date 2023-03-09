package com.ripalay.chatforarenda.core.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ripalay.chatforarenda.core.network.result.Resource

class Repository {
    private lateinit var auth: FirebaseAuth
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
}