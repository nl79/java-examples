
public  abstract class Bird extends Animal implements ICanFly {
  public Bird (String name) {
    super(name);
  }

  @Override
  public void eat() {
    System.out.println(getName() + " Eating a worm");
  }

  @Override
  public void breathe() {
    System.out.println("Bird is Breathring.");
  }

  @Override
  public void fly() {
    System.out.println(getName() + " is flapping its wings");
  }
}