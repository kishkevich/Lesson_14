package by.itacademy.lesson14.service;

import by.itacademy.lesson14.domain.Customer;

public interface CashBoxQueue {
    void waitingCheck();

    Customer customer();

    void notifyCheck();

}
