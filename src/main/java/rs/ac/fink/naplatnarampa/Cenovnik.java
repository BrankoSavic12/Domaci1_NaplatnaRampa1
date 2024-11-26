/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.fink.naplatnarampa;

/**
 *
 * @author MyPC
 */


class Cenovnik {
    private int[] putarine;

    public Cenovnik(int[] putarine) {
        this.putarine = putarine;
    }

    public int getPutarina(int kategorija) throws Exception {
        if (kategorija < 0 || kategorija >= putarine.length) {
            throw new Exception("Kategorija ne postoji u cenovniku.");
        }
        return putarine[kategorija];
    }
}
