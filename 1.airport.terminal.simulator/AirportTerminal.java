import java.util.Random;

public class AirportTerminal {

  private int duration = 120;
  private int avgCoachArrivalRate = 2;
  private int avgCoachServiceRate = 2;
  private int avgFirstClassArrivalRate = 5;
  private int avgFirstClassServiceRate = 6;

  public AirportTerminal() {  }

  public void setDuration(int i) {
    this.duration = i;
  }
  public void setAvgCoachArrivalRate(int i) {
    this.avgCoachArrivalRate = i;
  }
  public void setAvgCoachServiceRate(int i) {
    this.avgCoachServiceRate = i;
  }
  public void setAvgFirstClassArrivalRate(int i) {
    this.avgFirstClassArrivalRate = i;
  }
  public void setAvgFirstClassServiceRate(int i) {
    this.avgFirstClassServiceRate = i;
  }

  public void run() {

  
    Queue firstClassQueue = new Queue(50);
    Queue coachQueue = new Queue(50);

    // Service Stations.
    // first class
    ServiceStation firstClassStations[] = {
      new ServiceStation(1, this.avgFirstClassServiceRate),
      new ServiceStation(1, this.avgFirstClassServiceRate)
    };
    // Coach
    ServiceStation coachStations[] = {
      new ServiceStation(2, this.avgCoachServiceRate),
      new ServiceStation(2, this.avgCoachServiceRate),
      new ServiceStation(2, this.avgCoachServiceRate)
    };

    ServiceStation currentStation;

    // Count of the last time a customer arrived.
    // Increased with every iteration of the main loop.
    int lastFirstClassArrivalTime = 1;
    int lastCoachArrivalTime = 1;

    for(int i = 0; i < this.duration; ++i, ++lastFirstClassArrivalTime, ++lastCoachArrivalTime) {

      // Check if first Class customers arrived.
      if(this.isEvent(this.avgFirstClassArrivalRate, lastFirstClassArrivalTime)) {
        //If added first class reset lastFirstClass
        System.out.println("First Class Customer Arrived");
        firstClassQueue.insert(i);
        lastFirstClassArrivalTime = 0;
      }

      // Check if coach customer arrived.
      if(this.isEvent(this.avgCoachArrivalRate, lastCoachArrivalTime)) {
        //If added first class reset lastFirstClass
        System.out.println("Coach Customer Arrived");
        coachQueue.insert(i);
        lastCoachArrivalTime = 0;
      }


      // Set customer to service stations if empty. 
      // If not empty, check how long a user has been in the station and calculate the probability of finishing this turn.

      // Coach Stations
      for(int k = 0; k<coachStations.length; ++k) {

        currentStation = coachStations[k];
        // If the station is empty, and the coach que is not empty, pull in a client.
        if(!currentStation.isBusy()) {
          
          if(!coachQueue.isEmpty()) {
            currentStation.service(coachQueue.remove());
          } 
        } else {
          // Check if the client has been served. 
          currentStation.tick();
          System.out.println("Coach Station - Done: " + currentStation.isDone());

        }
        
      }

      // First Class Stations
      for(int j = 0; j<firstClassStations.length; ++j) {
        /*
          * Each service station takes passengers from the corresponding queue; but if a first class service station
          * is free and the queue for coach is not empty then the service station serves passengers from the coach
          * queue.
         */
        currentStation = firstClassStations[j];

         // If the station is empty, and the coach que is not empty, pull in a client.
        if(!currentStation.isBusy()) {
          
          if(!firstClassQueue.isEmpty()) {
            currentStation.service(firstClassQueue.remove());

          } else if(!coachQueue.isEmpty()) {
            // If there are no first class customer to service, pull a customer from the coach que.
            currentStation.service(coachQueue.remove());
          }

        } else {
          // Check if the client has been served. 
         currentStation.tick();
         System.out.println("First Class Station - Done: " + currentStation.isDone());

        }       
      }
    }

    System.out.println("Duration: " + this.duration);
    System.out.println("First Class Queue Max: " + firstClassQueue.getMax());
    System.out.println("Coach Queue Max: " + coachQueue.getMax());

    // The average and maximum waiting time for each queue.
    
    // Rate of occupancy of coach stations
    for(int k = 0; k<coachStations.length; ++k) {

      currentStation = coachStations[k];
      System.out.println("Coach - Service Station #" + k + " occupancy rate: %" + (currentStation.getOccupancyRate(this.duration) * 100));

    }
    // Rate of occupancy of first class stations
    for(int k = 0; k<firstClassStations.length; ++k) {

      currentStation = coachStations[k];
      System.out.println("First Class - Service Station #" + k + " occupancy rate: %" + (currentStation.getOccupancyRate(this.duration) * 100));

    }
  }

  private boolean isEvent(int avg, int last) {
    Random random = new Random(); 
    double probability = random.nextInt(avg+1) * ((double)last/(double)avg);
    //System.out.println("probability: " + probability);
    return probability > 0.9;
  }

}