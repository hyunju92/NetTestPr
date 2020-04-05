package hyunju.com.nettestpr

import android.app.Activity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import hyunju.com.nettestpr.databinding.ActivityMainBinding
import hyunju.com.nettestpr.network.SearchRetrofit
import hyunju.com.nettestpr.network.data.Image
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : Activity(){

    protected lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        netTest()
    }

    private fun netTest() {
        SearchRetrofit.getService().requestSearchImage(keyword = "iPhone", page = 1).enqueue(object : Callback<Image> {
            override fun onFailure(call: Call<Image>, t: Throwable) {}

            override fun onResponse(call: Call<Image>, response: Response<Image>) {
                if (response.isSuccessful) {
                    val image = response.body()


                }
            }
        })
    }

}