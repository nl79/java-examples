public class SinglyLinkedList {
  private Node first;

  public SinglyLinkedList () {

  }

  public boolean isEmpty() {
    return (first == null);
  }

  // used to insert at the beginning of the list
  public void insertFirst(int data) {
    Node newNode = new Node(data);
    newNode.next = this.first;
    this.first = newNode;
  }

  public void insertLast(int data) {
    Node current = this.first;
    while(current.next != null) {
      current = current.next;
    }

    current.next = new Node(data);
  }

  public Node deleteFirst() {
    Node temp = this.first;
    first = first.next;
    return temp;
  }

  public void dislayList() {
    System.out.println("List (first --> last) ");
    Node current = first;
    while(current != null) {
      current.displayNode();
      current = current.next;
    }
  }
}