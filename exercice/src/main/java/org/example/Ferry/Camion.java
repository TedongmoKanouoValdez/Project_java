package org.example.Ferry;

import java.util.ArrayList;
import java.util.List;

public class Camion extends Vehicule {
    public List<Colis> Cargaison;
    public Vehicule vehicule;
    public Conducteur conducteur;
    public Camion(String modele, String immatriculation, double longueur, double poids, Conducteur conducteur) {
        super(modele, immatriculation, longueur, poids, conducteur);
        this.Cargaison = new ArrayList<Colis>();
    }

    public int ajouter(Colis c) {
        if (c == null) {
            throw new IllegalArgumentException("Le colis ne peut pas être null.");
        }
        Cargaison.add(c);
        return Cargaison.size();
    }

    public boolean retirer(Colis c) {
        if (c == null) {
            return false;
        }
        Cargaison.remove(c);
        return true;
    }
    public double poidCamion() {
        return vehicule.poids + poids + conducteur.poids + Cargaison.size();
    }

    @Override
    public String toString() {
        return super.toString() + "ce vehicule a pour poids : " + poidCamion() ;
    }
}
