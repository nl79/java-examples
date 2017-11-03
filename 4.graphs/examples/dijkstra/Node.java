import java.util.List;

class Node {

  private int id;
  private int distance;
  private int hops;
  private boolean visited;
  private String name;

  List<Edge> edges;

  public Node() {}
    
  public Node(int id) {
    this.id = id;
    this.init();
  }

  public Node(int id, String name) {
    this.id = id;
    this.name = name;
    this.init();
  }

  private void init() {
    this.distance = Integer.MAX_VALUE;
    this.visited = false;
    this.hops = Integer.MAX_VALUE;
  }

  public Node addEdge(Edge e) {

    this.edges.add(e);
    return this;

  }

  public Node getClosestSibling() {
    return new Node();
  }

  public boolean equals(Node node) {
    return false;
  }
}
