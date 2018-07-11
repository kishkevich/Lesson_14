package by.itacademy.lesson14.service;

import by.itacademy.lesson14.domain.Customer;
import by.itacademy.lesson14.domain.Product;
import by.itacademy.lesson14.domain.product.ProductInstantiationException;

import java.util.concurrent.BlockingQueue;

public class BlockingCashboxQueue implements CashBoxQueue {
    private BlockingQueue<Customer> customers;

    @Override
    public void waitingCheck() {
        try {
            customers.take();
            try {
                while (customers.isEmpty())
                    customers.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer customer() {
        try {
            customers.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } return customers.poll();

    }

    @Override
    public void notifyCheck() {
        synchronized (customers) {
            customers.notifyAll();
        }
    }

}
