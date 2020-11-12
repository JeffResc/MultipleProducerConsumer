package main;

public class Table {
    /**
     * The name of the course.
     */
    private String course;

    /**
     * A flag used to see if the table is empty or is not empty.
     * (i.e., has an unfinished course)
     */
    private boolean isEmpty;

    /**
     * Default constructor.
     */
    public Table() {
        course = null;
        isEmpty = true;
    }

    /**
     * Setter for isEmpty
    */
    public void setIsEmpty(Boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    /**
     * Implements the Waiter serving a course.
     * @param course
     */
    public synchronized void serve(String course) {
        while(!isEmpty) {
            try {
                wait();
            } catch(InterruptedException e){
                System.err.println("Unable to serve " + course + ": " + e.getMessage());
            }
        }
        this.course = course; 
        isEmpty = false; 
        notifyAll();
    }

    /**
     * Implements the Customer eating a course.
     * @return course
     */
    public synchronized String eat() {
        while (isEmpty){
            try {
                wait();
            } catch(InterruptedException e){
                System.err.println("Unable to eat course " + course + ": " + e.getMessage());
            }
        }
        isEmpty = true; 
        notifyAll();
        return course;
    }
}
