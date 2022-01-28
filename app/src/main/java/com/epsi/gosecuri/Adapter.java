package com.epsi.gosecuri;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    LayoutInflater inflater;
    List<Agent> agents;


    public Adapter(Context ctx, List<Agent> agents){
        this.inflater = LayoutInflater.from(ctx);
        this.agents = agents;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_agent, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(agents.get(position).getNom() +"  "+ agents.get(position).getPrenom());
        holder.mission.setText(agents.get(position).getMission());
        Picasso.get().load("https://raw.githubusercontent.com/yannis42800/img/main/images/"+(agents.get(position).getPrenom().toCharArray()[0]+(agents.get(position).getNom()+".jpg"))).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView name,mission;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.editTextTextPersonName);
            mission = itemView.findViewById(R.id.mission);
            img = itemView.findViewById(R.id.imagecdagent);

        }
    }
}
