package main;

public class Waiter implements Runnable {
    /**
     * Must wait for between 0 and 4 seconds.
     */
    private final static int MAX_WAITER_MILLIS = 4000;

    /**
     * Number of courses is exactly three.
     */
    private final static int N_COURSES = 3;

    /**
     * Array of Table objects this Waiter waits on.
     */
    private Table[] tables;

    /**
     * Name of this Waiter.
     */
    private String waiterName;

    /**
     * Names of Customers served by Waiter.
     */
    private String[] customerNames;
    
    /**
     * Multi-dimensional array of courses for each Customer of this Waiter.
     * (courses[i][j] has the j-th course for the i-th Customer of this Waiter)
     */
    private String[][] courses;

    /**
     * Initializes the data.
     * @param tables
     * @param waiterName
     * @param customerNames
     * @param courses
     */
    public Waiter(Table[] tables, String waiterName, String[] customerNames, String[][] courses) {
        this.tables = tables;
        this.waiterName = waiterName;
        this.customerNames = customerNames;
        this.courses = courses;
    };

    /**
     * Generates a random time for this waiter to serve.
     * @return time
     */
    private int generateServeTime() {
        return (int)(Math.random() * MAX_WAITER_MILLIS);
    }

    /**
     * For each customer, a thread on this Waiter object serves the three courses
     * in the correct orderby calling the serve() method in the corresponding Table,
     * prints out what course is served to which Customer, and sleeps for a random
     * time between 0 & 4 seconds to mimic time taken in serving.
     */
    @Override
	public void run() {
        // For each customer
        for(int i = 0; i < customerNames.length; i++) {
            // For each course
            for(int j = 0; j < N_COURSES; j++){
                // Print serve message
                System.out.println(this.waiterName + " serves " + customerNames[i] + ": " + courses[i][j]);
                // Serve the course
                tables[i].serve(courses[i][j]); 
                // Sleep
                try{
                    Thread.sleep(generateServeTime());
                } catch(InterruptedException e){
                    System.out.println(e.getMessage());
                }
            }
            tables[i].serve("DONE"); 
        }
    }
}
