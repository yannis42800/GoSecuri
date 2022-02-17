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


class Connexion : AppCompatActivity() {
        lateinit var title: TextView
        val client = OkHttpClient()
        private lateinit var recyclerView: RecyclerView
        private lateinit var arrayList: ArrayList<Agent>
        private lateinit var myAdapter: myAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_agent_cnx)
        val mdp= findViewById<EditText>(R.id.password)
        val password = mdp.getText().toString()
        val id= findViewById<EditText>(R.id.identifiant)
        val identifiant = id.getText().toString()
        val Okbutton = findViewById<TextView>(R.id.login_button)


        Okbutton.setOnClickListener(View.OnClickListener {
            println(identifiant)
            println(password)
            processEmailAndPassword(identifiant,password)


        })

    }


      fun processEmailAndPassword(identifiant : String, password : String) {
        var ErrorMessage = ""
          println(identifiant)
        try {
            val urlAgentDetail =
                URL("https://raw.githubusercontent.com/yannis42800/img/main/agents/" + identifiant + ".txt")
            println(urlAgentDetail)
            val ycdetail = urlAgentDetail.openConnection()
            val agentDetail = BufferedReader(
                InputStreamReader(
                    ycdetail.getInputStream()
                )
            )





            val newAgent = Agent.fromFile(agentDetail)
            println(newAgent)
            agentDetail.close()


        } catch (e: MalformedURLException) {
        Toast.makeText(this,"Please enter Username and Password", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            Toast.makeText(this,"Please enter Username and Password", Toast.LENGTH_SHORT).show()
        }


         // je suppose que ceux sont tes 2 champs de mot de passe
        // je suppose que ceux sont tes 2 champs de mot de passe

        }
    }


