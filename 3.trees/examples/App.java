import java.util.Random;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    // Default Expression String
    String expression = "4 + (2 + 4 * 3 + (2/4)) - 9";

    Scanner reader = new Scanner(System.in);
    System.out.print("Enter an Expression: ");
    expression = reader.nextLine();

    Pipe pipe = new Pipe(expression);
    pipe.ignoreEmpty(true);

    Expression expTree;

    try {
      expTree = Expression.Parse(pipe);

      System.out.println("value: " + expTree.value());

      //BFS
      for(int i =0; i < expression.length(); ++i) {
        expTree.draw(i, 0, ' ');
        System.out.println("");
      }

    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
