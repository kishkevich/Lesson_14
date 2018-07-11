package by.itacademy.lesson14.service;

import by.itacademy.lesson14.domain.Customer;

import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantlockQueue implements CashBoxQueue{
    private final Queue<Customer> customers;
    private Lock release = new ReentrantLock();

    public ReentrantlockQueue(Queue<Customer> customerQueue) {
        this.customers = customerQueue;
    }


    @Override
    public void waitingCheck() {
        release.lock();
        try {
            while (customers.isEmpty())
                customers.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        release.unlock();

    }

    @Override
    public Customer customer() {
        release.lock();
        Customer customer = customers.poll();
        release.unlock();
        return customer;

    }

    @Override
    public void notifyCheck() {
        release.lock();
        customers.notifyAll();
        release.unlock();

    }



}
