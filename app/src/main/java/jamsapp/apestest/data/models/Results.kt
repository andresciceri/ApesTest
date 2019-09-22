package jamsapp.apestest.data.models

class Results (
	var api_detail_url : String? = null,
	var box_office_revenue : Int? = 0,
	var budget : Int? = 0,
	var date_added : String? = null,
	var date_last_updated : String? = null,
	var deck : String? = null,
	var description : String? = null,
	var distributor : String? = null,
	var has_staff_review : String? = null,
	var id : Int? = 0,
	var image : Image? = null,
	var name : String? = null,
	var producers : String? = null,
	var rating : String? = null,
	var release_date : String? = null,
	var runtime : Int? = 0,
	var site_detail_url : String? = null,
	var studios : List<Studios>? = null,
	var total_revenue : Int? = 0,
	var writers : List<Writers>? = null
)