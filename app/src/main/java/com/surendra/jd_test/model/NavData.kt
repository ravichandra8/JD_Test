package com.surendra.jd_test.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class NavData (
	@SerializedName("name")
	@Expose
	val name : String,
	@SerializedName("navigationName")
	@Expose
	val navigationName : String,
	@SerializedName("icon")
	@Expose
	val icon : String?,
	@SerializedName("navigation")
	@Expose
	val navigation : Navigation,
	@SerializedName("nav")
	@Expose
	val styles : List<String>,
	@SerializedName("children")
	@Expose
	val children : List<Child>?
)