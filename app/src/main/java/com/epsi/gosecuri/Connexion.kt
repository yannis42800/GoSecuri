package com.epsi.gosecuri

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.net.URL
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.http.Url
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context
import android.content.Intent;
import android.os.Build
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import org.jetbrains.anko.toast


class Connexion : AppCompatActivity() {
        lateinit var title: TextView
        val client = OkHttpClient()



    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_agent_cnx)
        if (Build.VERSION.SDK_INT > 9) {
            val policy = ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }

        val Okbutton = findViewById<TextView>(R.id.login_button)




        Okbutton.setOnClickListener(View.OnClickListener {

            val mdp= findViewById<EditText>(R.id.password)
            val id= findViewById<EditText>(R.id.identifiant)
            val identifiant = id.getText().toString()
            val password = mdp.getText().toString()
            var verif = 0
            println(identifiant)
            try {
                val urlIdentifiant = URL("https://raw.githubusercontent.com/yannis42800/img/main/staff.txt")
                val yc = urlIdentifiant.openConnection()
                val In = BufferedReader(
                    InputStreamReader(
                        yc.getInputStream()
                    )
                )

                var inputLine: String?
                while (In.readLine().also { inputLine = it } != null) {

                    println(inputLine)
                    if(inputLine == identifiant ){
                        verif = 1
                    }






                }
                if(verif == 0){
                    toast("Votre Identifiant n'est pas correcte")
                }else{
                    try {
                        val urlMDP = URL("https://raw.githubusercontent.com/yannis42800/img/main/agents/"+identifiant+".txt")
                        val ycMDP = urlMDP.openConnection()
                        val InMDP = BufferedReader(
                            InputStreamReader(
                                ycMDP.getInputStream()
                            )
                        )
                        var inputLineMDP: String?
                        var lines = 0
                        while (InMDP.readLine().also { inputLineMDP = it } != null) {
                            if(lines == 3){

                                if (inputLineMDP.toString() == password.toString()){
                                    val intent = Intent(this, MainActivity::class.java)
                                    this!!.startActivity(intent)


                                }else{


                                    toast(inputLineMDP.toString())
                                }

                            }
                            lines = lines+1
                        }
                            InMDP.close()
                    } catch (e: MalformedURLException) {
                        e.printStackTrace()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
                print("verif")
                print(verif)
                In.close()
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }


        })

    }

    }


