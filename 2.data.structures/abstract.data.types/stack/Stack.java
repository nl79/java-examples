public class Stack {
  private int maxSize;
  private long[] stackArray;
  private int top;

  public Stack(int size) {
    this.maxSize = size;
    this.stackArray = new long[this.maxSize];
    this.top = -1;
  }

  public void push(long j) {
    if(isFull()) {
      System.out.println("the stack is already full");
    } else {
      this.top++;
      this.stackArray[top] = j;
    }
  }

  public long pop() {
    if(this.isEmpty()) {
      System.out.println(" the stack is already empty");
      return -1;
    } else {
      this.top--;
      return this.stackArray[this.top+1];
    }
  }

  public long peak() {
    return this.stackArray[this.top];
  }

  public boolean isEmpty() {
    return (this.top == -1);
  }

  public boolean isFull() {
    return (this.top == maxSize-1);
  }
}