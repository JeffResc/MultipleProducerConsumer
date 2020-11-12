package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurant {
    /**
     * Current open filename.
     */
    private String filename;

    /**
     * Number of waiters at this restaurant.
    */
    private int numWaiters = 0;

    /**
     * Constructor.
     * @param filename
     */
    public Restaurant() {};

    /**
     * Prompts the user to enter a filename.
     * Sets filename to filename variable.
     */
    private void getFileFromInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the file to test:");
        filename = sc.nextLine().toString();
        sc.close();
    }
    
    /**
     * Convert a List of Customers to a List of CustomerNames.
     * @param customers
     * @return customerNames[]
     */
    private String[] customersToNames(List<Customer> customers) {
        List<String> customerNames = new ArrayList<String>();
        for (Customer c: customers) {
            customerNames.add(c.getCustomerName());
        }
        return customerNames.toArray(new String[0]);
    }

    /**
     * Parse a line to create and run Waiter and Customer instances.
     * @param line
     */
    private void parseLine(String line) {
        try {
            final String[] lineArray = line.split(" ");

            final String waiterName = lineArray[0];
            final int numCustomers = Integer.parseInt(lineArray[1]);

            List<Customer> customers = new ArrayList<Customer>();
            List<Table> tables = new ArrayList<Table>();
            List<List<String>> courses = new ArrayList<List<String>>();  

            for (int i = 0; i < numCustomers; i++) {
                final int j = (i*4)+2;
                List<String> coursesForCustomer = new ArrayList<String>();
                Table t = new Table();
                customers.add(new Customer(t, lineArray[j])); // customer name
                coursesForCustomer.add(lineArray[j+1]); // appetizer
                coursesForCustomer.add(lineArray[j+2]); // main course
                coursesForCustomer.add(lineArray[j+3]); //dessert
                tables.add(t);
                courses.add(coursesForCustomer);
            }

            // Convert courses (List<List<String>>) to coursesArray (String[][])
            String[][] coursesArray = new String[courses.size()][];
            int i = 0;
            for (List<String> course : courses) {
                coursesArray[i++] = course.toArray(new String[course.size()]);
            }

            final Table[] tablesArray = tables.toArray(new Table[0]);
            Thread w = new Thread(new Waiter(tablesArray, waiterName, customersToNames(customers), coursesArray));

            w.start();
            for (Customer c : customers) {
                final Thread t = new Thread(c);
                t.start();
            }
        } catch (NullPointerException e) {
            System.out.println("Unable to parse file " + filename + ": Check your document formatting and try again.");
            System.exit(0);
        }
    }

	/**
     * Reads the file at filename.
     */
    private void readFileContents() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            // First line is always number of waiters
            numWaiters = Integer.parseInt(br.readLine());

            // Read a line for every waiter
            for(int i = 0; i < numWaiters; i++) {
                parseLine(br.readLine());
            }

            br.close();
        } catch (IOException e) {
            System.out.println("IOException while reading " + filename + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        final Restaurant r = new Restaurant();
        // Read in file name
        r.getFileFromInput();
        // Parse file and run threads
        r.readFileContents();
    }
}
