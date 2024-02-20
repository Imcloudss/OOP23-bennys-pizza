package it.unibo.test_management;

import org.junit.jupiter.api.Test;

import it.unibo.model.impl.Management.AbstractManager;
import it.unibo.model.impl.Management.AdderManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestAbstractManager {
    private static final String DELTA = "0.001";
    AbstractManager manager = new AdderManager();
     // AbstractManager can be instantiated
    @Test
    public void testInstantiation() {
        assertNotNull(manager);
    }

    // balance is initialized to 0
    @Test
    public void testBalanceInitialization() {
        assertEquals(0, manager.getBalanceTot(), 0);
    }
}
