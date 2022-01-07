package com.epsi.gosecuri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.doAsync
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import java.io.File
import java.net.InetSocketAddress
import java.net.Proxy
import javax.net.ssl.HttpsURLConnection
import javax.xml.transform.OutputKeys.ENCODING

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        doAsync {


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
        }

    }
}