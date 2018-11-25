import java.util.List;
import java.util.ArrayList;

public class Player implements ISavable {

  private String name;
  private int hitPoints;
  private int strength;
  private String weapon;

  public Player(String name, int hitPoints, int strength) {
    this.name = name;
    this.hitPoints = hitPoints;
    this.strength = strength;
    this.weapon = "Sword";
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getHitPoints() {
    return this.hitPoints;
  }

  public void setHitPoints(int points) {
    this.hitPoints = points;
  }

  public int getStrength() {
    return this.strength;
  }

  public void setStrength(int value) {
    this.strength = value;
  }

  public String getWeapon() {
    return this.weapon;
  }

  public void setWeapon(String value) {
    this.weapon = value;
  }

  @Override
  public String toString() {
    return "Player";
  }

  @Override
  public List<String> write() {
    List<String> values = new ArrayList<String>();
    values.add(0, this.name);
    values.add(1, "" + this.hitPoints);
    values.add(2, "" + this.strength);
    values.add(3, this.weapon);

    return values;
  }

  @Override
  public void read(List<String> savedValues) {
    if(savedValues != null && savedValues.size() > 0) {
      this.name = savedValues.get(0);
      this.hitPoints = Integer.parseInt(savedValues.get(1));
      this.strength = Integer.parseInt(savedValues.get(2));
      this.weapon = savedValues.get(3);
    }
  }
}