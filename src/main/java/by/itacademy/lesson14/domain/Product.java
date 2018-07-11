package by.itacademy.lesson14.domain;

import by.itacademy.lesson14.domain.product.Bread;
import by.itacademy.lesson14.domain.product.Milk;
import by.itacademy.lesson14.domain.product.ProductInstantiationException;
import by.itacademy.lesson14.domain.product.Sugar;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class Product {
    private static Map<Integer, Class<? extends Product>> products = new HashMap<>();
    {
        products.put(0, Bread.class);
        products.put(1, Milk.class);
        products.put(2, Sugar.class);
    }

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static Product getProduct() throws ProductInstantiationException {
        Class<? extends Product> clazz = products.get(new Random().nextInt(3));
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new ProductInstantiationException(e);
        }
    }
}
