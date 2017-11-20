import java.util.ArrayList;
class Dijkstra {

  private Graph graph;
  private Node from;
  private Node to;
  boolean done = false;

  private ArrayList<Integer> visited;

  public Dijkstra(Graph g) {
    this.graph = g;

    // Array of visited nodes and their total costs.
    this.visited = new ArrayList();

    // Initialize the visisted array
    for(int i = 0; i <= this.graph.size(); ++i) {
      this.visited.add(i, Integer.MAX_VALUE);
    }

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
    this.from.setHops(0);

    return this.traverse(this.from);
  }
  private Node traverse(Node n) {
    // Set the node as visited.
    n.visit();

    Edge edge = null;

    Node next = null;

    int distance = 0;
    int hops = 0;

    while((edge = n.getClosestUnvisitedEdge()) != null && this.done != true) {

      next = edge.to();




      // Get the new total distance.
      distance = n.getDistance() + edge.distance();

      // Get the hop count to previous node and add one.
      hops = (n.getHops() + 1);

      System.out.println("Current Node: " + n.getId() +
              " Next Node: " + next.getId() +
              " | Distance: " + distance);

      // Check if the current distance to the node is smaller than the new one.
      if (distance < next.getDistance()) {

        next.setDistance(distance);

        this.visited.set(next.getId(), distance);

        // Set the full path of the node.
      }

      if( hops < next.getHops()) {
        next.setHops(hops);
      }


      // Base case.
      if (this.to.getId() == next.getId()) {

        //this.done = true;
        return next;

      } else {
        next = this.traverse(next);

      }

    }

    return next;

  }
}
