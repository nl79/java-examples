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
    this.rear++;
    this.queArray[this.rear] = j;
    this.nItems++;
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