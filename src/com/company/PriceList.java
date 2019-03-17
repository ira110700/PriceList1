package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;


public class PriceList{
            private Map<Long, Product> product = new HashMap<>();

            public boolean addProduct(long id, String name, Double price) {
                if (product.containsKey(id))
                    throw new IllegalArgumentException("Такой товар уже существует");
                product.put(id, new Product(name, price));
                return true;
            }

            public void removeProduct(long id) {
                if (!product.containsKey(id)) throw new NoSuchElementException();
                product.remove(id);
            }

            public String getProduct(long id) {
                if (product.containsKey(id))
                return product.get(id).toString();
                else throw new NoSuchElementException();
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



            private static class Product {
                private String name;
                private Double price;

                Product(String name, Double price) {
                    this.name = name;
                    this.price = price;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public Double getPrice() {
                    return price;
                }

                public void setPrice(Double price) {
                    this.price = price;
                }
            }
        }
