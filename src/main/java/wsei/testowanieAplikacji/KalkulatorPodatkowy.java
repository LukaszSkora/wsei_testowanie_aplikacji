package wsei.testowanieAplikacji;

public class KalkulatorPodatkowy {

    public double obliczPodatekDochodowy(
            double dochod,
            double koszta,
            String formaOpodatkowania) {

        double podatekDochodowy = 0;
        double skladkaZdrowotna = 0;

        if (dochod - koszta <= 0) return 0;

        switch (formaOpodatkowania) {
            case "ryczałt" -> {
                if (dochod - koszta <= 60000) {
                    skladkaZdrowotna = 12 * 376;
                } else if (dochod - koszta <= 300000) {
                    skladkaZdrowotna = 12 * 626;
                } else {
                    skladkaZdrowotna = 12 * 1128;
                }
            }
            case "liniowy", "skala" -> {
                skladkaZdrowotna = 0.09 * (dochod - koszta);
            }
        }

        System.out.println(skladkaZdrowotna);

        switch (formaOpodatkowania) {
            case "ryczałt" -> {
                podatekDochodowy = (0.12 * (dochod - koszta)) - skladkaZdrowotna;
            }
            case "liniowy" -> {
                podatekDochodowy = (0.19 * (dochod - koszta)) - skladkaZdrowotna;
            }
            case "skala" -> {
                if (dochod - koszta <= 30000) {
                    podatekDochodowy = 0;
                } else if (dochod - koszta <= 120000) {
                    podatekDochodowy = (0.12 * (dochod - koszta)) - skladkaZdrowotna;
                } else {
                    podatekDochodowy = (0.32 * (dochod - koszta)) - skladkaZdrowotna;
                }
            }
        }

        System.out.println(podatekDochodowy);

        if (podatekDochodowy <= 0) return 0;

        return podatekDochodowy;
    }
}
