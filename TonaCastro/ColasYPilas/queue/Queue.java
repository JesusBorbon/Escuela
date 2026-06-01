package queue;

public class Queue { // This assignment is to practice implementing a Queue (FIFO)
    
    private int[] queue;
    private int capacity;
    private int front;        // Points to the front element (where items are removed)
    private int rear;         // Points to the back element (where items are added)
    private int currentSize;  // Tracks the total number of items currently in the queue
    
    // Constructor to set up the queue with a fixed size
    public Queue(int size) {
        queue = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        currentSize = 0; // The queue starts empty
    }
    
    // Prints the current elements from front to back without using modulo
    public void displayQueue() {
        System.out.print("Queue state: [");
        int index = front;
        for (int i = 0; i < currentSize; i++) {
            System.out.print(queue[index]);
            
            // Manually advance the index and wrap around if we hit the array boundary
            index++;
            if (index == capacity) {
                index = 0;
            }
            
            if (i < currentSize - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    // Adds an element to the back of the queue (Enqueue)
    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("The queue is full. Cannot insert: " + element);
            System.exit(1);
        }
        
        // Manually move the rear pointer forward and wrap around if necessary
        rear++;
        if (rear == capacity) {
            rear = 0;
        }
        
        queue[rear] = element;
        currentSize++; // Increase our element counter
        displayQueue();
    }
    
    // Removes and returns the element at the front of the queue (Dequeue)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("The queue is empty. Cannot remove elements.");
            System.exit(1);
        }
        
        int removedElement = queue[front];
        
        // Manually move the front pointer forward and wrap around if necessary
        front++;
        if (front == capacity) {
            front = 0;
        }
        
        currentSize--; // Decrease our element counter
        displayQueue();
        return removedElement;
    }
    
    // Checks if the queue has no elements
    public boolean isEmpty() {
        return currentSize == 0;
    }
    
    // Checks if the queue has reached its maximum limit
    public boolean isFull() {
        return currentSize == capacity;
    }
    
    // Returns the current count of elements in the queue
    public int size() {
        return currentSize;
    }
    
    // Returns the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("The queue is empty.");
            System.exit(1);
        }
        return queue[front];
    }
}