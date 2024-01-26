
package controller;

import java.util.ArrayList;
import java.util.Hashtable;
import model.Fruit;
import model.Order;
import view.ShopView;

public class ShopController {
    private ArrayList<Fruit> fruits;
    private Hashtable<String, ArrayList<Order>> orders;
    private ShopView view;

    public ShopController() {
        fruits = new ArrayList<>();
        orders = new Hashtable<>();
        view = new ShopView();
    }

    public void start() {
        int choice;
        do {
            choice = view.showMainMenu();
            switch(choice) {
                case 1:
                    createFruit();
                    break;
                case 2:
                    viewOrders();
                    break;
                case 3:
                    shopping();
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);
    }

    public void createFruit() {
        Fruit fruit = view.createFruit();
        fruits.add(fruit);
        System.out.print("Do you want to continue (Y/N)? ");
        String choice = view.getScanner().next().toUpperCase();
        if (choice.equals("N")) {
            view.displayFruits(fruits);
        }
    }

    public void viewOrders() {
        view.displayOrders(orders);
    }

    public void shopping() {
        int choice;
        do {
            choice = view.showShoppingMenu(fruits);
            if (choice == 0) {
                break;
            }
            if (choice < 1 || choice > fruits.size()) {
                System.out.println("Invalid item number. Please try again.");
                continue;
            }
            Fruit selectedFruit = fruits.get(choice - 1);
            int quantity = view.enterQuantity();
            boolean orderConfirmed = view.confirmOrder();
            if (orderConfirmed) {
                String customerName = view.enterCustomerName();
                double amount = selectedFruit.getPrice() * quantity;
                Order order = new Order(customerName, selectedFruit, quantity, amount);

                ArrayList<Order> customerOrders = orders.getOrDefault(customerName, new ArrayList<>());
                customerOrders.add(order);
                orders.put(customerName, customerOrders);

                System.out.println("Order placed successfully!");
            }
        } while (choice != 0);
    }
    
}
