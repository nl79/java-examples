import java.util.ArrayList;
class Dijkstra {

  private Graph graph;
  private Node from;
  private Node to;

  private ArrayList<Integer> visited = new ArrayList();

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

  public Node execute() {
    return this.traverse();
  }

  private Node traverse() {

    this.from.setDistance(0);
    return this.traverse(this.from);
  }
  private Node traverse(Node n) {

    System.out.println("Visiting: " + n.getId());

    Edge edge = n.getClosestEdge();
    Node next = edge.to();
    int distance = 0;


    // Get the new total distance.
    distance = n.getDistance() + edge.distance();

    // Check if the current distance to the node is smaller than the new one.
    if(distance < next.getDistance()) {

      next.setDistance(distance);

      // Set the full path of the node.
    }

    // Set the node as visited.
    n.visit();

    // Base case.
    if(this.to.getId() == next.getId()) {


      return next;
      
    } else if(next.visited()) {
      System.out.println("visited");
      return next;

    } {

      System.out.println("here");
      return this.traverse(next);

    }

  }
}
