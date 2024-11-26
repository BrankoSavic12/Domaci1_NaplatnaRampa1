/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package rs.ac.fink.naplatnarampa;

/**
 *
 * @author MyPC
 */

 public class Domaci1_NaplatnaRampa1 {

    public static void main(String[] args) {
        int[] putarine = {100, 150, 200}; 
        Cenovnik cenovnik = new Cenovnik(putarine);

      
        NaplatnaRampa rampa = new NaplatnaRampa("Rampa A", 3, 5.0, cenovnik);

  
        rampa.openRampa(cenovnik);
        rampa.start();
      
        try {
            Thread.sleep(60000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        
        rampa.closeRampa();

        rampa.destroyRampa();
    }
}

