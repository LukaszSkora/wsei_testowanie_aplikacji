package wsei.testowanieAplikacji;

import java.util.HashMap;
import java.util.Map;

class InventoryManager {
    private Map<String, Integer> stock = new HashMap<>();

    public void updateStock(String product, int quantity) {
        stock.put(product, stock.getOrDefault(product, 0) + quantity);
    }

    public int getStock(String product) {
        return stock.getOrDefault(product, 0);
    }
}
