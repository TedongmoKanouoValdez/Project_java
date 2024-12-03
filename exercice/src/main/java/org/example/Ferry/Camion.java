package org.example.Ferry;

import java.util.ArrayList;
import java.util.List;

public class Camion extends Vehicule {
    public List<Colis> Cargaison;
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
}
