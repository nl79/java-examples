import java.util.Random;

public class ServiceStation {
  // Type of service station.
  private int type;
  private double avgServiceTime;

  private long serviceTime = 0;

  private long customer;

  private long totalCustomers = 0;
  private long totalTime = 0;


  private Random rand; 

  public ServiceStation(int type, double avg) {
    this.type = type;
    this.avgServiceTime = avg;

    this.rand = new Random();
  }

  public int getType() {
    return this.type;
  }
  public void setAvgServiceTime(double i) {
    this.avgServiceTime = i;
  }
  
  public double getOccupancyRate(long duration) {
    if(duration == 0) { return 0; }
    return (double)this.totalTime / (double)duration;
  }

  public void service(long c) {
    this.customer = c;
  }
  public boolean isBusy() {
    return !(this.customer == 0);
  }

  public boolean tick() {
    return this.tick(1);
  }
  public boolean tick(long elapsed) {
    this.serviceTime+=elapsed;

    // Check if the customer has been serviced.
    return this.isDone();
  }

  public boolean isDone() {
    // If no customer exists, return true;
    if(this.customer == 0) { return true; }

    //double probability = this.rand.nextInt(this.avgServiceTime+1) * ((double)this.serviceTime/(double)this.avgServiceTime);
    boolean event = (1/this.avgServiceTime) >= this.rand.nextDouble();
    //System.out.println("probability: " + probability);
    if(event) {
      // Record the time it took.
      this.totalTime+=this.serviceTime;

      // Increment the serviced customer count.
      this.totalCustomers++;

      // Reset the customer and service time.
      this.customer = 0;
      this.serviceTime = 0;

      return true;
    }
    return false;
  }

}