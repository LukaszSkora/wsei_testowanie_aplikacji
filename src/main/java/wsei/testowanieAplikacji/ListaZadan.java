package wsei.testowanieAplikacji;

import java.util.ArrayList;
import java.util.Scanner;


public class ListaZadan {

    class Zadanie {
        private String nazwa;
        private boolean jestWykonane;

        public Zadanie(String nazwa) {
            this.nazwa = nazwa;
            this.jestWykonane = false;
        }

        public String getNazwa() {
            return nazwa;
        }

        public boolean getJestWykonane() {
            return jestWykonane;
        }

        public void zaznaczJakoWykonane() {
            jestWykonane = true;
        }

        @Override
        public String toString() {
            return (jestWykonane ? "[X] " : "[ ] ") + nazwa;
        }
    }

    private ArrayList<Zadanie> zadania = new ArrayList<>();

    boolean dodajZadanie(String zadanie) {
        zadania.add(new Zadanie(zadanie));
        System.out.println("Zadanie dodane.");
        return true;
    }

    boolean usunZadanie(String zadanie) {
        if (zadania.isEmpty()) {
            System.out.println("Brak zadań.");
            return false;
        }

        for (Zadanie z : zadania) {
            if (z.getNazwa().equals(zadanie)) {
                zadania.remove(z);
                System.out.println("Zadanie usunięte.");
                return true;
            }
        }
        return false;
    }

    void oznaczZadanieJakoWykonane(String zadanie) {
        if (zadania.isEmpty()) {
            System.out.println("Brak zadań.");
            return;
        }

        for (Zadanie z : zadania) {
            if (z.getNazwa().equals(zadanie)) z.zaznaczJakoWykonane();
        }
    }

    boolean czyZadanieJestWykonane(String zadanie) {
        if (zadania.isEmpty()) {
            System.out.println("Brak zadań.");
            return false;
        } else {
            for (Zadanie z : zadania) {
                if (z.getNazwa().equals(zadanie)) return z.getJestWykonane();
            }
        }
        return false;
    }

    boolean czyJestZadanie(String zadanie) {
        if (zadania.isEmpty()) {
            System.out.println("Brak zadań.");
            return false;
        } else {
            for (Zadanie z : zadania) {
                if (z.getNazwa().equals(zadanie)) return true;
            }
        }
        return false;
    }

    int ileZadan() {
        return zadania.size();
    }

    void pokazZadania() {
        if (zadania.isEmpty()) {
            System.out.println("Brak zadań.");
        } else {
            System.out.println("\nZadania:");
            for (int i = 0; i < zadania.size(); i++) {
                System.out.println((i + 1) + ". " + zadania.get(i));
            }
        }
    }
}
