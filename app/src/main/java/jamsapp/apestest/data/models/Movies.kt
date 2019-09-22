package jamsapp.apestest.data.models

class Movies (
	var error : String? = null,
	var limit : Int? = 0,
	var offset : Int? = 0,
	var number_of_page_results : Int? = 0,
	var number_of_total_results : Int? = 0,
	var status_code : Int? = 0,
	var results : List<Results>? = null,
	var version : Double? = 0.0
)