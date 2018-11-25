
public class Main {

  public static void main(String[] args) {
    Dog dog = new Dog("Yorkie");
    Parrot bird = new Parrot("Parrot");
    Penguin bird1 = new Penguin("Parrot");

    dog.breathe();
    dog.eat();

    bird.breathe();
    bird.eat();
    bird.fly();

    bird1.breathe();
    bird1.eat();
    bird1.fly();
  }
}