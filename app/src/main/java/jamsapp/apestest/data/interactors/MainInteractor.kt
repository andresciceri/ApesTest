package jamsapp.apestest.data.interactors

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import jamsapp.apestest.data.dto.ResultsDTO
import jamsapp.apestest.data.dto.StudiosDTO
import jamsapp.apestest.data.dto.WritersDTO
import jamsapp.apestest.data.models.*
import jamsapp.apestest.data.repositories.IMainRepository
import jamsapp.apestest.di.DaggerMainComponent
import jamsapp.apestest.di.MainModule
import javax.inject.Inject

interface IMainInteractor {
    fun getAllMovies(): Observable<Movies>?
}

class MainInteractor: IMainInteractor {

    @Inject
    lateinit var repository: IMainRepository

    init {
        DaggerMainComponent.builder()
            .mainModule(MainModule())
            .build().inject(this)
    }

    override fun getAllMovies(): Observable<Movies>? {
        return repository.getAllMovies()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.flatMap {
                val responseModel = Movies().apply {
                    this.error = it.error
                    this.limit = it.limit
                    this.offset = it.offset
                    this.number_of_page_results = it.number_of_page_results
                    this.number_of_total_results = it.number_of_total_results
                    this.status_code = it.status_code
                    this.results = modelResults(it.results)
                    this.version = it.version
                }
                Observable.just(responseModel)
            }
    }

    private fun modelResults(results: List<ResultsDTO>?): List<Results>?{
        val resultsList = arrayListOf<Results>()
        results?.forEach {
            resultsList.add(
                Results().apply {
                    this.api_detail_url = it.api_detail_url
                    this.box_office_revenue = it.box_office_revenue
                    this.budget = it.budget
                    this.date_added = it.date_added
                    this.date_last_updated = it.date_last_updated
                    this.deck = it.deck
                    this.description = it.description//removeHtml(it.description)
                    this.distributor = it.distributor
                    this.has_staff_review = it.has_staff_review
                    this.id = it.id
                    this.image = Image().apply {
                        this.icon_url = it.image?.icon_url
                        this.medium_url = it.image?.medium_url
                        this.screen_url = it.image?.screen_url
                        this.screen_large_url = it.image?.screen_large_url
                        this.small_url = it.image?.small_url
                        this.super_url = it.image?.super_url
                        this.thumb_url = it.image?.thumb_url
                        this.tiny_url = it.image?.tiny_url
                        this.original_url = it.image?.original_url
                        this.image_tags = it.image?.image_tags
                    }
                    this.name = it.name
                    //this.producers = it.producers
                    this.rating = it.rating
                    this.release_date = it.release_date
                    this.runtime = it.runtime
                    this.site_detail_url = it.site_detail_url
                    this.studios = modelStudios(it.studios)
                    this.total_revenue = it.total_revenue
                    this.writers = modelWriters(it.writers)
                }
            )
        }
        return resultsList
    }

    private fun modelStudios(studios: List<StudiosDTO>?): List<Studios>?{
        val studiosList = arrayListOf<Studios>()
        studios?.forEach {
            studiosList.add(
                Studios().apply {
                    this.api_detail_url = it.api_detail_url
                    this.id = it.id
                    this.name = it.name
                    this.site_detail_url = it.site_detail_url
                }
            )
        }
        return studiosList
    }

    private fun modelWriters(writers: List<WritersDTO>?): List<Writers>?{
        val writersList = arrayListOf<Writers>()
        writers?.forEach {
            writersList.add(
                Writers().apply {
                    this.api_detail_url = it.api_detail_url
                    this.id = it.id
                    this.name = it.name
                    this.site_detail_url = it.site_detail_url
                }
            )
        }
        return writersList
    }

    private fun removeHtml(html: String?): String? {
        var html = html
        html = html?.replace("<(.*?)\\>".toRegex(), "")
        html = html?.replace("<(.*?)\\\n".toRegex(), "")
        html = html?.replaceFirst("(.*?)\\>".toRegex(), "")
        html = html?.replace("&nbsp;".toRegex(), "")
        html = html?.replace("&amp;".toRegex(), "")
        return html
    }
}