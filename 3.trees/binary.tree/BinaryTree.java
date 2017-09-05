class Node<E> {
  int key;
  E data;

  Node left;
  Node right;

  Node(int key, E data) {
    this.key = key;
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

public class BinaryTree<E> {

  Node root;
  int count = 0;

  public BinaryTree() {}

  public Node<E> insert(int key, E data) {
    Node newNode = new Node<E>(key, data);

    // Check if root exists, if not this will be the root note.
    if(this.root == null) {
      this.root = newNode;
    } else {

      // Drill down to find the location of the new node.
      Node current = root;
      Node parent;

      while (true) {
        parent = current;

        if( key < current.key) {
          current = current.left;

          // Check if null, if so insert
          if(current == null) {
            parent.left = newNode;
            break;
          }

        } else {
          // The node may go on the right.
          current = current.right;

          if(current == null) {
            parent.right = newNode;
            break;
          }
        }

      }
    }

    this.count++;
    // Return the newly created node;
    return newNode;
  }

  public int countLeves() {
    return this.countLeves(this.root);
  }

  public int countLeves(Node node) {
    if(node == null) {
      return 0;
    }
    if(node.left == null && node.right == null) {
      return 1;
    } else {
      return this.countLeves(node.left) + this.countLeves(node.right);
    }
  }

  public int countArcs() {
    return this.countArcs(this.root);
  }
  public int countArcs(Node node) {
    return this.countNodes(node) - 1;
  }

  public int countNodes() {
    return this.countNodes(this.root);
  }
  public int countNodes(Node node) {
    if(node == null) {
      return 0;
    }
    return 1 + (this.countNodes(node.left) + this.countNodes(node.right));
  }

  public int countInternalNodes() {
    return this.countInternalNodes(this.root);
  }
  public int countInternalNodes(Node node) {
    if(node == null || (node.left == null && node.right == null)) {
      return 0;
    }
    return 1 + (this.countInternalNodes(node.left) + this.countInternalNodes(node.right));        
  }

  public int depth() {
    return this.depth(this.root);
  }
  public int depth(Node node) {
    if(node == null) {
      return 0;
    } else {
      return 1 + (Math.max(this.depth(node.left), this.depth(node.right)));
    }
     
  }
  public int count() {
    return this.count;
  }
}