package wsei.testowanieAplikacji;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.MockitoAnnotations;


class InventoryManagerTest {

    @Spy
    private InventoryManager inventoryManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUpdateStock() {
        inventoryManager.updateStock("Produkt1", 5);

        assertEquals(5, inventoryManager.getStock("Produkt1"));

        verify(inventoryManager).updateStock("Produkt1", 5);
    }

    @Test
    void testUpdateStock_Twice() {
        inventoryManager.updateStock("Produkt1", 5);
        inventoryManager.updateStock("Produkt1", 7);

        assertEquals(12, inventoryManager.getStock("Produkt1"));

        verify(inventoryManager).updateStock("Produkt1", 5);
        verify(inventoryManager).updateStock("Produkt1", 7);
    }

    @Test
    void testUpdateStock_Subtract() {
        inventoryManager.updateStock("Produkt1", 5);
        inventoryManager.updateStock("Produkt1", -3);

        assertEquals(2, inventoryManager.getStock("Produkt1"));

        verify(inventoryManager).updateStock("Produkt1", 5);
        verify(inventoryManager).updateStock("Produkt1", -3);
    }
}
