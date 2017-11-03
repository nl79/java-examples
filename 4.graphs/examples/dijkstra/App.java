import java.util.Random;
import java.util.Scanner;

import java.util.List;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {


    Edge edge;
    Graph graph = new Graph();
    Dijkstra d;
    int startNode;
    int endNode;
    int weight;

    Scanner sc = new Scanner(System.in);

    int count = 0;
    String nodes = "";

    System.out.println("Enter a number of Nodes");
    count = sc.nextInt();

    //Create the nodes.
    for(int i = 1; i <= count; ++i) {
      graph.addNode(new Node(i));
      nodes = nodes + "( " + i + " ) |";
    }

    while(true) {
      //Create the edges.
      System.out.println("Nodes: " + nodes);

      System.out.print("Start Node (0 to exit): ");
      startNode = sc.nextInt();

      // Check if exiting.
      if(startNode == 0) { break; }
      System.out.print("End Node: (0 to exit): ");
      endNode = sc.nextInt();

      if(endNode == 0) { break; }

      System.out.print("Edge Weight: ");
      weight = sc.nextInt();

      edge = new Edge(1, graph.getNodeAt(startNode), graph.getNodeAt(endNode), weight);

    }
  }
}
