
package model;

public class Order {
    public String customerName;
    public Fruit fruit;
    public int quantity;
    public double amount;

    public Order(String customerName, Fruit fruit, int quantity, double amount) {
        this.customerName = customerName;
        this.fruit = fruit;
        this.quantity = quantity;
        this.amount = amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}