public class App {
  public static void main(String[] args) {
    SinglyLinkedList list = new SinglyLinkedList();

    list.insertFirst(1);
    list.insertFirst(2);
    list.insertFirst(3);
    list.insertFirst(4);
    list.insertFirst(5);

    list.insertLast(6);
    list.insertLast(7);
    list.insertLast(8);
    list.insertLast(9);
    list.insertLast(10);

    list.dislayList();

  }
}