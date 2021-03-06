import java.util.Random;

public class AirportTerminal {

  private int duration = 120;
  private double avgCoachArrivalRate = 2;
  private double avgCoachServiceRate = 2;
  private double avgFirstClassArrivalRate = 5;
  private double avgFirstClassServiceRate = 6;

  private Random rand;

  public AirportTerminal() {
    this.init();
  }

  public AirportTerminal(int duration, double acar, double acsr, double afcar, double afcsr) {
   this.duration = duration;
   this.avgCoachArrivalRate = acar;
   this.avgCoachServiceRate = acsr;
   this.avgFirstClassArrivalRate = afcar;
   this.avgFirstClassServiceRate = afcsr;

   this.init();
  }

  private void init() {
    this.rand = new Random();
  }

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

    // The count of free first class service stations.
    int emptyFirstClassStations = 0;

    // Coach
    ServiceStation coachStations[] = {
      new ServiceStation(2, this.avgCoachServiceRate),
      new ServiceStation(2, this.avgCoachServiceRate),
      new ServiceStation(2, this.avgCoachServiceRate)
    };

    // The count of free coach service stations.
    int emptyCoachStations = 0;

    ServiceStation currentStation;


    /*
     * Record the maximum wait time in each queue
     * that a 'customer' had to wait.
     */
    long firstClassMaxWait = 0;
    long coachMaxWait = 0;
    long firstClassTotalWait = 0;
    long coachTotalWait = 0;

    long queueItem;
    long currentWaitTime;
    long diff;

    // Count of the last time a customer arrived.
    // Increased with every iteration of the main loop.
    int lastFirstClassArrivalTime = 1;
    int lastCoachArrivalTime = 1;

    // Flag that determines if the simulation is to keep running.
    boolean run = true;

    for(int i = 0; i < this.duration || run == true; ++i , ++lastFirstClassArrivalTime, ++lastCoachArrivalTime) {

      /*
       * NOTE: Each 'Customer' inserted into the queue is identified by the
       * value of the current 'i', which also serves as a timestamp of when the
       * customer entered the queue.
       * This value is used to calculate the average and maximum waiting times in the queue.
       */

      // Check if check-in is over
      if(i < this.duration) {

        // Check if first Class customers arrived.
        if(this.isEvent(this.avgFirstClassArrivalRate, lastFirstClassArrivalTime)) {
          firstClassQueue.insert(i);
          lastFirstClassArrivalTime = 0;
        }

        // Check if coach customer arrived.
        if(this.isEvent(this.avgCoachArrivalRate, lastCoachArrivalTime)) {
          coachQueue.insert(i);
          lastCoachArrivalTime = 0;
        }

      } else {
        // Set the run flag to false to signal possible end of processing.
        run = false;
      }


      // Set customer to service stations if empty.
      // If not empty, check how long a user has been in the station and calculate the probability of finishing this turn.

      // Coach Stations
      // Reset empty coach station count
      emptyCoachStations = 0;
      for(int k = 0; k<coachStations.length; ++k) {

        currentStation = coachStations[k];
        // If the station is empty, and the coach que is not empty, pull in a client.
        if(!currentStation.isBusy()) {

          if(!coachQueue.isEmpty()) {
            // The queue item represents the insert time.
            queueItem = coachQueue.remove();

            diff = (i - queueItem);

            // Get the difference between 'now' and add to the max.
            coachMaxWait = diff > coachMaxWait ? diff : coachMaxWait;
            coachTotalWait += diff;
            currentStation.service(queueItem);
          } else {
            // Queue is empty and stations is free.
            // Increment empty coach stations count.
            emptyCoachStations++;
          }

        } else {
          // Check if the client has been served.
          currentStation.tick();
        }

      }

      // First Class Stations
      // Reset empty First Class stations count
      emptyFirstClassStations = 0;
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
            // The queue item represents the insert time.
            queueItem = firstClassQueue.remove();

            diff = (i - queueItem);
            // Get the difference between 'now' and add to the max.
            firstClassMaxWait = diff > firstClassMaxWait ? diff : firstClassMaxWait;
            firstClassTotalWait += diff;
            currentStation.service(queueItem);

          } else if(!coachQueue.isEmpty()) {
            // The queue item represents the insert time.
            queueItem = coachQueue.remove();

            diff = (i - queueItem);

            // Get the difference between 'now' and add to the max.
            coachMaxWait = diff > coachMaxWait ? diff : coachMaxWait;
            coachTotalWait += diff;

            currentStation.service(queueItem);


          } else {
            // Increment empty stations count.
            emptyFirstClassStations++;
          }
        } else {
          // Check if the client has been served.
         currentStation.tick();
        }
      }

      // Check if Queues and stations are empty.
      if( run == false &&
          coachQueue.isEmpty() == true &&
          firstClassQueue.isEmpty() == true &&
          emptyFirstClassStations == firstClassStations.length &&
          emptyCoachStations == coachStations.length ) {
            System.out.println("Exiting Simulation");
            break;
          } else {
            run = true;
          }
    }

    System.out.println("Duration: " + this.duration);
    System.out.println("First Class Queue Max: " + firstClassQueue.getMax());
    System.out.println("Coach Queue Max: " + coachQueue.getMax());

    // The average and maximum waiting time for each queue.
    System.out.println("Coach Queue Max Waiting time: " + coachMaxWait);
    System.out.println("Coach Queue Average Waiting time: " + (double)coachTotalWait/(double)coachQueue.getMax());


    System.out.println("First Class Queue Max Waiting time: " + firstClassMaxWait);
    System.out.println("First Class Queue Average Waiting time: " + (double)firstClassTotalWait/(double)coachQueue.getMax());

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

  private boolean isEvent(double avg, int last) {
    return (1/avg) >= this.rand.nextDouble();
  }
}
