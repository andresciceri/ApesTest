package jamsapp.apestest.data.dto

import com.google.gson.annotations.SerializedName

class StudiosDTO (
	@SerializedName("api_detail_url")
	var api_detail_url : String? = null,
	@SerializedName("id")
	var id : Int? = 0,
	@SerializedName("name")
	var name : String? = null,
	@SerializedName("site_detail_url")
	var site_detail_url : String? = null
)