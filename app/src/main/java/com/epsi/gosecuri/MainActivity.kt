package com.epsi.gosecuri

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.widget.TextView
import android.widget.Toast
import com.google.gson.JsonObject
import okhttp3.Headers
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.json.JSONObject
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import retrofit2.Call
import retrofit2.Callback
import java.io.File
import javax.net.ssl.HttpsURLConnection
import javax.xml.transform.OutputKeys.ENCODING
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.http.Url
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

import java.net.*


class MainActivity : AppCompatActivity() {
    lateinit var title:TextView
    val client = OkHttpClient()
    private lateinit var recyclerView: RecyclerView
    private lateinit var arrayList: ArrayList<Agent>
    private lateinit var myAdapter: myAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.agent_liste)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        arrayList = arrayListOf()
        myAdapter = myAdapter(arrayList)
        recyclerView.adapter = myAdapter

        if (Build.VERSION.SDK_INT > 9) {
            val policy = ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }

        title = find(R.id.title)
        EventChangeListenner()






        /* val retrofit = Retrofit.Builder()
             .baseUrl("https://raw.githubusercontent.com/")
             .addConverterFactory(GsonConverterFactory.create())
             .build()*/

        /*val serviceJson = retrofit.create(service::class.java)
        val result = serviceJson.getInfoJson()
        System.out.println("fichier : ")
        System.out.println(result)*/




        /*result.enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                if(response.isSuccessful){
                    val result = response.body()
                    val name = result?.get("name")?.asString
                    System.out.println("name is : "+name)



                }            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Toast.makeText(applicationContext,"Erreur",Toast.LENGTH_SHORT).show()
            }


        })*/
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
    private fun EventChangeListenner() {
        try {
            val urlChantier = URL("https://raw.githubusercontent.com/yannis42800/img/main/staff.txt")
            val yc = urlChantier.openConnection()
            val In = BufferedReader(
                InputStreamReader(
                    yc.getInputStream()
                )
            )

            var inputLine: String?
            while (In.readLine().also { inputLine = it } != null) {

                println(inputLine)
                try{
                    val urlAgentDetail = URL("https://raw.githubusercontent.com/yannis42800/img/main/agents/"+inputLine.toString()+".txt")
                    println(urlAgentDetail)
                    val ycdetail = urlAgentDetail.openConnection()
                    val agentDetail = BufferedReader(
                        InputStreamReader(
                            ycdetail.getInputStream()
                        )
                    )
                    val newAgent = Agent.fromFile(agentDetail)
                    println(newAgent)
                    arrayList.add(newAgent)
                    agentDetail.close()

                } catch (e: MalformedURLException) {
                    e.printStackTrace()
                } catch (e: IOException) {
                    e.printStackTrace()
                }



            }
            In.close()
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        myAdapter.notifyDataSetChanged()


    }
}
