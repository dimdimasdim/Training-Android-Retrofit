package com.dimas.networkexercise.data

import com.dimas.networkexercise.data.request.LoginRequest
import com.dimas.networkexercise.data.response.BaseResponse
import com.dimas.networkexercise.data.response.LoginResponse
import com.dimas.networkexercise.data.response.MovieResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface NetworkService {

    @POST("/login")
    suspend fun postLogin(
        @Header("is_mock") isMock: Boolean = true,
        @Body loginRequest: LoginRequest
    ): Response<BaseResponse<LoginResponse>>

    @GET("3/movie/now_playing")
    suspend fun getNowPlaying(
        @Query("page") page: Int
    ): Response<BaseResponse<List<MovieResponse>>>



}