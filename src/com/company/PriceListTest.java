package com.company;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

class PriceListTest {
    PriceList priceList = new PriceList();

    // покупки
    Pair<Long, Integer>  pair1 = new Pair<>(109L, 4);
    Pair<Long, Integer> pair2 = new Pair<>(130L,2);
    Pair<Long, Integer> pair3 = new Pair<>(140l, 5);

    String product1 = "Зефирки";
    String product2 = "Мармеладки";
    String product3 = "Печеньки";
    String product4 = "Вафельки";

    double price1 = 250.50;
    double price2 = 129.90;
    double price3 = 389.50;
    double price4 = 154.80;

    long id1 = 109;
    long id2 = 120;
    long id3 = 130;
    long id4 = 140;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        priceList.addProduct(id1, product1, price1);
        priceList.addProduct(id2, product2, price2);
        priceList.addProduct(id3, product3, price3);
        priceList.addProduct(id4, product4, price4);
    }

    @org.junit.jupiter.api.Test
    void addProduct() {
        assertEquals(true, priceList.addProduct(110, product1, 250.50));
        assertEquals(true, priceList.addProduct(121, product2, 129.90));
        assertEquals(true, priceList.addProduct(131, product3, 389.50));
        assertEquals(true, priceList.addProduct(141, product4, 154.80));
        assertThrows(IllegalArgumentException.class, () -> priceList.addProduct(109, product1, 250.50));
    }

    @Test
    void getProductName(){
        assertEquals(product1, priceList.getProductName(id1));
        assertEquals(product2, priceList.getProductName(id2));
        assertThrows(NoSuchElementException.class, () -> priceList.getProductName(0));
    }

    @Test
    void getProductPrice(){
        assertEquals(price1, priceList.getProductPrice(id1));
        assertEquals(price2, priceList.getProductPrice(id2));
        assertEquals(price3, priceList.getProductPrice(id3));
        assertThrows(NoSuchElementException.class, () -> priceList.getProductPrice(0));

    }

    @Test
   public void getProduct(){
        assertEquals( price1, priceList.getProduct(id1).getPrice());
        priceList.addProduct(126, "Печеньки", 249.8);
        assertEquals("Печеньки", priceList.getProduct(126).getName());
        assertEquals(249.8, priceList.getProduct(126).getPrice());
    }


    @Test
    void sum(){
        double sum1 = price1 * 4 + price3 * 2;
        double sum2 = price3 * 2;
        double sum3 = price4 * 5 + price3 * 2;
        assertEquals(sum1, priceList.sum(pair1, pair2));
        assertEquals(sum2, priceList.sum(pair2));
        assertEquals(sum3, priceList.sum(pair2, pair3));

    }
    @Test
    void setProductName(){
        priceList.addProduct(124, product1, price1);
        priceList.setProductName(124, "Зефир");
        assertEquals("Зефир", priceList.getProductName(124));
    }

    @Test
    void setProductPrice(){
        priceList.addProduct(125, product2, 3669.90);
        priceList.setProductPrice(125,3599.90);
        assertEquals(3599.90, priceList.getProductPrice(125));
    }


    @org.junit.jupiter.api.Test
    void removeProduct() {
        assertEquals(product1, priceList.getProductName(109));
        assertEquals(true, priceList.removeProduct(109));
        assertThrows(NoSuchElementException.class, () -> priceList.getProductName(109));
    }
}