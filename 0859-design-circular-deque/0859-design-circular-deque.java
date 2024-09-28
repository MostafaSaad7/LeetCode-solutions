class MyCircularDeque {

    private int[] deque;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Constructor initializes the deque with a maximum size of k
    public MyCircularDeque(int k) {
        deque = new int[k];
        front = 0;
        rear = k - 1;
        size = 0;
        capacity = k;
    }
    
    // Insert an element at the front. Returns true if successful.
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        deque[front] = value;
        size++;
        return true;
    }
    
    // Insert an element at the rear. Returns true if successful.
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % capacity;
        deque[rear] = value;
        size++;
        return true;
    }
    
    // Delete an element from the front. Returns true if successful.
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        size--;
        return true;
    }
    
    // Delete an element from the rear. Returns true if successful.
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return true;
    }
    
    // Get the front element. Returns -1 if the deque is empty.
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return deque[front];
    }
    
    // Get the rear element. Returns -1 if the deque is empty.
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return deque[rear];
    }
    
    // Check if the deque is empty.
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Check if the deque is full.
    public boolean isFull() {
        return size == capacity;
    }
}
