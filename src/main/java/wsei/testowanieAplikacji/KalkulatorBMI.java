package wsei.testowanieAplikacji;

public class KalkulatorBMI {

    public double calcBMI(double weight, double height) {
        if (weight == 0 || height == 0){
            throw new IllegalArgumentException();
        }
        return weight / ( height * height);
    }
}
