package hyunju.com.nettestpr.network

import hyunju.com.nettestpr.network.data.Image
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

    @Headers("Authorization: KakaoAK [발급받은 앱 키]")
    @GET("/v2/search/image")
    fun requestSearchImage(
            @Query("query") keyword: String,
            @Query("sort") sort: String = "recency",
            @Query("page") page: Int,
            @Query("size") size: Int = 10
    ): Call<Image>


    @GET("/members/{user}/address")
    fun getUserAddress(@Path("user") userName: String): Call<Image>

    @POST("/members/creqtRoute")
    fun saveMyRoute(@Body param : String) : Call<Image>
//    fun saveMyRoute(@Body param : JsonObject) : Call<Image>
}