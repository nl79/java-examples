import java.util.ArrayList;

class Edge {

  private Node to;
  private int distance = 0;

  public Edge() { }

  public Edge(Node to, int d) {
    this.to = to;
    this.distance = d;
  }

  public Node to() {
    return this.to;
  }

  public int distance() {
    return this.distance;
  }
}

class Node {

  private int id;
  private int distance;
  private int hops;
  private boolean visited;
  private String name;

  // Edges leading out of the current node.
  ArrayList<Edge> edges = new ArrayList();

  /*
   * The path of nodes from source to destination
   * based on the current distance.
   */
  ArrayList<Node> nodes = new ArrayList();

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

  public int getDistance() {
    return this.distance;
  }

  public int setDistance(int value) {
    return this.distance = value;
  }

  public int getHops() { return this.hops; }

  public int setHops(int value) { return this.hops = value; }

  public int getId() {
    return this.id;
  }

  public Node visit() {
    this.visited = true;
    return this;
  }

  public boolean visited() {
    return this.visited;
  }

  public Node addEdge(Edge e) {
    // Validate if an edge to the node already exist

    this.edges.add(e);
    return this;
  }

  public Node getClosestNode() {

    return this.getClosestEdge().to();
  }


  public Edge getClosestUnvisitedEdge() {

    int distance = Integer.MAX_VALUE;
    Edge min = null;
    Edge curr = null;

    for (int i=0; i < this.edges.size(); i++) {
      curr = this.edges.get(i);

      //Check if visited.
      if(curr.to().visited()) {
        continue;
      }

      if(curr.distance() < distance) {

        distance = curr.distance();
        min = curr;

      }
    }

    return min;

  }


  public Edge getClosestEdge() {
    int distance = Integer.MAX_VALUE;
    Edge min = null;
    Edge curr = null;

    for (int i=0; i < this.edges.size(); i++) {
      curr = this.edges.get(i);

      if(curr.distance() < distance) {

        distance = curr.distance();
        min = curr;

      }
    }

    return min;
  }

  public boolean equals(Node node) {
    return false;
  }

  public void print() {
    Edge current;

    System.out.print(this.getId() + "[ ");
    for (int i=0; i < this.edges.size(); i++) {

      current = this.edges.get(i);

      System.out.print(current.to().getId() + "(" + current.distance()  + ")" + " ");
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

  public int size() {
    return this.nodes.size();
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
