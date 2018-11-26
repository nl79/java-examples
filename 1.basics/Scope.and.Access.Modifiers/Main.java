
public class Main {

  public static int multiplier = 7;

  public static void main(String[] args) {
    StaticTest firstInstance = new StaticTest("1St instance");
    System.out.println(firstInstance.getName() + " is instance number " + StaticTest.getNumInstances());

    StaticTest secondInstance = new StaticTest("Second instance");
    System.out.println(secondInstance.getName() + " is in stance number " + StaticTest.getNumInstances());

    int answer = multiply(6);
    System.out.println("Answer: " + answer);

    SomeClass one = new SomeClass("one");
    SomeClass two = new SomeClass("two");
    SomeClass three = new SomeClass("three");

    System.out.println(one.getInstanceNumber());
    System.out.println(two.getInstanceNumber());
    System.out.println(three.getInstanceNumber());

    int pw = 23423432;
    Password password = new Password(pw);
    password.storePassword();

    System.out.println("Main method called");
    SIBTest test = new SIBTest();
    test.someMethod();
    System.out.println("Owner is " + SIBTest.owner);

  }

  public static int multiply(int number) {
    return number * multiplier;
  }
}