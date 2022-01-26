package com.epsi.gosecuri

import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET

interface service {
    @GET("yannis42800/img/main/test.json")
    fun getInfoJson(): Call<JsonObject>

}