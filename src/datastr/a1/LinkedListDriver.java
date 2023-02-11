package datastr.a1;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class LinkedListDriver {
    public static void main(String[] args) {

        try {
            File fileName = new File(args[0]);
            Scanner scan = new Scanner(fileName);
            SortedLinkedList list = new SortedLinkedList();
            while(scan.hasNextInt()) {
                ItemType item = new ItemType();
                item.initialize(scan.nextInt());
                list.insertItem(item);
            } // while

            String command = "";
            System.out.print("Enter a command: ");

            while (!command.equals("q")) {
                boolean invalid = false;
                Scanner scanCom  = new Scanner(System.in);
                command = scanCom.next();
                // user input

                if (command.equals("p")) {
                    System.out.print("The list is: ");
                    list.print();
                    // prints list
                } else if (command.equals("l")) {
                    System.out.print("The length of the list is ");
                    System.out.println(list.getLength());
                } else if (command.equals("i")) {
                    System.out.print("Enter a number to insert: ");
                    scanCom = new Scanner(System.in);
                    ItemType insertVal = new ItemType();
                    insertVal.initialize(scanCom.nextInt());
                    // asks and stores insert value

                    System.out.print("Original list : ");
                    list.print();
                    // prints original list

                    list.insertItem(insertVal); // inserts insert Val
                    System.out.print("New list : ");
                    list.print();
                    // prints original list
                } else if (command.equals("s")) {
                    System.out.print("Enter a number to search: ");
                    scanCom = new Scanner(System.in);
                    ItemType searchVal = new ItemType();
                    searchVal.initialize(scanCom.nextInt());
                    // asks and stores search value

                    System.out.print("Original list : ");
                    list.print();
                    if (list.searchItem(searchVal) == -1) {
                        System.out.println("Item is not present in the list");
                    } else {
                        System.out.println("The item is present at index "
                        + list.searchItem(searchVal));
                    } // if
                    // displays print statements
                } else if (command.equals("n")) {
                    list.getNextItem();
                } else if (command.equals("r")) {
                    list.resetList();
                } else if (command.equals("q")) {
                    System.out.println("Exiting the program...");
//                    exit();
                } else {
                    invalid = true;
                    System.exit(0);
                } // if
                // all command cases

                if (invalid) {
                    System.out.print("Invalid command, try again: ");
                } else if (!command.equals("q")){
                    System.out.print("Enter a command: ");
                }
                //prompting user

            } // while
            // loop to prompt user




        } catch (FileNotFoundException fnfe) {
            System.out.println("File Not Found");
        } // try



     } // main
} // LinkedListDriver
