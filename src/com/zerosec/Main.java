package com.zerosec;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contact> contacts;
    private static Scanner scanner;
    private static int id = 0;
    public static void main(String[] args){
        contacts = new ArrayList<>();
        System.out.println("Welcome to ****ing programming world");
        showInitialOption();
    }

    private static void showInitialOption(){
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

    private static void manageMassages() {
        System.out.println("Please select one:"+
                "\n\t1. Show all massages"+
                "\n\t2. send a new massage"+
                "\n\t3. Go back");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                showAllMassages();
                break;
            case 2:
                sendNewMassage();
                break;
            default:
                showInitialOption();
                break;
        }
    }

    private static void sendNewMassage() {
        System.out.println("Who are you going to send massage: ");
        String name = scanner.next();
        if(name.equals("")) {
            System.out.println("Please enter the name:");
            sendNewMassage();
        }else {
            boolean doesExist = false;
            for (Contact c:contacts){
                if(c.getName().equals(name)){
                    doesExist = true;
                }
            }
            if(doesExist){
                System.out.println("What are you going to say....");
                String text = scanner.next();
                if(text.equals("")){
                    System.out.println("Please write some text......");
                    sendNewMassage();
                }else {
                    id++;
                    Massage newMassage = new Massage(text,name,id);
                    for (Contact c : contacts){
                        if(c.getName().equals(name)){
                            ArrayList<Massage> newMassages = c.getMassages();
                            newMassages.add(newMassage);
                            c.setMassages(newMassages);

                        }
                    }
                }
            }else {
                System.out.println("There are no such contact.");
            }
        }
        showInitialOption();
    }

    private static void showAllMassages() {
        ArrayList<Massage> allMassages = new ArrayList<>();
        for (Contact c: contacts){
            allMassages.addAll(c.getMassages());
        }

        if(allMassages.size()>0){
            for(Massage c: allMassages){
                c.getDetails();
                System.out.println("***********");

            }
        }
        else {
            System.out.println("You don't have any massages.....");

        }

        showInitialOption();
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
                showInitialOption();
                break;
        }
    }

    private static void deleteContact() {
        System.out.println("Please enter the contact name for deleting:");
        String name = scanner.next();
        if(name.equals("")){
            System.out.println("Please enter the name:");
            deleteContact();
        }else {
            boolean doesExist= false;
            for(Contact c:contacts){
                if(c.getName().equals(name)){
                    doesExist = true;
                    contacts.remove(c);
                }
            }
            if(!doesExist){
                System.out.println("There are no such contact.");
            }
            showInitialOption();
        }
    }

    private static void searchContact() {
        System.out.println("Please enter the contact name:");
        String name = scanner.next();
        if(name.equals("")){
            System.out.println("Please enter the name:");
            searchContact();
        }else {
            boolean doesExist= false;
            for(Contact c:contacts){
                if(c.getName().equals(name)){
                    doesExist = true;
                    c.getDetails();
                }
            }
            if(!doesExist){
                System.out.println("There are no such contact.");
            }
            showInitialOption();
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
        }
        else {

            boolean doesExit = false;
            for(Contact c: contacts){
                if(c.getName().equals(name)){
                    doesExit = true;
                }
            }
            if(doesExit){
                System.out.println(name+" is already exists...");
                addNewContact();
            }
            else {
                Contact contact = new Contact(name,number,email);
                contacts.add(contact);
                System.out.println(name+ " added successfully....");
            }

        }
        showInitialOption();
    }

    private static void showAllContacts() {
        if(contacts.size()>0){
            for(Contact c:contacts){
                c.getDetails();
                System.out.println("******************");
            }
        }else{
            System.out.println("You don't have any contact.");
        }

        showInitialOption();
    }

}
