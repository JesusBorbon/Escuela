package queue;

public class Main {
    
    public static void main(String[] args) {
        
        // Create a queue that can hold up to 5 elements
        Queue queue = new Queue(5);
        
        // Add 5 elements to fill up the queue
        System.out.println("--- Enqueueing Elements ---");
        queue.enqueue(78);
        queue.enqueue(20);
        queue.enqueue(10);
        queue.enqueue(38);
        queue.enqueue(90);
        
        // Check the status of the full queue
        System.out.println("\nIs the queue full? " + queue.isFull());
        System.out.println("The front element of the queue is: " + queue.peek());
        System.out.println("Current queue size: " + queue.size());
        
        // Remove the first 2 elements (78 was added first, so it leaves first)
        System.out.println("\n--- Dequeueing 2 Elements ---");
        System.out.println("Removing element...");
        queue.dequeue(); // Removes 78
        System.out.println("Removing element...");
        queue.dequeue(); // Removes 20
        
        // Check who is at the front now
        System.out.println("\nThe new front element is: " + queue.peek());
        System.out.println("Is the queue empty? " + queue.isEmpty());
        
        // Remove the remaining 3 elements to completely empty it
        System.out.println("\n--- Dequeueing Remaining Elements ---");
        System.out.println("Removing element...");
        queue.dequeue(); // Removes 10
        System.out.println("Removing element...");
        queue.dequeue(); // Removes 38
        System.out.println("Removing element...");
        queue.dequeue(); // Removes 90
        
        // Final check to confirm it is empty
        System.out.println("\nIs the queue empty now? " + queue.isEmpty());
    }
}