package com.epsi.gosecuri;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;

public class Agent {
    private String img;
    private String nom;
    private String prenom;
    private String mission;
    private String mdp;
    private ArrayList<equipements> equipements;

    public Agent(){}
    public  Agent(String img,String nom, String prenom, String mission, String mdp, ArrayList<equipements> equipements){
        this.img = img;
        this.nom = nom;
        this.prenom = prenom;
        this.mission = mission;
        this.mdp = mdp;
        this.equipements = equipements;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public ArrayList<equipements> getEquipements() {
        return equipements;
    }

    public void setEquipements(ArrayList<equipements> equipements) {
        this.equipements = equipements;
    }

    public static Agent fromFile (BufferedReader buffer) {
        String img;
        String nom;
        String prenom;
        String job;
        String mdp;
        ArrayList<equipements> packetage = new ArrayList<equipements>();
        String lienSite = "https://raw.githubusercontent.com/yannis42800/img/main/images/";

        try {
            //img = lienSite + id + ".jpg";
            nom = buffer.readLine();
            prenom = buffer.readLine();
            job = buffer.readLine();
            mdp = buffer.readLine();

            buffer.readLine();

            while (true) {
                String res = buffer.readLine();

                if (res == null)
                    break;

                packetage.add(com.epsi.gosecuri.equipements.valueOf(res));
            }

            Agent agent = new Agent();

            agent.nom = nom;
            agent.prenom = prenom;
            agent.mission = job;
            agent.mdp = mdp;
            agent.equipements = packetage;
            agent.img = lienSite + agent.getID() + ".jpg";

            System.out.println(lienSite + agent.getID() + ".jpg");
            return agent;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }



    public void toFile (String filePath){
        try {
            FileWriter writer = new FileWriter(new File(filePath));
            BufferedWriter buffer = new BufferedWriter(writer);
            String content = nom + "\n" + prenom + "\n" + mission + "\n" + mdp + "\n\n";
            System.out.println(content);

            for (equipements elem : equipements) {
                content += elem.name() + "\n";
            }
            buffer.write(content);
            buffer.flush();

            writer.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }


    public String getID()
    {
        return (prenom.charAt(0) + nom).toLowerCase(Locale.ROOT);
    }

}
