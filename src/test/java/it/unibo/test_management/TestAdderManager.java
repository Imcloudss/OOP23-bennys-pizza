package it.unibo.test_management;

import org.junit.jupiter.api.Test;
import it.unibo.model.impl.Management.AdderManager;
import it.unibo.model.impl.Management.AbstractManager;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestAdderManager {

    AdderManager manager = new AdderManager();
    
    // Can add positive amounts to balance
    @Test
    public void test_add_positive_amounts_to_balance() {
        AbstractManager.resetBalanceDay();
        manager.updateBalance(10);
        assertEquals(10, manager.getBalanceDay(), 0.001);
    }

    // Can add decimal amounts to balance
    @Test
    public void test_add_decimal_amounts_to_balance() {
        AbstractManager.resetBalanceDay();
        manager.updateBalance(3.14);
        assertEquals(3.14, manager.getBalanceDay(), 0.001);
    }

    // Cannot add negative amounts to balance
    @Test
    public void test_add_negative_amounts_to_balance() {
        AbstractManager.resetBalanceDay();
        assertThrows(IllegalArgumentException.class, () -> {
            manager.updateBalance(-10);
        });

    }

    // Cannot add NaN to balance
    @Test
    public void test_add_nan_to_balance() {
        AbstractManager.resetBalanceDay();
        assertThrows(IllegalArgumentException.class, () -> {
            manager.updateBalance(Double.NaN);
        });
    }

}
