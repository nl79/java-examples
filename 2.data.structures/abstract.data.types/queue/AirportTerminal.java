import java.util.Random;

public class AirportTerminal {

  public static void main(String[] args) {

    int checkInDuration = 120;
  
    Queue first = new Queue(50);
    Queue coach = new Queue(50);

    boolean run = true;

    // Service Station average delays.
    int firstStationAvg = 6;
    int coachStationAvg = 2;

    // Service Station minute counters.
    int firstClassStations[] = {0,0};
    int coachStations[] = {0,0,0};

    // The probability of a passenger arrival per-minute based on class.
    int firstAvg = 5;
    int coachAvg = 2;

    int lastFirstClass = 1;
    int lastCoach = 1;
    
    

    for(int i = checkInDuration; i > 0; --i, ++lastFirstClass, ++lastCoach) {

      // Check if first Class customers arrived.
      if(AirportTerminal.isEvent(firstAvg,lastFirstClass )) {
        //If added first class reset lastFirstClass
        System.out.println("First Class Customer Arrived");
        first.insert(i);
        lastFirstClass = 0;
      }

      // Check if coach customer arrived.
      if(AirportTerminal.isEvent(coachAvg,lastCoach )) {
        //If added first class reset lastFirstClass
        System.out.println("Coach Customer Arrived");
        coach.insert(i);
        lastCoach = 0;
      }


      // Set customer to service stations if empty. 
      // If not empty, check how long a user has been in the station and calculate the probability of finishing this turn.

      // Coach Stations
      for(int k = 0; k<coachStations.length; ++k) {
        System.out.println("coachStations[k]" + coachStations[k]);
        // If the station is empty, and the coach que is not empty, pull in a client.
        if(coachStations[k] == 0) {
          
          if(!coach.isEmpty()) {
            coach.remove();
            coachStations[k] = 1;
          } 
        } else {
          // Check if the client has been served. 
          boolean done = AirportTerminal.isEvent(coachStationAvg,coachStations[k]);
          System.out.println("coachStations[k] - done?" + done);
          coachStations[k] =  done ? 0 : ++coachStations[k];
        }
        
      }

      // First Class Stations
      for(int j = 0; j<firstClassStations.length; ++j) {
        /*
          * Each service station takes passengers from the corresponding queue; but if a first class service station
          * is free and the queue for coach is not empty then the service station serves passengers from the coach
          * queue.
         */
        System.out.println("firstClassStations[j]" + firstClassStations[j]);
        // If the station is empty, and the coach que is not empty, pull in a client.
        if(firstClassStations[j] == 0) {
          
          if(!first.isEmpty()) {
            first.remove();
            firstClassStations[j] = 1;

          } else if(!coach.isEmpty()) {
            // If there are no first class customer to service, pull a customer from the coach que.
            coach.remove();
            firstClassStations[j] = 1;
          }

        } else {
          // Check if the client has been served. 
          boolean done = AirportTerminal.isEvent(firstStationAvg,firstClassStations[j]);
          System.out.println("firstClassStations[j] - done?" + done);
          firstClassStations[j] =  done ? 0 : ++firstClassStations[j];
        }
      }
    }

    System.out.println("Duration of the Simulation: " + checkInDuration);
    System.out.println("Maximum First Class Queue: " + first.getMax());
    System.out.println("Maximum Coach Queue: " + coach.getMax());
    System.out.println("Maximum First Class Queue Waiting Time: " + first.getMax());
    System.out.println("Maximum Coach Queue Waiting Time: " + first.getMax());
    System.out.println("Maximum First Class Queue Waiting Time: " + first.getMax());



  }

  public static boolean isEvent(int avg, int last) {
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