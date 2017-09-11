public class Queue {
  private int maxSize;
  private long[] queArray;
  private int front;
  private int rear;
  private int nItems; // counter to maintain the number of items in the queue.

  public Queue(int size) {
    this.maxSize = size;
    this.queArray = new long[size];
    this.front = 0;
    this.rear = -1; // There is no iteam in the array to be considered the last item.
    this.nItems = 0;
  }

  public void insert(long j) {
    // Check if full
    if(this.isFull() == true) {
      // Expand the capacity.
      this.expand();
    }
    
    this.rear = this.nextPos();

    this.queArray[this.rear] = j;
    this.nItems++;
  }

  private int nextPos() {
    int nextRear = (++this.rear);

    return (nextRear >= this.queArray.length) ? nextRear % this.queArray.length : nextRear;
  }

  public long remove() { // remove item from the front of the queue
    long temp = this.queArray[this.front];
    this.front++;

    if(this.front == this.maxSize) {
      this.front = 0;
    }
    this.nItems--;

    return temp;
  }

  public void expand() {
    // New max size value.
    int tempNewMax = this.maxSize * 2;

    // Create a new array of the new size.
    long newQueArray[] = new long[tempNewMax];

    // Holds the last occupied position in the new array.
    int rear = 0;

    // Copy 'front' values from the old queArray.
    for(int i = this.front; i<this.queArray.length; ++i, ++rear) {
      newQueArray[rear] = this.queArray[i];
    }

    // Copy the 'back' value from the old queArray.
    for(int i = 0; i < this.front; ++i, ++rear) {      
      newQueArray[rear] = this.queArray[i];
    }
    
    // Set the new Values
    this.maxSize = tempNewMax;
    this.queArray = newQueArray;
    this.front = 0;
    this.rear = --rear;
  }

  public long peekFront() {
    return this.queArray[this.front];
  }

  public boolean isEmpty() {
    return this.nItems == 0;
  }

  public boolean isFull() {
    return this.nItems == this.maxSize;
  }

  public void view() {
    System.out.print("[ ");
    for(int i = 0; i < this.queArray.length; i++) {
      System.out.print(this.queArray[i] + " ");
    }
    System.out.print(" ]");
  }
}