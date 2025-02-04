package wsei.testowanieAplikacji;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class OrderProcessorTest {

    private OrderProcessor orderProcessor;
    private Order orderMock;


    @BeforeEach
    void setUp() {
        orderProcessor = new OrderProcessor();
        orderMock = mock(Order.class);
    }

    @Test
    void testCalculateTotalPrice() {
        when(orderMock.getItems()).thenReturn(List.of(
                new Item("Produkt1", 10.0, 2), // 10 * 2 = 20
                new Item("Produkt2", 5.0, 3)   // 5 * 3 = 15
        ));
//        when(orderMock.getPrice()).thenReturn(10.0);

        double totalPrice = orderProcessor.calculateTotalPrice(orderMock);

        assertEquals(35.0, totalPrice, 10.0);
    }
}
