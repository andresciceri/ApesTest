package jamsapp.apestest.data.dto

import com.google.gson.annotations.SerializedName

class ImageDTO (
	@SerializedName("icon_url")
	val icon_url : String,
	@SerializedName("medium_url")
	val medium_url : String,
	@SerializedName("screen_url")
	val screen_url : String,
	@SerializedName("screen_large_url")
	val screen_large_url : String,
	@SerializedName("small_url")
	val small_url : String,
	@SerializedName("super_url")
	val super_url : String,
	@SerializedName("thumb_url")
	val thumb_url : String,
	@SerializedName("tiny_url")
	val tiny_url : String,
	@SerializedName("original_url")
	val original_url : String,
	@SerializedName("image_tags")
	val image_tags : String
)