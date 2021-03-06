package com.company;

import javafx.util.Pair;

import java.util.*;


public class PriceList {
    private Map<Long, Product> product = new HashMap<>();

    public boolean addProduct(long id, String name, Double price) {
        if (product.containsKey(id))
            throw new IllegalArgumentException("Такой товар уже существует");
        product.put(id, new Product(name, price));
        return true;
    }

    public boolean removeProduct(long id) {
        if (!product.containsKey(id)) throw new NoSuchElementException();
        product.remove(id);
        return true;
    }

    public Product getProduct(long id){
        for (Map.Entry<Long, Product> entry : product.entrySet())
            if (id == entry.getKey())
                return entry.getValue();
        throw new NoSuchElementException();
    }

    public String getProductName(long id) {
        if (!product.containsKey(id)) throw new NoSuchElementException();
        return product.get(id).getName();
    }

    public double getProductPrice(long id) {
        if (!product.containsKey(id)) throw new NoSuchElementException();
        return product.get(id).getPrice();
    }

    public void setProductName(long id, String name) {
        if (!product.containsKey(id)) throw new NoSuchElementException();
        product.get(id).setName(name);
    }

    public void setProductPrice(long id, Double price) {
        if (!product.containsKey(id)) throw new NoSuchElementException();
        product.get(id).setPrice(price);
    }

    public double sum(Pair<Long, Integer>... list) {
        double sum = 0;
        for (Pair<Long, Integer> Products : list) {
            long idd = Products.getKey();
            if (!product.containsKey(idd)) throw new NoSuchElementException();
            Product pRoduct = product.get(idd);
            double pRice = pRoduct.getPrice();
            sum += Products.getValue() * pRice;
        }
        return sum;
    }


    public class Product {
        private String name;
        private Double price;
        private long id;

        public Product(String name, Double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
    }
}
