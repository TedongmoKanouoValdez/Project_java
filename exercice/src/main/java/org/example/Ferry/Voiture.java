package org.example.Ferry;

import java.util.ArrayList;
import java.util.List;

public class Voiture extends Vehicule {
    public int maxPassager;
    public List<Voyageur> passager;
    public Voiture(String modele, String immatriculation, double longueur, double poids, Conducteur conducteur,int maxPassager,List<Voyageur> passager) {
        super(modele, immatriculation, longueur, poids, conducteur);
        this.maxPassager = maxPassager;
        this.passager = new ArrayList<Voyageur>();
    }

    public int monter(Voyageur voyageur) throws Exception {
        if(passager.size() < maxPassager){
            passager.add(voyageur);
            return passager.size();
        }
        else{
            throw new Exception("impossible de monter capacité maximale atteinte ");
        }
    }

    public boolean descendre(Voyageur voyageur) {
        if (passager.contains(voyageur)) {
            passager.remove(voyageur);
            return true;
        }
        return false;
    }

}
