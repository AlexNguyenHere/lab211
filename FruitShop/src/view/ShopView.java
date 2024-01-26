    
package view;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Fruit;
import model.Order;

public class ShopView {
    public Scanner scanner;

    public ShopView() {
        scanner = new Scanner(System.in);
    }

    public int showMainMenu() {
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("1. Create Fruit");
        System.out.println("2. View Orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.print("Please choose an option: ");
        return scanner.nextInt();
    }

   public Fruit createFruit() {
    int fruitId = 0;
    String fruitName = "";
    double price = 0.0;
    int quantity = 0;
    String origin = "";

    while (true) {
        try {
            System.out.print("Enter Fruit Id: ");
            fruitId = scanner.nextInt();
            scanner.nextLine();
            
            while (true) {
                System.out.print("Enter Fruit Name: ");
                fruitName = scanner.nextLine();
                
                if (!fruitName.matches(".*\\d.*")) {
    
                    break;
                }
                
                System.out.println("Invalid input. Fruit Name should not contain numbers.");
            }
            
            System.out.print("Enter Price: ");
            price = scanner.nextDouble();
            System.out.print("Enter Quantity: ");
            quantity = scanner.nextInt();
            scanner.nextLine();
            
            while (true) {
                System.out.print("Enter Origin: ");
                origin = scanner.nextLine();
                
                if (!origin.matches(".*\\d.*")) {
               
                    break;
                }
                
                System.out.println("Invalid input. Origin should not contain numbers.");
            }
            
          
            break;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter the correct data type.");
            scanner.nextLine(); 
        }
    }

    return new Fruit(fruitId, fruitName, price, quantity, origin);
}

    public void displayOrders(Hashtable<String, ArrayList<Order>> orders) {
        for (String customerName : orders.keySet()) {
            System.out.println("Customer: " + customerName);
            ArrayList<Order> customerOrders = orders.get(customerName);
            double totalAmount = 0;

            System.out.println("Product | Quantity | Price | Amount");
            for (Order order : customerOrders) {
                Fruit fruit = order.getFruit();
                System.out.printf("%-7s %-10d $%-6.2f $%-6.2f%n",
                        fruit.getFruitName(), order.getQuantity(), fruit.getPrice(), order.getAmount());
                totalAmount += order.getAmount();
            }

            System.out.println("Total: $" + totalAmount);
            System.out.println();
        }
    }

    public int showShoppingMenu(ArrayList<Fruit> fruits) {
        System.out.println("List of Fruit:");
        System.out.printf("%-7s %-15s %-10s %-10s%n", "Item", "Fruit Name", "Origin", "Price");

        for (int i = 0; i < fruits.size(); i++) {
            Fruit fruit = fruits.get(i);
            System.out.printf("%-7d %-15s %-10s $%-10.2f%n",
                    i + 1, fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
        }

        System.out.print("To order, enter the item number (or 0 to go back): ");
        return scanner.nextInt();
    }

    public int enterQuantity() {
        System.out.print("Please input quantity: ");
        return scanner.nextInt();
    }

    public String enterCustomerName() {
        scanner.nextLine(); 
        System.out.print("Input your name: ");
        return scanner.nextLine();
    }

    public boolean confirmOrder() {
        System.out.print("Do you want to order now (Y/N)? ");
        String choice = scanner.next().toUpperCase();
        return choice.equals("Y");
    }
    public Scanner getScanner() {
        return scanner;
    }
    public void displayFruits(ArrayList<Fruit> fruits) {
        System.out.println("List of Fruits:");
        System.out.printf("%-7s %-15s %-10s %-10s %-10s%n", "ID", "Fruit Name", "Price", "Quantity", "Origin");

        for (Fruit fruit : fruits) {
            System.out.printf("%-7d %-15s $%-9.2f %-10d %-10s%n",
                    fruit.getFruitId(), fruit.getFruitName(), fruit.getPrice(), fruit.getQuantity(), fruit.getOrigin());
        }
    }
}
