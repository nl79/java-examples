import java.util.Random;
public class App {
  public static void main(String[] args) {

    BinaryTree tree = new BinaryTree<String>();
    String[] strings = {
      "a", "b", "c", "d", "e", "f", "g"
    };

    Random rand = new Random();

    for (int i = 0; i < strings.length; ++i) {
      tree.insert(rand.nextInt(50) + i, strings[i]);
    }

    System.out.println("Count: " + tree.count());
    System.out.println("Depth: " + tree.depth());    
    System.out.println("Count Leves: " + tree.countLeves());
    System.out.println("Count Nodes: " + tree.countNodes());
    System.out.println("Count Internal Nodes: " + tree.countInternalNodes());
    System.out.println("Count Arcs: " + tree.countArcs());




    VectorBinaryTree vectorTree = new VectorBinaryTree<String>();
    Node nodes[] = new Node[strings.length];

    for (int i = 0; i < strings.length; ++i) {
      nodes[i] = vectorTree.insert(rand.nextInt(50) + i, strings[i]);
    }

    System.out.println("Count: " + nodes.length);
    System.out.println("Is Root: " + vectorTree.isRoot(nodes[0]));
    System.out.println("Is External: " + vectorTree.isExternal(nodes[0]));
    System.out.println("Is Internal: " + vectorTree.isInternal(nodes[0]));
    System.out.println("Left Child: " + vectorTree.leftChild(nodes[0]));
    System.out.println("Right Child: " + vectorTree.rightChild(nodes[0]));

  
    
  



  }
}