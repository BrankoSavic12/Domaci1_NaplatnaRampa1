/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.fink.naplatnarampa;

/**
 *
 * @author MyPC
 */

class NaplatnaStanica {
    private static int idCounter = 1;
    private int id;
    private Cenovnik cenovnik;
    private int naplaceno;

    public NaplatnaStanica() {
        this.id = idCounter++;
        this.naplaceno = 0;
    }

    public void setCenovnik(Cenovnik cenovnik) {
        this.cenovnik = cenovnik;
    }

    public void naplatiVozilo(KategorizovanoVozilo vozilo) throws Exception {
        if (cenovnik == null) {
            throw new IllegalStateException("Cenovnik nije postavljen na stanici.");
        }
        int cena = cenovnik.getPutarina(vozilo.getKategorija());
        naplaceno += cena;
        System.out.println("Proslo vozilo kategorije " + vozilo.getKategorija() + " cena " + cena);
    }

    public String opisStanice() {
        return id + "(" + naplaceno + ")";
    }

    public int getNaplacenIznos() {
        return naplaceno;
    }
}
