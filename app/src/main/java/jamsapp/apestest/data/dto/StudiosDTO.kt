package jamsapp.apestest.data.dto

import com.google.gson.annotations.SerializedName

class StudiosDTO (
	@SerializedName("api_detail_url")
	val api_detail_url : String,
	@SerializedName("id")
	val id : Int,
	@SerializedName("name")
	val name : String,
	@SerializedName("site_detail_url")
	val site_detail_url : String
)