package view;
import java.util.List;
import java.util.Scanner;
import model.Contact;

public class ContactView {
    public void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add a contact");
        System.out.println("2. Display all contacts");
        System.out.println("3. Delete a contact");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public void displayAll(List<Contact> contacts) {
        System.out.println("ID\tName\t\tFirst Name\tLast Name\tGroup\tAddress\tPhone");
        for (Contact contact : contacts) {
System.out.println(contact.getId() + "\t" + contact.getName() + "\t" + contact.getFirstName() + "\t\t"
                    + contact.getLastName() + "\t" + contact.getGroup() + "\t" + contact.getAddress() + "\t"
                    + contact.getPhone());
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public Contact getContactDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();
        String[] nameParts = fullName.split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts[1];

        System.out.print("Enter group: ");
        String group = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        return new Contact(0, fullName, firstName, lastName , group, address, phone);
    }

    public int getContactIdToDelete() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the contact to delete: ");
        return scanner.nextInt();
    }
}
