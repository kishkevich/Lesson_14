package by.itacademy.lesson14.service;

import by.itacademy.lesson14.domain.Customer;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreQueue implements CashBoxQueue {
    private Semaphore semaphore = new Semaphore(1);
    private final Queue<Customer> customerQueue;

    public SemaphoreQueue(Queue<Customer> customerQueue) {
        this.customerQueue = customerQueue;
    }

    @Override
    public void waitingCheck() {
        try {
            semaphore.acquire();
            while (customerQueue.isEmpty())
                    customerQueue.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Override
    public Customer customer() {
    semaphore.release();
        return customerQueue.poll();
    }

    @Override
    public void notifyCheck() {
        try {
            semaphore.acquire();
            customerQueue.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
