public class AirportTerminal {

  public static void main(String[] args) {
    Queue myQueue = new Queue(5);
    Queue firstClass = new Queue(5);

    myQueue.insert(1234);
    myQueue.insert(12234);
    myQueue.insert(3);
    myQueue.insert(25);
    myQueue.insert(11);

    myQueue.view();
  }

}