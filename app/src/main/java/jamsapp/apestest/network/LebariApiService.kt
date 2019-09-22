package jamsapp.apestest.network

import io.reactivex.Observable
import jamsapp.apestest.data.dto.MoviesDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ApesTestApiService {

    @GET("")
    fun getAllMovies(@Query("api_key") apiKey: String,
                     @Query("format") format: String): Observable<MoviesDTO>

    @GET("")
    fun getMovieById(@Query("api_key") apiKey: String,
                     @Query("format") format: String,
                     @Query("filter") id: String): Observable<MoviesDTO>

    /*@POST("user_check.php")
    fun checkUser(@Body checkUserRequestDTO: CheckUserRequestDTO): Observable<CheckUserResponseDTO>

    @POST("user_create.php")
    fun createUser(@Body createUserRequestDTO: CreateUserRequestDTO): Observable<CreateUserResponseDTO>

    @POST("user_update.php")
    fun updateUser(@Body updateUserRequestDTO: UpdateUserRequestDTO): Observable<UpdateUserResponseDTO>*/
}