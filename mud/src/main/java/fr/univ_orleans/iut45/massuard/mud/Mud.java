package fr.univ_orleans.iut45.massuard.mud;

import com.google.gson.Gson;

public class Mud {
    public static void main(String[] args){
        InputStream json_inventaire_depart = Mud.class.getClassLoader().getResourceAsStream("inventaire_depart");
        Gson gson = new Gson();
        try {
            Box inventaire_depart = gson.fromJson(json_inventaire_depart)
            System.out.println("Votre package de départ est : "+inventaire_depart);
        } catch (Exception e){
            System.out.println("Echec chargement de l'inventaire de départ");
            e.printStackTrace();
        }
    }
}
