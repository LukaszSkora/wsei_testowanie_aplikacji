package pl.tomasz.smutek.juni1;

/**
 *  TODO: do wszystkich metod dopisz odpowiadające im testy jednostkowe
 */
public class Calculator {

    //metoda, która dzieli dwie liczby rzeczywiste
    public double divide(double a, double b){
        if (b == 0){
            throw new IllegalArgumentException();
        }

        return a/b;
    }

    // metoda, która odejmuje dwie liczby rzeczywiste
    public double deduct(double a,double b){
        return a-b;
    }

    // TODO: napisać metodę, która doda dwie liczby rzeczywiste

    // TODO: napisać metodę, która pomnoży dwie liczby rzeczywiste



}
