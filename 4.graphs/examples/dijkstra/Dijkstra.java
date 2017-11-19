class Dijkstra {

  Graph graph;
  Node from;
  Node to;



  public Dijkstra(Graph g) {
    this.graph = g;
  }

  public Dijkstra from(Node n) {
    this.from = n;
    return this;
  }

  public Dijkstra to(Node n) {
    this.to = n;
    return this;
  }

  public void execute() {

  }

  private boolean traverse(Node n, int min) {
    return false;
  }
}
