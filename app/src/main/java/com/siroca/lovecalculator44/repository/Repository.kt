package com.siroca.lovecalculator44.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.siroca.lovecalculator44.App
import com.siroca.lovecalculator44.LoveModel
import com.siroca.lovecalculator44.network.LoveApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi) {

    fun getLoveModel(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val loveModel: MutableLiveData<LoveModel> = MutableLiveData()

        api.calculate(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    loveModel.postValue(response.body())
                    val url = response.raw().request().url().uri()
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                when (t.message) {
                    "asdjas" -> {}
                    "asdjas" -> {}
                    "asdjas" -> {}
                    "asdjas" -> {}
                }
                Log.e("ololo", "onFailure: ${t.message}")
            }
        })

        return loveModel
    }
}