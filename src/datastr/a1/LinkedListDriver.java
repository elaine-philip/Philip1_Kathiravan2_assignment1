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
                    // prints new list
                } else if (command.equals("s")) {
                    System.out.print("Enter a number to search: ");
                    scanCom = new Scanner(System.in);
                    ItemType searchVal = new ItemType();
                    searchVal.initialize(scanCom.nextInt());
                    // asks and stores search value

                    System.out.print("Original list : ");
                    list.print();
                    if (list.searchItem(searchVal) == 0) {
                        System.out.println("The list is empty");
                    } else if (list.searchItem(searchVal) == -1) {
                        System.out.println("Item is not present in the list");
                    } else {
                        System.out.println("The item is present at index "
                        + list.searchItem(searchVal));
                    } // if
                    // displays print statements
                } else if (command.equals("d")) {
                    System.out.print("Enter a number to delete: ");
                    scanCom = new Scanner(System.in);
                    ItemType deleteVal = new ItemType();
                    deleteVal.initialize(scanCom.nextInt());
                    // asks and stores search value

                    System.out.print("Original list : ");
                    list.print();
                    // prints original list

                    list.deleteItem(deleteVal); // inserts insert Val
                    System.out.print("New list : ");
                    list.print();
                    // prints new list
                } else if (command.equals("n")) {
                    list.getNextItem();
                } else if (command.equals("r")) {
                    list.resetList();
                } else if (command.equals("a")) {
                    System.out.print("Original list : ");
                    list.print();
                    // prints original list

                    list.deleteAlt();
                    System.out.print("New list : ");
                    list.print();
                    // prints new list
                } else if (command.equals("m")) {
                    //Merge a list to the original list
                    System.out.print("Enter the length of the new list: ");
                    scanCom = new Scanner(System.in);
                    int num = scanCom.nextInt();
                    int count = 0;
                    int [] values= new int[num];
                    System.out.print("Enter the numbers ");
                    while(scanCom.hasNext()) {
                        values[count] = scanCom.nextInt();
                        count++;
                        if (count == num) break;
                    }
                    SortedLinkedList list2 = new SortedLinkedList();
//                    System.out.println(num);
                    for (int i = 0; i < values.length; i++) {
                        ItemType item = new ItemType();
                        item.initialize(values[i]);
                        list2.insertItem(item);

                    }
                    // DEBUG
//                    list2.print();


                    NodeType head = list.getHead();
                    System.out.print("list 1: ");
                    list.print();
                    System.out.print("list 2: ");
                    list2.print();
                    head = SortedLinkedList.sortedMergeNoDupe(list.getHead(), list2.getHead());
                    System.out.print("Merged list: ");
                    list.print();

                } else if (command.equals("t")) {
                    System.out.print("Enter the length of the new list: ");
                    scanCom = new Scanner(System.in);
                    int num = scanCom.nextInt();
                    int count = 0;
                    int [] values= new int[num];
                    System.out.print("Enter the numbers: ");
                    while(scanCom.hasNext()) {
                        values[count] = scanCom.nextInt();
                        count++;
                        if (count == num) break;
                    }
                    SortedLinkedList list2 = new SortedLinkedList();
                    for (int i = 0; i < values.length; i++) {
                        ItemType item = new ItemType();
                        item.initialize(values[i]);
                        list2.insertItem(item);
                    }
                    System.out.print("list 1: ");
                    list.print();
                    System.out.print("list 2: ");
                    list2.print();
                    System.out.println("Intersection of lists: " + list.intersectionList(list2));

                } else if (command.equals("q")) {
                    System.out.println("Exiting the program...");
                    System.exit(0);
                } else {
                    invalid = true;
                } // if
                // all command cases
                if (invalid) {
                    System.out.print("Invalid command, try again: ");
                } else if (!command.equals("q")){
                    System.out.print("Enter a command: ");
                } // if
                //prompting user

            } // while
            // loop to prompt user
        } catch (FileNotFoundException fnfe) {
            System.out.println("File Not Found");
        } // try



     } // main
} // LinkedListDriver
