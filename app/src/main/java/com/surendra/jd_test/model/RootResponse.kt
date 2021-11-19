package com.surendra.jd_test.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RootResponse (
	@SerializedName("nav")
	@Expose
	val nav : List<NavData>
)