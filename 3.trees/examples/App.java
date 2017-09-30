import java.util.Random;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    // Simulation parameters and defauls.
    String expression = "4 + (2 + 4 * 3 + (2/4)) - 9";
    Pipe pipe = new Pipe(expression);
    pipe.ignoreEmpty(true);
    //Expression expTree = new Expression(pipe);
    Expression expTree;

    try {
      expTree = Expression.Tree(pipe);
      System.out.println("value: " + expTree.value());
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }




    /*
    while(pipe.hasNext()){
      try {
        System.out.print(pipe.next() + " | ");

      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    */

    /*
    Scanner reader = new Scanner(System.in);
    System.out.print("Enter Expression: ");
    expression = reader.nextLine();

    System.out.println("CharAt(0): " + (int)expression.charAt(0));
    System.out.println("CharAt(0) == ' ': " + (expression.charAt(0) == ' '));
    */
  }
}
