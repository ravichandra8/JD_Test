package com.surendra.jd_test.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Navigation (
	@SerializedName("URI")
	@Expose
	val uRI : String?,
	@SerializedName("type")
	@Expose
	val type : String,
	@SerializedName("target")
	@Expose
	val target : String,
	@SerializedName("depth")
	@Expose
	val depth : String?,
	@SerializedName("data")
	@Expose
	val data : String?,
	@SerializedName("urlStructure")
	@Expose
	val urlStructure : UrlStructure
)