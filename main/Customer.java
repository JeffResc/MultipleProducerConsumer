package main;

public class Customer implements Runnable {
    /**
     * Must wait for between 0 and 4 seconds.
     */
    private final static int MAX_CUSTOMER_MILLIS = 4000;

    /**
     * Table object that this Customer sits at.
     */
    private Table table;

    /**
     * Name of this Customer.
     */
    private String customerName;

    /**
     * Name of dish.
     */
    private String dish;

    /**
     * Get customer name.
     * @return customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Initializes the data.
     * @param table
     * @param customerName
     */
    public Customer(Table table, String customerName) {
        this.table = table;
        this.customerName = customerName;
    };

    /**
     * Generates a random time for this customer to eat.
     * @return time
     */
    private int generateEatTime() {
        return (int)(Math.random() * MAX_CUSTOMER_MILLIS);
    }

    /**
     * For each customer, a thread on this Customer object eats the three courses
     * in the correct orderby calling the eat() method in the corresponding Table, 
     * prints out what course this Customer is eating, and sleeps for a random time
     * between 0 & 4 seconds to mimic time taken to eat.
     */
    @Override
	public void run() {
        dish = table.eat();

        while(!dish.equals("DONE")) {
            System.out.println(customerName + " is eating: " + dish);
            try {
                Thread.sleep(generateEatTime());
            } catch (InterruptedException e){
                System.err.println("Unable to sleep while eating dish " + dish + ": " + e.getMessage());
            }
            dish = table.eat(); 
        }
    }
}
