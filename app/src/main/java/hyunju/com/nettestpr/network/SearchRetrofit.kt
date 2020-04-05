package hyunju.com.nettestpr.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object SearchRetrofit {

    private val retrofit : Retrofit

    init {
        var logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        var okHttpClient = OkHttpClient().newBuilder().apply {
            connectTimeout(30L, TimeUnit.SECONDS)
//            writeTimeout(TIMEOUT, TimeUnit.SECONDS)
//            readTimeout(TIMEOUT, TimeUnit.SECONDS)
            addInterceptor(logging)
        }.build()

        retrofit =
                Retrofit.Builder()
                        .baseUrl("https://dapi.kakao.com") // 도메인 주소
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create()) // GSON을 사용하기 위해 ConverterFactory에 GSON 지정
                        .build()
    }


    fun getService(): RetrofitService = retrofit.create(RetrofitService::class.java)


}