package wsei.testowanieAplikacji;

import java.util.function.LongConsumer;

public class Main {
    public static void main(String[] args) {

        // Implementacja przykłądowe interfejsu (LongConsumer) jako Anonimowej Klasy Wewnętrznej
        LongConsumer consumerAKW =  new LongConsumer() {
            @Override
            public void accept(long value) {
                System.out.println("Jestem z anonimowej klasy wewnętrznej, wartość parametru, to: " + value);
            }
        };

        // Implementacji przykłądoweg interfejsu (LongConsumer) przez Lambdę
        LongConsumer consumerL = (param) -> {
            System.out.println("Jestem z lambdy, wartość parametru, to: " + param);
        };

        consumerAKW.accept(3);
        consumerL.accept(3);
    }
}