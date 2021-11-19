package com.surendra.jd_test.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Child (
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("navigationName")
    @Expose
    val navigationName: String
    )