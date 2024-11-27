package org.example.Ferry;

public class Voyageur extends Personne{
    public String date_voyage;

    public Voyageur(String nom, String prenom, String adresse, double age, String date_voyage) {
        super(nom,prenom,adresse,age);
    }
    @Override
    public void voyager() {

    }
}
