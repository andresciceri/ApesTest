package jamsapp.apestest.data.dto

import com.google.gson.annotations.SerializedName

class MoviesDTO (
	@SerializedName("error")
	val error : String,
	@SerializedName("limit")
	val limit : Int,
	@SerializedName("offset")
	val offset : Int,
	@SerializedName("number_of_page_results")
	val number_of_page_results : Int,
	@SerializedName("number_of_total_results")
	val number_of_total_results : Int,
	@SerializedName("status_code")
	val status_code : Int,
	@SerializedName("results")
	val results : List<ResultsDTO>,
	@SerializedName("version")
	val version : Double
)