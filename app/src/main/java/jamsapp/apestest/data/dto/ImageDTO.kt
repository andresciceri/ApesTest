package jamsapp.apestest.data.dto

import com.google.gson.annotations.SerializedName

class ImageDTO (
	@SerializedName("icon_url")
	var icon_url: String? = null,
	@SerializedName("medium_url")
	var medium_url : String? = null,
	@SerializedName("screen_url")
	var screen_url : String? = null,
	@SerializedName("screen_large_url")
	var screen_large_url : String? = null,
	@SerializedName("small_url")
	var small_url : String? = null,
	@SerializedName("super_url")
	var super_url : String? = null,
	@SerializedName("thumb_url")
	var thumb_url : String? = null,
	@SerializedName("tiny_url")
	var tiny_url : String? = null,
	@SerializedName("original_url")
	var original_url : String? = null,
	@SerializedName("image_tags")
	var image_tags : String? = null
)