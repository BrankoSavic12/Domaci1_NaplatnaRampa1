/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.fink.naplatnarampa;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author MyPC
 */

import java.util.ArrayList;
import java.util.Random;

public class NaplatnaRampa extends Thread {
    private String naziv;
    private int brojStanica;
    private double tsr;
    private ArrayList<NaplatnaStanica> stanice;
    private boolean otvorena;
    private long startTime;
    private static final long SIMULACIJA_TRANJA = 60000;

    public NaplatnaRampa(String naziv, int brojStanica, double tsr, Cenovnik cenovnik) {
        this.naziv = naziv;
        this.brojStanica = brojStanica;
        this.tsr = tsr;
        this.stanice = new ArrayList<>();
        for (int i = 0; i < brojStanica; i++) {
            NaplatnaStanica stanica = new NaplatnaStanica();
            stanica.setCenovnik(cenovnik);
            stanice.add(stanica);
        }
        this.otvorena = false;
    }

    public synchronized void openRampa(Cenovnik cenovnik) {
        if (!otvorena) {
            this.otvorena = true;
            this.startTime = System.currentTimeMillis(); 
            for (NaplatnaStanica stanica : stanice) {
                stanica.setCenovnik(cenovnik);
            }
            System.out.println("Rampa otvorena: " + opisRampa());
            notify();
        }
    }

    public synchronized void closeRampa() {
        if (otvorena) {
            this.otvorena = false;
            System.out.println("Rampa zatvorena: " + opisRampa());
            notify();
        }
    }

    public void destroyRampa() {
        if (otvorena) {
            this.otvorena = false;
        }
        System.out.println("Rampa unistena: " + naziv);
    }

    private String opisRampa() {
     StringBuilder sb = new StringBuilder(naziv + " (");
     int ukupnoNaplaceno = 0;
     ArrayList<String> detaljiStanica = new ArrayList<>();

     for (NaplatnaStanica stanica : stanice) {
         ukupnoNaplaceno += stanica.getNaplacenIznos();
         detaljiStanica.add(stanica.opisStanice());
     }

     sb.append(ukupnoNaplaceno).append("): ");
     sb.append(String.join(", ", detaljiStanica));

     return sb.toString();
 }


    @Override
    public void run() {
        while (System.currentTimeMillis() - startTime < SIMULACIJA_TRANJA) {
            synchronized (this) {
                try {
                    while (!otvorena) {
                        wait(); 
                    }

                    Random rand = new Random();
                  
                    Thread.sleep((long) (tsr * (1 + 0.3 * (rand.nextDouble() * 2 - 1)) * 1000));

                    int kategorija = rand.nextInt(3); // Random category 0, 1, 2
                    KategorizovanoVozilo vozilo = new KategorizovanoVozilo(kategorija);
                    NaplatnaStanica stanica = stanice.get(rand.nextInt(stanice.size()));

                    stanica.naplatiVozilo(vozilo);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted: " + e.getMessage());
                    Thread.currentThread().interrupt();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        closeRampa();
    }
}
