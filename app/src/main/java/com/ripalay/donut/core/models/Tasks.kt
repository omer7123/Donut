package com.ripalay.donut.core.models

import java.io.Serializable

data class Tasks(
    var id:String? = null,
    var task: String? = null,
    val author: String? = null,
    val price: Int? = null,
    val describe: String? = null,
    val recipient: String? = null
    ) : Serializable
