package by.itacademy.lesson14.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private double money;
    private List<Product> products = new ArrayList<>();

    public Customer(double money) {
        this.money = money;
    }

    public void add(Product product) {
        products.add(product);
    }

    public double getMoney() {
        return money;
    }

    public boolean minus(double price) {
        if (this.money >= price) {
            this.money -= price;
            return true;
        } else
            return false;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "money=" + money +
                ", products=" + products +
                '}';
    }
}

