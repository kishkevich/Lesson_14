package by.itacademy.lesson14.domain;

public class CashBox {
    private int id;
    private double money;

    public CashBox(int id) {
        this.id = id;
    }

    public void service(Customer customer) {
        for (Product product : customer.getProducts()) {
            if (!customer.minus(product.getPrice())) {
                break;
            } else {
                this.money += product.getPrice();
            }
        }
    }

    public void add(double money) {
        this.money += money;
    }

    @Override
    public String toString() {
        return "CashBox{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }

}

