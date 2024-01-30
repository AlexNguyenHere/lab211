package controller;

import java.util.ArrayList;
import java.util.List;
import model.Contact;
import view.ContactView;

public class ContactMenu {
    public List<Contact> contacts;
    public ContactView contactView;

    public ContactMenu() {
        contacts = new ArrayList<>();
        contactView = new ContactView();
    }

    public void start() {
        int choice;
        do {
            contactView.displayMenu();
            choice = contactView.getUserChoice();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    displayAllContacts();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    contactView.displayMessage("Exiting the program...");
                    break;
                default:
                    contactView.displayMessage("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void addContact() {
        Contact contact = contactView.getContactDetails();
        int id = contacts.isEmpty() ? 1 : contacts.get(contacts.size() - 1).getId() + 1;
        contact.setId(id);
        contacts.add(contact);
        contactView.displayMessage("Contact added successfully.");
    }
    
private void displayAllContacts() {
    String format = "%-5s %-15s %-10s %-10s %-10s %-10s %-10s";
    
    System.out.println(String.format(format, "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone"));
    
    for (Contact contact : contacts) {
        System.out.println(String.format(format, contact.getId(), contact.getName(), contact.getFirstName(), contact.getLastName(),
                contact.getGroup(), contact.getAddress(), contact.getPhone()));
    }
}
    private void deleteContact() {
    int idToDelete = contactView.getContactIdToDelete();
    boolean contactFound = false;
    
    for (int i = 0; i < contacts.size(); i++) {
        Contact contact = contacts.get(i);
        if (contact.getId() == idToDelete) {
            contacts.remove(i);
            contactFound = true;
            contactView.displayMessage("Contact deleted successfully.");
            break;
        }
    }
    
    if (!contactFound) {
        contactView.displayMessage("No contact found with the given ID.");
    } else {
  
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            contact.setId(i + 1);
        }
    }
}
}