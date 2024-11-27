package org.example.Ferry;

public class Conducteur extends Voyageur {

    public double numero_permis;
    public double poids;

    public Conducteur(String nom, String prenom, String adresse, double age, String date_voyage, double numero_permis, double poids) {
        super(nom, prenom, adresse, age, date_voyage);
        this.noms = nom;
        this.prenoms = prenom;
        this.adresse = adresse;
        this.age = age;
        this.date_voyage = date_voyage;
        this.numero_permis = numero_permis;

    }

    public String getNom() {
        return noms;
    }

    public double getAge() {
        return age;
    }
    public double getPoids() {
        return poids;
    }

    public boolean estAdulte() {
        return age >= 18;
    }

    public void ObtenirPermis(int age) {
        if (age < 18) {

            throw new IllegalArgumentException("Âge non réglementaire : Vous devez avoir au moins 18 ans pour passer le permis.");
        }
            System.out.println("Vous avez passer le permis.");
    }
}
