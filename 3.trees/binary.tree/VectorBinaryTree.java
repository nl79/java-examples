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
  int count = 0;

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

    // Add the node to the vector at the specific position.
    this.tree.set(node.pos, node);

    // Increment the Node count.
    this.count++;

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
    int pos = 2 * this.p(node);
    
    // Validate the index is within bounds.
    if(!this.validPosition(pos)) {
      return null;
    }
    return this.tree.elementAt(pos);
  }

  public Node rightChild(Node node) {
    int pos = 2 * this.p(node) + 1;

    // Validate the index is within bounds.
    if(!this.validPosition(pos)) {
      return null;
    }
    
    return this.tree.elementAt(pos);
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

  public int countLeves() {
    return this.countLeves(this.root());
  }
  public int countLeves(Node node) {
    if(node == null) {
      return 0;
    }

    Node left = this.leftChild(node);
    Node right = this.rightChild(node);

    if(left == null && right == null) {
      return 1;
    } else {
      return this.countLeves(left) + this.countLeves(right);
    }
  }

  public int countArcs() {
    return this.countArcs(this.root());
  }
  public int countArcs(Node node) {
    return this.countNodes() - 1;
  }

  public int countNodes() {
    // Can return the local property count also since starting from the root.
    return this.countNodes(this.root());
  }

  public int countNodes(Node node) {
    if(node == null) {
      return 0;
    }

    return 1 + (this.countNodes(this.leftChild(node)) + this.countNodes(this.rightChild(node)));
  }

  public int countInternalNodes() {
    return this.countInternalNodes(this.root());
  }

  public int countInternalNodes(Node node) {
    if(node == null) {
      return 0;
    }

    Node left = this.leftChild(node);
    Node right = this.rightChild(node);

    // Check if Leaf.
    if(left == null && right == null) {
      return 0;
    } else {
      return 1 + (this.countInternalNodes(left) + this.countInternalNodes(right));
    }

  }

  public int depth() {
    return this.depth(this.root());
  }

  public int depth(Node node) {
    if(node == null) {
      return 0;
    }

    return 1 + (Math.max(this.depth(this.leftChild(node)), this.depth(this.rightChild(node))));
  }
  
  private boolean validPosition(int i) {
    return i < this.tree.size();
  }
}