package basicExamples;

import utilities.Printer;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void printStuff(String x) {
        System.out.println(x);
    }
    public static void main(String[] args){
        //Calling my function
        printStuff("Using my print function");

        /*
        * Instantiates a printer
        * using print method from the Printer class
        * prints out the name of the Printer
        */
        Printer p1 = new Printer("Super Printer 2000", 2000);
        Printer p2 = new Printer("Mega Printer XXX", 5000);
        p1.print("Printing using a method inside Printer Class");
        p2.print("hej hej ");
        System.out.println("Name: " + p1.getName());
        System.out.println("Price: " + p1.getPrice());
        //Creating a list of printers
        List<Printer> printers = new ArrayList<>();
        printers.add(p1);
        printers.add(p2);
        System.out.println("Looping Printers in Printer List");
        for (Printer p: printers){
            System.out.println(p.getName());
        }
        // Printing first printers name in printers,
        System.out.println(printers.get(0).getName());
        // Creating an Array
        String[] myArray = {"Hello", "There"};
        System.out.println(myArray[0]);
        System.out.println("Looping the Array elements");
        for (String s : myArray) {
            System.out.println(s);
        }
        // Creating a List
        List<String> myList = new ArrayList<String>();
        myList.add("Jonathan");
        myList.add("Andreassen");
        // Looping through the objects in the list
        System.out.println("Looping the List elements");
        myList.forEach(System.out::println);
        System.out.println(myList.contains("Jonathan"));
    }
}
