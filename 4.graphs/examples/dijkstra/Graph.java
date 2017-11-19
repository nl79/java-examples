import java.util.ArrayList;

class Edge {

  private Node to;
  private int weight = 0;

  public Edge() { }

  public Edge(Node to, int weight) {
    this.to = to;
    this.weight = weight;
  }

  public Node to() {
    return this.to;
  }

  public int weight() {
    return this.weight;
  }
}

class Node {

  private int id;
  private int distance;
  private int hops;
  private boolean visited;
  private String name;

  ArrayList<Edge> edges = new ArrayList();

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

  public int getId() {
    return this.id;
  }

  public Node addEdge(Edge e) {
    // Validate if an edge to the node already exist

    this.edges.add(e);
    return this;
  }

  public Node getClosestSibling() {
    return new Node();
  }

  public boolean equals(Node node) {
    return false;
  }

  public void print() {
    Edge current;

    System.out.print(this.getId() + "[ ");
    for (int i=0; i < this.edges.size(); i++) {

      current = this.edges.get(i);

      System.out.print(current.to().getId() + "(" + current.weight()  + ")" + " ");
    }

    System.out.print("]");
  }
}

class Graph {

  ArrayList<Node> nodes = new ArrayList();

  public Graph() {}

  public Graph addNode(int key) {
    this.nodes.add(new Node(key));
    return this;
  }

  public Graph addNode(int key, String value) {
    this.nodes.add(new Node(key, value));
    return this;
  }

  public Graph addEdge(int f, int t, int weight) {
    Node from = this.getNodeAt(f);
    Node to = this.getNodeAt(t);

    from.addEdge(new Edge(to, weight));
    to.addEdge(new Edge(from, weight));

    return this;
  }

  public Node getNodeAt(int i) {
    //Validate the size before trying to retrieve.
    return this.nodes.get(i);
  }

  public void print() {
    Node current;

    for (int i=0; i < this.nodes.size(); i++) {
      current = this.nodes.get(i);
      current.print();
      System.out.println();
    }
  }
}
