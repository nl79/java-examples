import java.util.Random;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    // Simulation parameters and defauls.
    String expression;

    Scanner reader = new Scanner(System.in);
    System.out.print("Enter Expression: ");
    expression = reader.nextLine();

    System.out.print("CharAt(0): " + (int)expression.charAt(0));
    System.out.print("CharAt(0) == ' ': " + (expression.charAt(0) == ' '));
  }
}
