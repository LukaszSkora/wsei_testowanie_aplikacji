package wsei.testowanieAplikacji;

import static java.lang.Math.PI;

public class GeometriaRozszerzona {

    public double poleProstokata(double a, double b) {
        return a * b;
    }

    public double obwodProstokata(double a, double b) {
        return (2 * a) + (2 * b);
    }

    public double poleKwadratu(double a) {
        return a * a;
    }

    public double obwodKwadratu(double a) {
        return 4 * a;
    }

    public double poleTrojkata(double a, double h) {
        return 0.5 * a * h;
    }

    public double obwodTrojkata(double a, double b, double c) {
        return a + b + c;
    }

    public double poleKola(double r) {
        return PI * r * r;
    }

    public double obwodKola(double r) {
        return 2 * PI * r;
    }
}
