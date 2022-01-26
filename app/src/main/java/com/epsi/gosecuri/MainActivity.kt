package com.epsi.gosecuri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.widget.TextView
import android.widget.Toast
import com.google.gson.JsonObject
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.json.JSONObject
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.net.InetSocketAddress
import java.net.Proxy
import java.net.URL
import javax.net.ssl.HttpsURLConnection
import javax.xml.transform.OutputKeys.ENCODING
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


class MainActivity : AppCompatActivity() {
    lateinit var title:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = find(R.id.title)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val serviceJson = retrofit.create(service::class.java)
        val result = serviceJson.getInfoJson()

        result.enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                if(response.isSuccessful){
                    val result = response.body()
                    val name = result?.get("name")?.asString
                    System.out.println("name is : "+name)



                }            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Toast.makeText(applicationContext,"Erreur",Toast.LENGTH_SHORT).show()
            }


        })
        /* doAsync {
         /****Scrapping**/

            /* val doc = Jsoup.connect("http://localhost:8080/mspr/index.html").get()
             val body = doc.body()
             System.out.println(body)*/

             val proxy = Proxy(
                 Proxy.Type.HTTP,
                 InetSocketAddress("127.0.0.1", 8080)
             )


             val url = "http://localhost:8080/mspr/index.html"
             val document =
                 Jsoup.connect(url)
                     .proxy(proxy)
                     .get()
             val body = document.body()

             System.out.println(body)
         }*/


    }
}
