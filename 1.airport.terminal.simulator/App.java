import java.util.Random;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    // Simulation parameters and defauls.
    int duration = 120;
    double avgCoachArrivalRate = 2;
    double avgCoachServiceRate = 2;
    double avgFirstClassArrivalRate = 5;
    double avgFirstClassServiceRate = 6;

    Scanner reader = new Scanner(System.in);
    System.out.println("Simulation Duration(Minutes): ");
    duration = reader.nextInt();

    System.out.println("Average Coach Arrival Rate(Minutes): ");
    avgCoachArrivalRate = reader.nextDouble();

    System.out.println("Average Coach Service Time(Minutes): ");
    avgCoachServiceRate = reader.nextDouble();

    System.out.println("Average First Class Arrival Rate(Minutes): ");
    avgFirstClassArrivalRate = reader.nextDouble();

    System.out.println("Average First Class Service Time(Minutes): ");
    avgFirstClassServiceRate = reader.nextDouble();

    AirportTerminal simulation = new AirportTerminal();

    simulation.run();

  }
}
