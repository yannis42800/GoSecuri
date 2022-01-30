package com.epsi.gosecuri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class agentDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agent_detail)
        val nomView = findViewById<TextView>(R.id.name)
        val imgView = findViewById<ImageView>(R.id.imgCart)

        val mousquetoncheck = findViewById<CheckBox>(R.id.mousqueton)
        val gantscheck = findViewById<CheckBox>(R.id.gants)
        val brassardcheck = findViewById<CheckBox>(R.id.brassard)
        val menottescheck = findViewById<CheckBox>(R.id.menottes)
        val cynocheck = findViewById<CheckBox>(R.id.cyno)
        val talkycheck = findViewById<CheckBox>(R.id.talky)
        val lampecheck = findViewById<CheckBox>(R.id.lampe)
        val kitcheck = findViewById<CheckBox>(R.id.kit)
        val tasercheck = findViewById<CheckBox>(R.id.taser)
        val lacrymocheck = findViewById<CheckBox>(R.id.lacrymo)





        val mousqueton = intent.getStringExtra("mousqueton");
        val gants = intent.getStringExtra("gants");
        val brassard = intent.getStringExtra("brassard");
        val menottes = intent.getStringExtra("menottes");
        val cyno = intent.getStringExtra("cyno");
        val talky = intent.getStringExtra("talky");
        val lampe = intent.getStringExtra("lampe");
        val kit = intent.getStringExtra("kit");
        val taser = intent.getStringExtra("taser");
        val lacrymo = intent.getStringExtra("lacrymo");

        var nom = intent.getStringExtra("nom")+ "  " + intent.getStringExtra("prenom")
        val img = intent.getStringExtra("img")

        println("listte mat")
        println(mousqueton.toString())
        println(gants.toString())
        println(brassard.toString())
        println(menottes.toString())
        println(cyno.toString())
        println(talky.toString())
        println(lampe.toString())
        println(kit.toString())
        println(taser.toString())
        println(lacrymo.toString())

        if(mousqueton == "mousqueton"){
            mousquetoncheck.isChecked = true
        }
        if(gants == "gants"){
            gantscheck.isChecked = true

        }
        if(brassard == "brassard"){
            brassardcheck.isChecked = true
        }
        if(menottes == "menottes"){
            menottescheck.isChecked = true
        }
        if(cyno == "cyno"){
            cynocheck.isChecked = true
        }
        if(talky == "talky"){
            talkycheck.isChecked = true
        }
        if(lampe == "lampe"){
            lampecheck.isChecked = true
        }
        if(kit == "kit"){
            kitcheck.isChecked = true
        }
        if(taser == "taser"){
            tasercheck.isChecked = true
        }
        if(lacrymo == "lacrymo"){
            lacrymocheck.isChecked = true
        }


        nomView.setText(nom)
        Picasso.get().load(img).into(imgView)


    }
}