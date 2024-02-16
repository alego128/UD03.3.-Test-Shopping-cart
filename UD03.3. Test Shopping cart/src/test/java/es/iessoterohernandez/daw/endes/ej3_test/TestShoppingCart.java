package es.iessoterohernandez.daw.endes.ej3_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class TestShoppingCart {
	
	private ShoppingCart cart;
    private Product product1;
    private Product product2;
	
    @BeforeEach
    public void setUp() {
        cart = new ShoppingCart();
        product1 = new Product("Product 1", 10.0);
        product2 = new Product("Product 2", 20.0);
    }

    @Test
    public void testInitialItemCountIsZero() {
        assertEquals(0, cart.getItemCount());
    }

    @Test
    public void testEmptyCartHasZeroElements() {
        assertTrue(cart.getItemCount() == 0);
    }
    
    @Test
    public void testAddingProductIncreasesItemCount() {
        cart.addItem(product1);
        assertEquals(1, cart.getItemCount());
    }

    @Test
    public void testAddingProductIncreasesBalance() {
        cart.addItem(product1);
        assertEquals(10.0, cart.getBalance(), 0.01);
    }
    
    
    @Test
    public void testAddingMultipleProductsIncreasesItemCountAndBalance() {
        cart.addItem(product1);
        cart.addItem(product2);
        assertEquals(2, cart.getItemCount());
        assertEquals(30.0, cart.getBalance(), 0.01);
    }

    @Test
    public void testRemovingProductDecreasesItemCount() throws ProductNotFoundException {
        cart.addItem(product1);
        cart.removeItem(product1);
        assertEquals(0, cart.getItemCount());
    }
  
    @Test
    public void testRemovingNonExistingProductDoesNotChangeItemCount() {
        assertThrows(ProductNotFoundException.class, () -> {
            cart.removeItem(product1);
        });
        assertEquals(0, cart.getItemCount());
    }
}