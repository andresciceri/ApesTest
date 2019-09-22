package jamsapp.apestest.data.dto

import com.google.gson.annotations.SerializedName

class MoviesDTO (
	@SerializedName("error")
	var error : String? = null,
	@SerializedName("limit")
	var limit : Int? = 0,
	@SerializedName("offset")
	var offset : Int? = 0,
	@SerializedName("number_of_page_results")
	var number_of_page_results : Int? = 0,
	@SerializedName("number_of_total_results")
	var number_of_total_results : Int? = 0,
	@SerializedName("status_code")
	var status_code : Int? = 0,
	@SerializedName("results")
	var results : List<ResultsDTO>? = null,
	@SerializedName("version")
	var version : Double? = 0.0
)