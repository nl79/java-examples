class Node {

  Node next;
  Node prev;
  
  int value;

  public Node(int val) {
    this.value = val;
  }

  public void insertBefore(Node node) {

  }

  public void insertAfter(Node node) {

  }

  public void setValue(int val) {
    this.value = val;
  }

  public void displayNode() {
    System.out.print("{ " + this.value + " }");
  }

}