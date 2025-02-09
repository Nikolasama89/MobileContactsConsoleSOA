package gr.aueb.cf.mobilecontacts;

import gr.aueb.cf.mobilecontacts.controller.MobileContactController;
import gr.aueb.cf.mobilecontacts.dto.MobileContactInsertDTO;
import gr.aueb.cf.mobilecontacts.dto.MobileContactReadOnlyDTO;
import gr.aueb.cf.mobilecontacts.dto.MobileContactUpdateDTO;
import gr.aueb.cf.mobilecontacts.exceptions.ContactNotFoundException;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final MobileContactController controller = new MobileContactController();

    public static void main(String[] args) {
        String choice;

        while (true) {
            printMenu();
            choice = getToken();

            if (choice.equals("q") || (choice.equals("Q"))) {
                break;
            }

            handleChoice(choice);

        }

        System.out.println("Thank you for using our App");
    }

    public static void handleChoice(String choice) {
        String firstname;
        String lastname;
        String phoneNumber;
        String response;

        switch (choice) {
            case "1":
                System.out.println("Please insert Name, Surname, Phone number");
                firstname = getToken();
                lastname = getToken();
                phoneNumber = getToken();
                MobileContactInsertDTO insertDTO = new MobileContactInsertDTO(firstname, lastname, phoneNumber);
                response = controller.insertContact(insertDTO);

                if (response.startsWith("OK")) {
                    System.out.println("Insert Successful");
                    System.out.println(response.substring(3));
                } else {
                    System.out.println("Unsuccessful Insert");
                    System.out.println(response.substring(7));
                }
                break;
            case "2":
                System.out.println("Please insert contact ID to update:");
                Long id;
                try {
                    id = Long.parseLong(getToken());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid ID. Try again");
                    throw e;
                }
                System.out.println("Please insert new Name, Last Name and phone number.");
                firstname = getToken();
                lastname = getToken();
                phoneNumber = getToken();
                MobileContactUpdateDTO updateDTO = new MobileContactUpdateDTO(id, firstname, lastname, phoneNumber);
                response = controller.updateContact(updateDTO);

                if (response.startsWith("OK")) {
                    System.out.println("Successful update!");
                    System.out.println(response.substring(3));
                } else {
                    System.out.println("Unsuccessful Update");
                    System.out.println(response.substring(7));
                }
                break;
            case "3":
                System.out.println("Please Select a Contact to delete: ");
                Long contactId = Long.parseLong(getToken());
                response = controller.deleteContactById(contactId);

                if (response.startsWith("OK")) {
                    System.out.println(response.substring(3));
                } else {
                    System.out.println("Unsuccessful Delete");
                    System.out.println(response.substring(7));
                }
                break;
            case "4":
                System.out.println("Search for contact Id");
                id = Long.parseLong(getToken());
                response = controller.getContactById(id);
                if (response.startsWith("OK")) {
                    System.out.println("Successful Search!");
                    System.out.println(response.substring(3));
                } else {
                    System.out.println("Unsuccessful Search");
                    System.out.println(response.substring(7));
                }
                break;
            case "5":
                List<String> mobileContacts = controller.getAllContacts();
                if (mobileContacts.isEmpty()) {
                    System.out.println("Contact List is empty!");
                } else {
                    mobileContacts.forEach(System.out::println);
                }
                break;
            default:
                System.out.println("Wrong Choice");
                break;
        }
    }

    public static void printMenu() {
        System.out.println("Choose one of the following: ");
        System.out.println("1. Insert Contact");
        System.out.println("2. Update Contact");
        System.out.println("3. Delete Contact");
        System.out.println("4. Search Contact");
        System.out.println("5. Get Contacts");
        System.out.println("Q/q. Exit");
    }

    public static String getToken() {
        return scanner.nextLine().trim();
    }
}
