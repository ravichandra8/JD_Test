package com.surendra.jd_test.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UrlStructure (
	@SerializedName("title")
	@Expose
	val title : String?,
	@SerializedName("isFeatured")
	@Expose
	val isFeatured : Boolean,
	@SerializedName("isCampaign")
	@Expose
	val isCampaign : Boolean
)