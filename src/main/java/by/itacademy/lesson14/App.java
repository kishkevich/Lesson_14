package by.itacademy.lesson14;

import by.itacademy.lesson14.domain.Customer;
import by.itacademy.lesson14.domain.Shop;
import by.itacademy.lesson14.domain.product.Bread;
import by.itacademy.lesson14.domain.product.Milk;
import by.itacademy.lesson14.domain.product.Sugar;

public class App 
{
    public static void main( String[] args )
    {
        Customer petr = new Customer(2);
        petr.add(new Milk());
        Customer alex = new Customer(3);
        alex.add(new Bread());
        alex.add(new Sugar());
        Customer vasya = new Customer(2);
        vasya.add(new Milk());
        Customer seroja = new Customer(3);
        seroja.add(new Bread());
        seroja.add(new Sugar());

        Shop shop = new Shop();
        shop.add(petr);
        shop.add(alex);
        shop.add(vasya);
        shop.add(seroja);
        shop.startCustomerAddition();
        shop.startCashBoxes();
    }
}
