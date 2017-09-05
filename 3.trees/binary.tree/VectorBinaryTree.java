import java.util.Vector;

class Node<E> {
  int key;
  E data;
  int pos;

  Node left;
  Node right;

  Node(int key, E data) {
    this.key = key;
    this.data = data;
    this.left = null;
    this.right = null;
    this.pos = null;
  }
}

public class VectorBinaryTree<T> {

  Vector<Node<T>> tree = new Vector<Node<T>>(50, 50);

  public VectorBinaryTree() {}

  public Node insert(int key, T data) {
    Node<T> node = new Node<T>(key, data);
    this.tree.insertElementAt(node, key);
    return node;
  }

  public int p(node) {
    if(node.pos !== null) {
      return node.pos;
    }

    Node current;

    // Find a suitable position for the node.
    while(true){
      current = this.root();
      if(current.key < )
    }
  }

  public void root() {
    System.out.println("this.tree.size()" + this.tree.size());
    if(this.tree.size()>0) {
      return this.tree.elementAt(0);
    } else {
      throw new IndexOutOfBoundsException();
    }
  }
  /*
  public Node parent() {

  }

  public Node leftChild() {


  }

  public Node rightChild() {

  }

  public boolean isInternal() {

  }

  public boolean isExternal() {

  }

  public boolean isRoot() {

  }
  */

}