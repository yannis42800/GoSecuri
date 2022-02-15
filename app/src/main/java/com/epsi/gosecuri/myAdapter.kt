package com.epsi.gosecuri

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.util.ArrayList;



class myAdapter(private val agentList: ArrayList<Agent>) : RecyclerView.Adapter<myAdapter.myViewHolder>(){
    var onItemClick: ((Agent) -> Unit)? = null

    private var context: Context? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myAdapter.myViewHolder {
        this.context = parent.context

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_agent,parent,false)
        return myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myAdapter.myViewHolder, position: Int) {
        val agents : Agent = agentList[position]
        holder.name.setText(agents.getNom() + "  " + agents.getPrenom())
        holder.mission.setText(agents.getMission())
        Picasso.get().load(agents.getImg()).into(holder.img)
        holder.itemView.setOnClickListener(View.OnClickListener {
            passData(agents.id,agents.nom.toString(),agents.prenom.toString(),agents.img.toString(),agents.mission.toString(),agents.equipements)
        })


    }

    override fun getItemCount(): Int {

       return agentList.size
    }

    public class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name : TextView = itemView.findViewById(R.id.editTextTextPersonName)
        val mission : TextView = itemView.findViewById(R.id.mission)
        val img: ImageView = itemView.findViewById(R.id.imagecdagent);




    }



    private fun passData(
        id: String,
        nom: String,
        prenom:String,
        img:String,
        mission:String,
        equipements:ArrayList<equipements>


        ) {
        val intent = Intent(context, agentDetail::class.java)
        intent.putExtra("id",id)
        intent.putExtra("nom",nom)
        intent.putExtra("prenom",prenom)
        intent.putExtra("img",img)
        intent.putExtra("mission",mission)
        for(elem in equipements!!) {
            println(elem)

            intent.putExtra(elem.toString(),elem.toString())
        }




        context!!.startActivity(intent)
    }




}