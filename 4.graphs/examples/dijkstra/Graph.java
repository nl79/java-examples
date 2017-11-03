import java.util.ArrayList;

class Graph {

  ArrayList<Node> nodes = new ArrayList();
  ArrayList<Edge> edges;

  public Graph() {

  }

  public Graph addNode(Node n) {
    this.nodes.add(n);
    return this;
  }

  public Node getNodeAt(int i) {
    //Validate the size before trying to retrieve.

    return this.nodes.get(i);
  }
}
