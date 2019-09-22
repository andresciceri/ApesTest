package jamsapp.apestest.data.dto

import com.google.gson.annotations.SerializedName

class ResultsDTO (

	@SerializedName("api_detail_url")
	val api_detail_url : String,
	@SerializedName("box_office_revenue")
	val box_office_revenue : Int,
	@SerializedName("budget")
	val budget : Int,
	@SerializedName("date_added")
	val date_added : String,
	@SerializedName("date_last_updated")
	val date_last_updated : String,
	@SerializedName("deck")
	val deck : String,
	@SerializedName("description")
	val description : String,
	@SerializedName("distributor")
	val distributor : String,
	@SerializedName("has_staff_review")
	val has_staff_review : String,
	@SerializedName("id")
	val id : Int,
	@SerializedName("image")
	val image : ImageDTO,
	@SerializedName("name")
	val name : String,
	@SerializedName("producers")
	val producers : String,
	@SerializedName("rating")
	val rating : String,
	@SerializedName("release_date")
	val release_date : String,
	@SerializedName("runtime")
	val runtime : Int,
	@SerializedName("site_detail_url")
	val site_detail_url : String,
	@SerializedName("studios")
	val studios : List<StudiosDTO>,
	@SerializedName("total_revenue")
	val total_revenue : Int,
	@SerializedName("writers")
	val writers : List<WritersDTO>
)