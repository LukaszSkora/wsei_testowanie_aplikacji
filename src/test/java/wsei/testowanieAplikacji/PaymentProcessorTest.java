package wsei.testowanieAplikacji;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaymentProcessorTest {

    private PaymentProcessor paymentProcessor;
    private PaymentGateway paymentGatewayMock;
    private Order orderMock;

    @BeforeEach
    void setUp() {
        paymentGatewayMock = mock(PaymentGateway.class);
        paymentProcessor = new PaymentProcessor(paymentGatewayMock);
        orderMock = mock(Order.class);
    }

    @Test
    void testProcessPayment_Successful() {
        when(paymentGatewayMock.authorizePayment(orderMock)).thenReturn(true);

        boolean result = paymentProcessor.processPayment(orderMock);

        assertTrue(result);
    }

    @Test
    void testProcessPayment_Failed() {
        when(paymentGatewayMock.authorizePayment(orderMock)).thenReturn(false);

        boolean result = paymentProcessor.processPayment(orderMock);

        assertFalse(result);
    }
}