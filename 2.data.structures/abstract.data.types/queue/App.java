public class App {
  public static void main(String[] args) {
    Queue myQueue = new Queue(5);

    myQueue.insert(1234);
    myQueue.insert(12234);
    myQueue.insert(3);
    myQueue.insert(25);
    myQueue.insert(11);
    myQueue.insert(1);
    myQueue.insert(2);

    myQueue.view();

  }
}