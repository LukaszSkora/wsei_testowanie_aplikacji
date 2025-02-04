package wsei.testowanieAplikacji;

class PaymentProcessor {
    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean processPayment(Order order) {
        return paymentGateway.authorizePayment(order);
    }
}