package org.example.Ferry;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class Vehicule {
    public String modele;
    public String immatriculation;
    public double kilometrage;
    public double poids;
    public double longueur;
    public double reserve;
    public Conducteur conducteur;

    public Vehicule(String modele , String immatriculation, double longueur, double poids, Conducteur conducteur) {
        this.modele = modele;
        this.immatriculation = immatriculation;
        this.longueur = longueur;
        this.poids = poids;
        this.conducteur = conducteur;
    }

    public String getModele() {
        return modele;
    }

    public void AssignerConducteur(Conducteur conducteur) {
        if(conducteur.estAdulte()){
            this.conducteur = conducteur;
            System.out.println("le" + conducteur.getNom() + " a la possibilité de conduire ce vehicule");
        }
        else{
            System.out.println("le" + conducteur.getNom() + " ne peut pas conduire ce vehicule");
        }
    }

    public Conducteur getConducteur() {
        return conducteur;
    }

    public void changeConducteur(Conducteur conducteur) {
        if(conducteur != null & conducteur.estAdulte()){
            this .conducteur = conducteur;
            System.out.println("le conducteur du vehicule a été changé " +conducteur.getNom());
        }
        else{
            System.out.println("le conducteur de se vehicule ne peut etre changé " + conducteur.getNom());
        }
    }


    @Override
    public String toString() {
        return " le vehicule " +getModele() + " a pour immatriculation "+
                immatriculation + " don kilometrage est de " + kilometrage
                + "son poid vide est de " + poids + " sa longueur " + longueur
                + "sa reserve est de " + reserve + " son conducteur " + conducteur.getNom();
    }

    public double getPoids(double poidsTotal) {
        poidsTotal = poids + reserve;
        if(conducteur != null){
            poidsTotal = poidsTotal + conducteur.getPoids();
        }
        return poidsTotal;
    }

    public double allerAlaPompe(float quantite){
        if(quantite > 0) {
            System.out.println("la quantité ne peut pas etre negative");
        }
        reserve = (float) (quantite + reserve);
        return reserve;
    }

    public double rouler(float distance, float taux_consommation) throws IllegalAccessException {

        if(conducteur != null){
            throw new IllegalAccessException("le vehicule ne peut pas rouler sans conducteur");
        }

        float carburantNecessaire = distance * taux_consommation;

        if(reserve < carburantNecessaire){
            throw new IllegalAccessException("carburant insuffisant pour ce trajet");
        }

        reserve -= carburantNecessaire;
        kilometrage += distance;

        return kilometrage;
    }
}
