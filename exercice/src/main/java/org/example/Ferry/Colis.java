package org.example.Ferry;

public class Colis {
    public String description;
    public Double poidsColis;

    public Colis(String description, Double poidsColis) {
        this.description = description;
        this.poidsColis = poidsColis;
    }

    public String getDescription() {
        return description;
    }
    public double getPoidsColis() {
        return poidsColis;
    }
}
