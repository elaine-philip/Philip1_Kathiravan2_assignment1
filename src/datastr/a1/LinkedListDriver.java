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
/**
            ItemType item2 = new ItemType();
            item2.initialize(2);
            list.insertItem(item2);
            // add to begining

            ItemType item9 = new ItemType();
            item9.initialize(9);
            list.insertItem(item9);
            // add to middle

            ItemType item30 = new ItemType();
            item30.initialize(30);
            list.insertItem(item30);
            // add to end
            */
            // insert tests

            list.deleteItem(new ItemType());
            // prints list

            ItemType item3 = new ItemType();
            item3.initialize(3);
            list.searchItem(item3);

        } catch (FileNotFoundException fnfe) {
            System.out.println("File Not Found");
        } // try



     } // main
} // LinkedListDriver
