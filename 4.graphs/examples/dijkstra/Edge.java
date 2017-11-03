class Edge {

  private int id;
  private Node[] nodes;
  private int weight;

  public Edge() {

  }

  public Edge(int id, Node from, Node to, int weight) {
    this.id = id;
    this.nodes = new Node[] {from, to};
    this.weight = weight;
  }

  public int getId() {
    return this.id;
  }

  public int weight() {
    return this.weight;
  }
}
