import java.util.Random;

public class AirportTerminal {

  public static void main(String[] args) {

    int checkInDuration = 120;
    double coachAvgArrival = 25;
    double firstAvgArrival = 25;

    // Extract the checkInDuration or set defaults.
    if(args.length >= 1) {
      try {
        checkInDuration = Integer.parseInt(args[0]);
      } catch(NumberFormatException e) {
        checkInDuration = 50;
      }
    }
    
    if(args.length >= 2) {
      try {
        coachAvgArrival = Double.parseDouble(args[1]);
      } catch(NumberFormatException e) {
        coachAvgArrival = 25;
      }
    }

    if(args.length == 3) {
      try {
        firstAvgArrival = Double.parseDouble(args[2]);
      } catch(NumberFormatException e) {
        firstAvgArrival = 25;
      }
    }

    Queue first = new Queue(50);
    Queue coach = new Queue(50);

    boolean run = true;

    Queue firstClassStation1;
    Queue firstClassStation2;
    Queue coachStation1;
    Queue coachStation2;
    Queue coachStation3;

    // The probability of a passenger arrival per-minute based on class.
    int firstAvg = 6;
    int coachAvg = 2;

    int lastFirstClass = 1;
    int lastCoach = 1;
    
    

    for(int i = checkInDuration; i > 0; --i, ++lastFirstClass, ++lastCoach) {

      // Check if first Class customers arrived.
      if(AirportTerminal.hasCustomerArrived(firstAvg,lastFirstClass )) {
        //If added first class reset lastFirstClass
        System.out.println("First Class Customer Arrived");
        first.insert(i);
        lastFirstClass = 0;
      }

      // Check if coach customer arrived.
      if(AirportTerminal.hasCustomerArrived(coachAvg,lastCoach )) {
        //If added first class reset lastFirstClass
        System.out.println("Coach Customer Arrived");
        coach.insert(i);
        lastCoach = 0;
      }
      



    }


    // 2 Services stations for first class.
    // 3 Service station for coach class.
    /*
     * Each service station takes passengers from the corresponding queue; but if a first class service station
     * is free and the queue for coach is not empty then the service station serves passengers from the coach
     * queue.
     * /
     * 
     * Passenger arrival times are random, but subject to average arrival times; for example, we get a first
      class passenger every five minutes and a coach passenger every two minutes on average. Actual
      arrival times are random.
     */
  }

  public static boolean hasCustomerArrived(int avg, int last) {
    /*
    System.out.println("avg: " + avg);
    System.out.println("last: " + last);
    System.out.println("last/avg: " + (double)last/(double)avg);
    */
    
    Random random = new Random(); 
    double probability = random.nextInt(avg+1) * ((double)last/(double)avg);
    //System.out.println("probability: " + probability);
    return probability > 0.9;
  }

}