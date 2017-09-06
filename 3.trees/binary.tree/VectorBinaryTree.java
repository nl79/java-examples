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
    this.pos = 0;
  }

  public String toString() {
    return "key: " + this.key + " | data: " + data.toString() + " | pos: " + this.pos;
  }
}

public class VectorBinaryTree<T> {

  Vector<Node<T>> tree;

  public VectorBinaryTree() {
    this.tree = new Vector<Node<T>>(50);
    this.tree.setSize(50);
  }

  private void expand(int size) {
    this.tree.ensureCapacity(size);
    this.tree.setSize(this.tree.capacity());
  }

  public Node insert(int key, T data) {
    Node<T> node = new Node<T>(key, data);
    node.pos = this.p(node);

    this.tree.set(node.pos, node);
    return node;
  }

  public int p(Node node) {
    if(node.pos > 0) {
      return node.pos;
    }

    Node current = this.root();
     // Check if root Node.
    if(current == null) {
      // Assign position 1 to the root node.
      return 1;
    }

    int pos;

    // Find a suitable position for the node.
    while(true){

      // Decide if to use the left or the right child based on the key value.
      pos = node.key < current.key ? (2 * current.pos) : (2 * current.pos) + 1;

      // Check that the new index will fit into the array.
      if(this.tree.size() <= pos) {

        // If  vector expansion is required no more child nodes can be present. 
        // return the next position.
        this.expand(pos);
        break;
      }

      // Get the next node and set it as the current one.
      current = this.tree.get(pos);

      // If the new current node is null, use the position value for the 
      // next node.

      if(current == null) { break; }

    }

    return pos;
  }

  public Node root() {
    if(this.tree.size()>0) {
      return this.tree.elementAt(1);
    } else {
      throw new IndexOutOfBoundsException();
    }
  }

  public Node parent(Node node) {
    int pos = (int)Math.floor(this.p(node)/2);
    return this.tree.get(pos);
  }


  public Node leftChild(Node node) {
    return this.tree.elementAt(2 * this.p(node));
  }

  public Node rightChild(Node node) {
    return this.tree.elementAt(2 * this.p(node) + 1);
  }

  public boolean isRoot(Node node) {
    return (this.root() == node);
  }

  public boolean isExternal(Node node) {
    return (this.leftChild(node) == null && this.rightChild(node) == null);

  }
  public boolean isInternal(Node node) {
    return this.isExternal(node) ? false : true;
  }

  
}