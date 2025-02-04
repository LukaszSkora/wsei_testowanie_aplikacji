package wsei.testowanieAplikacji;

interface PaymentGateway {
    boolean authorizePayment(Order order);
}
