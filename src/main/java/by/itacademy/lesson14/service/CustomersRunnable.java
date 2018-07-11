package by.itacademy.lesson14.service;

import by.itacademy.lesson14.domain.Customer;
import by.itacademy.lesson14.domain.Product;
import by.itacademy.lesson14.domain.product.ProductInstantiationException;

import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;

public class CustomersRunnable implements Runnable {
    private final Queue<Customer> customers;

    public CustomersRunnable(Queue<Customer> customers) {
        this.customers = customers;
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            waitingCheck();
            addCustomers();
        }
    }

    private void waitingCheck() {
        synchronized (customers) {
            while (!customers.isEmpty()) {
                try {
                    customers.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void addCustomers() {
        Customer customer = customer();
        synchronized (customers) {
            customers.add(customer);
            customers.notifyAll();
        }
    }

    private Customer customer() {
        Customer customer = new Customer(Math.random() * 10);
        addProducts(customer);
        return customer;
    }

    private void addProducts(Customer customer) {
        try {
            customer.add(Product.getProduct());
            customer.add(Product.getProduct());
        } catch (ProductInstantiationException e) {
            e.printStackTrace();
        }
    }
}
