package jamsapp.apestest.data.dto

import com.google.gson.annotations.SerializedName

class ResultsDTO (

	@SerializedName("api_detail_url")
	var api_detail_url : String? = null,
	@SerializedName("box_office_revenue")
	var box_office_revenue : String? = null,
	@SerializedName("budget")
	var budget : String? = null,
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
	var id : String? = null,
	@SerializedName("image")
	var image : ImageDTO? = null,
	@SerializedName("name")
	var name : String? = null,
	/*@SerializedName("producers")
	var producers : String? = null,*/
	@SerializedName("rating")
	var rating : String? = null,
	@SerializedName("release_date")
	var release_date : String? = null,
	@SerializedName("runtime")
	var runtime : String? = null,
	@SerializedName("site_detail_url")
	var site_detail_url : String? = null,
	@SerializedName("studios")
	var studios : List<StudiosDTO>? = null,
	@SerializedName("total_revenue")
	var total_revenue : String? = null,
	@SerializedName("writers")
	var writers : List<WritersDTO>? = null
)