import java.util.ArrayList;

public class Gearbox {
  private ArrayList<Gear> gears;
  private int maxGears;
  private int currentGear = 0;
  private boolean clutchIsIn = false;

  public Gearbox(int maxGears) {
    this.maxGears = maxGears;
    this.gears = new ArrayList<>();
    Gear neutral = new Gear(0, 0.0);
    this.gears.add(neutral);

    this.addGear(1, 5.2);
    this.addGear(2, 10.7);
    this.addGear(3, 15.9);
  }

  public void operateClutch(boolean in) {
    this.clutchIsIn = in;
  }

  public void addGear(int number, double ratio) {
    if((number > 0) && (number <= maxGears)) {
      this.gears.add(new Gear(number, ratio));
    }
  }

  public void changeGear(int newGear) {
    if((newGear >= 0) && (newGear < this.gears.size()) && this.clutchIsIn) {
      this.currentGear = newGear;
      System.out.println("Gear " + newGear + " selected.");
    } else {
      System.out.println("Grind!");
      this.currentGear = 0;
    }
  }

  public double wheelSpeed(int revs) {
    if(clutchIsIn) {
      System.out.println("Scream!!");
      return 0.0;
    }

    return revs * gears.get(this.currentGear).getRatio();
  }

  private class Gear {
    private int gearNumber;
    private double ratio;

    public Gear(int gearNumber, double ratio) {
      // 'this', in this case is refering to the 'Gear' class and not the Gearbox class that its nested in.

      this.gearNumber = gearNumber;
      this.ratio = ratio;
    }
    public double getRatio() {
      return this.ratio;
    }
    public double driveSpeed(int revs) {
      return revs * (this.ratio);
    }
  }

}