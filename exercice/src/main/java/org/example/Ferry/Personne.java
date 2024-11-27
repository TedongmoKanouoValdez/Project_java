package org.example.Ferry;

public abstract class Personne {
    public String noms;
    public String prenoms;
    public double age;
    public String adresse;

    public Personne(String nom, String prenom, String adresse, double age) {
    }

    public abstract  void voyager();
}
