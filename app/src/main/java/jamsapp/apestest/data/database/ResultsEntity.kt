package jamsapp.apestest.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import jamsapp.apestest.data.models.Image
import jamsapp.apestest.data.models.Studios
import jamsapp.apestest.data.models.Writers

@Entity
data class ResultsEntity (

    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "api_detail_url")
    var api_detail_url : String? = null,
    @ColumnInfo(name = "box_office_revenue")
    var box_office_revenue : String? = null,
    @ColumnInfo(name = "budget")
    var budget : String? = null,
    @ColumnInfo(name = "date_added")
    var date_added : String? = null,
    @ColumnInfo(name = "date_last_updated")
    var date_last_updated : String? = null,
    @ColumnInfo(name = "deck")
    var deck : String? = null,
    @ColumnInfo(name = "description")
    var description : String? = null,
    @ColumnInfo(name = "distributor")
    var distributor : String? = null,
    @ColumnInfo(name = "has_staff_review")
    var has_staff_review : String? = null,
    @ColumnInfo(name = "movie_id")
    var movie_id : String? = null,

    @ColumnInfo(name = "image")
    var image : Image? = null,

    @ColumnInfo(name = "name")
    var name : String? = null,
    @ColumnInfo(name = "rating")
    var rating : String? = null,
    @ColumnInfo(name = "release_date")
    var release_date : String? = null,
    @ColumnInfo(name = "runtime")
    var runtime : String? = null,
    @ColumnInfo(name = "site_detail_url")
    var site_detail_url : String? = null,

    @ColumnInfo(name = "studios")
    var studios : List<Studios>? = null,

    @ColumnInfo(name = "total_revenue")
    var total_revenue : String? = null,

    @ColumnInfo(name = "writers")
    var writers : List<Writers>? = null
)