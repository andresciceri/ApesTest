package jamsapp.apestest.data.models

class Results (
	var api_detail_url : String? = null,
	var box_office_revenue : String? = null,
	var budget : String? = null,
	var date_added : String? = null,
	var date_last_updated : String? = null,
	var deck : String? = null,
	var description : String? = null,
	var distributor : String? = null,
	var has_staff_review : String? = null,
	var id : String? = null,
	var image : Image? = null,
	var name : String? = null,
	//var producers : String? = null,
	var rating : String? = null,
	var release_date : String? = null,
	var runtime : String? = null,
	var site_detail_url : String? = null,
	var studios : List<Studios>? = null,
	var total_revenue : String? = null,
	var writers : List<Writers>? = null
)