package com.epsi.gosecuri

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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
        Picasso.get().load(
            "https://raw.githubusercontent.com/yannis42800/img/main/images/" + agents.getNom().toString() + ".jpg").into(holder.img)


    }

    override fun getItemCount(): Int {

       return agentList.size
    }

    public class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name : TextView = itemView.findViewById(R.id.editTextTextPersonName)
        val mission : TextView = itemView.findViewById(R.id.mission)
        val img: ImageView = itemView.findViewById(R.id.imagecdagent);






    }




}