package by.itacademy.lesson14.service;

import by.itacademy.lesson14.domain.CashBox;
import by.itacademy.lesson14.domain.Customer;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class CashBoxRunnable implements Runnable {
    //private final Queue<Customer> customers;
    private BlockingCashboxQueue customers = new BlockingCashboxQueue();
    private CashBox cashBox;

    public CashBoxRunnable(BlockingCashboxQueue customers, CashBox cashBox) {
        this.customers = customers;
        this.cashBox = cashBox;
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            customers.waitingCheck();
            Customer customer = customers.customer();
            customers.notifyCheck();
            System.out.println(Thread.currentThread().getName() + " " + cashBox + "\n"+customer );
        }
    }

//    private void waitingCheck() {
//        synchronized (customers) {
//            try {
//                while (customers.isEmpty())
//                    customers.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private Customer customer() {
//        synchronized (customers) {
//            return customers.poll();
//        }
//    }
//
//    private void notifyCheck() {
//        synchronized (customers) {
//            customers.notifyAll();
//        }
//    }
}
