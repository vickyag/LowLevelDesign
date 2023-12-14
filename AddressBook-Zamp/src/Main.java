import entity.Address;
import entity.AddressBook;
import entity.Contact;
import constant.SearchCriteria;
import search.SearchStrategyFactoryImpl;
import service.AddressBookService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AddressBookService addressBookService =
                AddressBookService.getInstance(new AddressBook(), new SearchStrategyFactoryImpl());

        Scanner sc = new Scanner(System.in);
        Home:while(true){
            System.out.println("\nOptions:");
            System.out.println("1. Add Contact");
            System.out.println("2. Search by Name");
            System.out.println("3. Search by Phone Number");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter First Name: ");
                    String firstName = sc.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = sc.nextLine();
                    System.out.print("Enter Street: ");
                    String street = sc.nextLine();
                    System.out.print("Enter City: ");
                    String city = sc.nextLine();
                    System.out.print("Enter State: ");
                    String state = sc.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = sc.nextLine();

                    Address address = new Address(street, city, state);
                    Contact newContact = new Contact(firstName, lastName, phoneNumber, address);
                    addressBookService.addContact(newContact);
                    System.out.println("Contact added successfully!");
                    break;

                case 2:
                    System.out.print("Enter First Name to Search: ");
                    String searchName = sc.nextLine();
                    List<Contact> searchByName = addressBookService.searchContacts(SearchCriteria.FirstName, searchName);
                    if (searchByName != null) {
                        System.out.println("\nContact Found:");
                        searchByName.forEach(System.out::println);
                    } else {
                        System.out.println("Contact(s) not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Phone Number to Search: ");
                    String searchPhoneNumber = sc.nextLine();
                    List<Contact> searchByPhone = addressBookService.searchContacts(SearchCriteria.PhoneNumber, searchPhoneNumber);
                    if (searchByPhone != null) {
                        System.out.println("\nContact Found:");
                        searchByPhone.forEach(System.out::println);
                    } else {
                        System.out.println("Contact(s) not found!");
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break Home;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}