package com.rinaayunabila.growthtrack.data.service

import com.rinaayunabila.growthtrack.data.*
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @POST("register")
    suspend fun register(
        @Body register: SignUpRequest
    ): SignUpResponse

    @POST("login")
    suspend fun login(
        @Body loginRequest: SignInRequest
    ): LoginResponse

    @GET("articles")
    suspend fun getAllArticles(): ArticleResponse

    @GET("articles/{uid}")
    suspend fun getArticleByUID(
        @Path("uid") uid: String
    ): Article

    @GET("article")
    suspend fun getArticle(
        @Header("Authorization") uid: String,
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 20,
    ): ArticleResponse

    @GET("users/{id}")
    fun getuser(
        @Header("Authorization") authHeader: String,
        @Path("id") id: String
    ): Call<UsersResponse>

    interface PlacesApiService {
        @GET("nearbysearch/json")
        fun getNearbyPlaces(
            @Query("location") location: String,
            @Query("radius") radius: Int,
            @Query("type") type: String,
            @Query("key") apiKey: String
        ): Call<PlacesResponse>
    }

    @GET("predictionHistory/")
    fun getHistory(
        @Header("Authorization") authHeader: String
    ): Call<Response>

    @FormUrlEncoded
    @POST("resetpassword")
    fun sendEmail(
        @Field("email") email: String
    ): Call<ResetRespon>

    @POST("predict")
    fun postpredict(
        @Header("Authorization") authHeader: String,
        @Body request: PredictRequest
    ): Call<Postpredict>
}


//    @POST("articles")
//    suspend fun postArticle(
//        @Body articleRequest: ArticleRequest
//    ): ApiResponse


//package com.rinaayunabila.mystoryapp.data.service
//
//import com.rinaayunabila.mystoryapp.data.SignInRequest
//import com.rinaayunabila.mystoryapp.data.SignUpRequest
//import com.rinaayunabila.mystoryapp.data.LoginResponse
//import com.rinaayunabila.mystoryapp.data.SignUpResponse
//import com.rinaayunabila.mystoryapp.data.StorysResponse
//import okhttp3.MultipartBody
//import okhttp3.RequestBody
//import retrofit2.http.*
//
//interface ApiService {
//    @POST("login")
//    suspend fun login(
//        @Body login: SignInRequest
//    ): LoginResponse
//
//    @POST("register")
//    suspend fun register(
//        @Body register: SignUpRequest
//    ): SignUpResponse
//
//    @GET("stories")
//    suspend fun getStories(
//        @Header("Authorization") token: String,
//        @Query("page") page: Int = 1,
//        @Query("size") size: Int = 20,
//    ): StorysResponse
//
//    @GET("stories")
//    suspend fun getLocation(
//        @Header("Authorization") token: String,
//        @Query("location") location : Int = 1,
//    ) : StorysResponse
//
//    @Multipart
//    @POST("stories")
//    suspend fun addStory(
//        @Header("Authorization") token: String,
//        @Part file: MultipartBody.Part,
//        @Part("description") description: RequestBody,
//        @Part("lat") lat: Float?=null,
//        @Part("lon") lon: Float?=null,
//    ): SignUpResponse
//}