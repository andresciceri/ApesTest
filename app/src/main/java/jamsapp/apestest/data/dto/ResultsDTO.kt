package jamsapp.apestest.data.dto

import com.google.gson.annotations.SerializedName

class ResultsDTO (

	@SerializedName("api_detail_url")
	var api_detail_url : String? = null,
	@SerializedName("box_office_revenue")
	var box_office_revenue : Int? = 0,
	@SerializedName("budget")
	var budget : Int? = 0,
	@SerializedName("date_added")
	var date_added : String? = null,
	@SerializedName("date_last_updated")
	var date_last_updated : String? = null,
	@SerializedName("deck")
	var deck : String? = null,
	@SerializedName("description")
	var description : String? = null,
	@SerializedName("distributor")
	var distributor : String? = null,
	@SerializedName("has_staff_review")
	var has_staff_review : String? = null,
	@SerializedName("id")
	var id : Int? = 0,
	@SerializedName("image")
	var image : ImageDTO? = null,
	@SerializedName("name")
	var name : String? = null,
	@SerializedName("producers")
	var producers : String? = null,
	@SerializedName("rating")
	var rating : String? = null,
	@SerializedName("release_date")
	var release_date : String? = null,
	@SerializedName("runtime")
	var runtime : Int? = 0,
	@SerializedName("site_detail_url")
	var site_detail_url : String? = null,
	@SerializedName("studios")
	var studios : List<StudiosDTO>? = null,
	@SerializedName("total_revenue")
	var total_revenue : Int? = 0,
	@SerializedName("writers")
	var writers : List<WritersDTO>? = null
)