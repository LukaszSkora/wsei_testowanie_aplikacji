package wsei.testowanieAplikacji;

public class KalkulatorKredytowy {

    public double obliczRate(double kredyt,
                             double oprocentowanie,
                             double liczbaRatNaRok,
                             double liczbaRat) {
        double rataGlowna;

        oprocentowanie = oprocentowanie / 100;

        if (oprocentowanie == 0) {
            rataGlowna = kredyt / liczbaRat;
        }
        else {
            rataGlowna = (kredyt * oprocentowanie) / (liczbaRatNaRok * (1 - Math.pow(liczbaRatNaRok / (liczbaRatNaRok + oprocentowanie), liczbaRat)));
        }
        System.out.println(rataGlowna);

        return rataGlowna;
    }
}
