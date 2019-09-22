package jamsapp.apestest.network

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

class ApesTestApiAdapter {

    private val baseUrl = "https://comicvine.gamespot.com/api/movies/"
    private var apestestApiService: ApesTestApiService? = null

    fun getApesTestService(): ApesTestApiService? {

        // Create an interceptor and indicate log level to use
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        // Associate interceptor to requests
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        if (apestestApiService == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build()) // <-- Use log level
                .build()
            apestestApiService = retrofit?.create<ApesTestApiService>(ApesTestApiService::class.java)
        }

        return apestestApiService
    }
}