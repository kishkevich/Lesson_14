package by.itacademy.lesson14.domain;

import by.itacademy.lesson14.service.CashBoxRunnable;
import by.itacademy.lesson14.service.CustomersRunnable;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Shop {
    private Queue<Customer> customers = new LinkedList<>();
    private Set<CashBox> cashBoxes = new HashSet<>();

    public Shop() {
        cashBoxes.add(new CashBox(1));
        cashBoxes.add(new CashBox(2));
    }

    public void startCashBoxes() {
        for (CashBox cashBox : cashBoxes) {
            new CashBoxRunnable(customers, cashBox).start();
        }
    }

    public void startCustomerAddition() {
        new CustomersRunnable(customers).start();
    }

    public void add(Customer customer) {
        customers.add(customer);
    }

    public void remove(Customer customer) {
        customers.remove(customer);
    }
}

