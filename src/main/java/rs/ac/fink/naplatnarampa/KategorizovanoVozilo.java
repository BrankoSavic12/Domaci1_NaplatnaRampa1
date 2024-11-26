/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.fink.naplatnarampa;

/**
 *
 * @author MyPC
 */
class KategorizovanoVozilo {
    private int kategorija;

    public KategorizovanoVozilo(int kategorija) {
        if (kategorija < 0 || kategorija > 2) {
            throw new IllegalArgumentException("Kategorija vozila nije validna.");
        }
        this.kategorija = kategorija;
    }

    public int getKategorija() {
        return kategorija;
    }
}
