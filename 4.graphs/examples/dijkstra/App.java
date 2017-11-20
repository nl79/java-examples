import java.util.Random;
import java.util.Scanner;

import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class App {

  public static void main(String[] args) {

    Graph graph = new Graph();
    Dijkstra d;
    int startNode;
    int endNode;
    int weight;

    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    int count = 6;
    String nodes = "";
    /*
    System.out.println("Enter a number of Nodes");
    count = sc.nextInt();
    */
    //Create the nodes.
    for(int i = 1; i <= count; ++i) {
      graph.addNode(i);
      nodes = nodes + "( " + i + " ) |";
    }

    // 1 to 2 - w 2
    graph.addEdge(0, 1, 2);
    // 1 to 3 - w 1
    graph.addEdge(0, 2, 1);
    // 1 to 4 - w 5
    graph.addEdge(0, 3, 5);


    // 2 to 3 - w 3
    graph.addEdge(1, 2, 2);
    // 2 to
    graph.addEdge(1, 3, 3);

    // 3 to 4 - w 3
    graph.addEdge(2, 3, 3);
    // 3 to 5 - w 1
    graph.addEdge(2, 4, 1);

    // 4 to 5 - w 1
    graph.addEdge(3, 4, 1);
    // 4 to 6 - w 5
    graph.addEdge(3, 5, 5);

    // 5 to 6 - w 1
    graph.addEdge(4, 5, 2);



    /*
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

      graph.addEdge(startNode-1, endNode-1, weight);

    }

    */

    System.out.println("\nCurrent Graph Configuration");
    graph.print();

    System.out.println("\nExecuting Dijkstra");
    d = new Dijkstra(graph);
    Node n = d.from(graph.getNodeAt(0)).to(graph.getNodeAt(5)).execute();

    System.out.println("\nFound Node: " + n.getId() + " | Cost: " + n.getDistance());

  }
}
