package es.iessotero.endes.ShoppingCart;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
import static org.junit.Assert.*;
import org.junit.*;

public class ShoppingCartTest {

    private ShoppingCart cart;
    private Product product1;
    private Product product2;

    @Before
    public void setUp() {
        cart = new ShoppingCart();
        product1 = new Product("Producto 1", 10.0);
        product2 = new Product("Producto 2", 20.0);
    }

    @Test
    public void testCarritoInicialmenteVacio() {
        assertEquals(0, cart.getItemCount());
    }

    @Test
    public void testEliminarProductoReduceContadorItems() throws ProductNotFoundException   {
        cart.addItem(product1);
        cart.removeItem(product1);
        assertEquals(0, cart.getItemCount());
    }
    
    @Test
    public void testCarritoVacioTieneCeroElementos() {
        cart.empty();
        assertEquals(0, cart.getItemCount());
    }

    @Test
    public void testAgregarProductoActualizaSaldo() {
        cart.addItem(product1);
        assertEquals(product1.getPrice(), cart.getBalance(), 0.001);
    }
    
    @Test
    public void testAgregarProductoAumentaContadorItems() {
        cart.addItem(product1);
        assertEquals(1, cart.getItemCount());
    }

    @Test
    public void testAgregarMultiplesProductosActualizaSaldoCorrectamente() {
        cart.addItem(product1);
        cart.addItem(product2);
        assertEquals(product1.getPrice() + product2.getPrice(), cart.getBalance(), 0.001);
    }



}
