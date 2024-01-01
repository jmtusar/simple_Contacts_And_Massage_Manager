package com.zerosec;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contact> contacts;
    private static Scanner scanner;
    public static void main(String[] args){
        contacts = new ArrayList<>();
        System.out.println("Welcome to ****ing programming world");
        showInitializOption();
    }

    private static void showInitializOption(){
        System.out.println("Please select one: "+
                "\n\t1. Manage Contacts"+
                "\n\t2. Massages"+
                "\n\t3. Quit");
        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                manageContacts();
                break;
            case 2:
                manageMassages();
                break;
            default:
                break;
        }
    }

    private static void manageContacts() {
        System.out.println("Please select one:"+
                "\n\t1. Show all contacts"+
                "\n\t2. Add a new contact"+
                "\n\t3. Search contact"+
                "\n\t4. Delete a contact"+
                "\n\t5. Go back");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                showAllContacts();
                break;
            case 2:
                addNewContact();
                break;
            case 3:
                searchContact();
                break;
            case 4:
                deleteContact();
                break;
            default:
                showInitializOption();
                break;
        }
    }

    private static void addNewContact() {
        System.out.println("Adding new Contact...."+
                "\nPlease enter the Contact's name: ");
        String name = scanner.next();
        System.out.println("Please enter the Contact's number: ");
        String number = scanner.next();
        System.out.println("Please inter the Contact's email: ");
        String email = scanner.next();

        if(name.equals("")||number.equals("")||email.equals("")){
            System.out.println("Please enter the all information:");
            addNewContact();
        }else {
            Contact contact = new Contact(name,number,email);
            contacts.add(contact);
        }
        showInitializOption();
    }

    private static void showAllContacts() {
        for(Contact c:contacts){
            c.getDetails();
        }
        showInitializOption();
    }

}