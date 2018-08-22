import java.util.Scanner;

public class Hello {
  public static void main(String[] args) {
    System.out.println("Hello World!");

    // int has a width of 32
    int myFirstNumber = 5;
    int myMinvalue = -2_147_483_648;
    int myMaxValue = 2_147_483_647;
    int myTotal = (myMinvalue/2);

    // byte has a width of 8
    byte myByteValue = -128;

    // short has a width of 16
    short myShortValue = 32767;

    // long has a width of 64
    long myLongValue = 100L;
    long myLongValue2 = -9_223_372_036_854_775_808L;
    long myLongValue3 = 9_223_372_036_854_775_807L;

    System.out.println(myLongValue3);

    // width of float = 32 ( 4 bytes)
    float myFloatValue = 5f;

    // width of double = 64 (8 bytes)
    double myDoubleValue = 5d;
    System.out.println("myIntValue = " + myFirstNumber);
    System.out.println("myFloatvalue = " + myFloatValue);
    System.out.println("myDoubleValue = " + myDoubleValue);

    // width of 16 ( 2 bytes)
    char myChar = 'a';
    char myUnicodeChar = '\u00A9';

    System.out.println("myUnicodeChar = " + myUnicodeChar);

    boolean myBooleanFalse = false;
    boolean myBooleanTrue = true;

    String myString = "This is a string";

    System.out.println("myStaring = " + myString);

    boolean isAlien = false;
    if (isAlien == true) {
      System.out.println("It is not an alien!");
    }

    int topScore = 80;
    if(topScore < 100)
      System.out.println("You got the high score!");

    int secondTopScore = 81;
    if((topScore > secondTopScore) && (topScore < 100))
      System.out.println("Greater than second top score and less then first!");

    if((topScore > 90) || (secondTopScore <= 90))
      System.out.println("One of these tests is true");

    int newValue = 50;
    if(newValue == 50)
      System.out.println("This is true");

    boolean isCar = false;
    if(isCar == true)
      System.out.println("This is not supposed to happen");

    boolean wasCar = isCar ? true : false;

    if (wasCar)
      System.out.println("wasCAr is true");


    boolean gameOver = true;
    int score = 800;
    int levelCompleted = 5;
    int bonus = 100;

    int hightScore = calculateScore(gameOver, score, levelCompleted, bonus);
    System.out.println("Your final score was " + hightScore);


    switching();
    forLooping();
    DoWhileLooping();
    TypeConversion();
    userInput();
  }

  public static void displayHightScorePosition(String playerName, int hightScorePosition) {
    System.out.println(playerName + " manage to get into position "
    + hightScorePosition + " on the high score table");
  }

  public static int calculateHightScorePosition(int playerScore){
    if (playerScore > 1000) {
      return 1;
    } else if (playerScore > 500 && playerScore < 1000) {
      return 2;
    } else if(playerScore > 100 && playerScore < 500) {
      return 3;
    } else {
      return 4;
    }
  }

  public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
    if(gameOver) {
      int finalScore = score + (levelCompleted * bonus);
      finalScore += 1000;

      return finalScore;
    }
    return -1;
  }

  public static void switching() {
    int switchValue = 3;

    switch(switchValue) {
      case 1:
        System.out.println("Value 1");
        break;
      case 2:
        System.out.println("value 2");
        break;
      case 3:
        System.out.println("value 3");
        break;
      default:
        System.out.println("was default");
        break;
    }

    // Java 7 only (String switch)
    String month = "january";
    switch(month.toLowerCase()) {
      case "january":
        System.out.println("Jan");
        break;
      case "february":
        System.out.println("Feb");
        break;
      default:
        System.out.println("Default");
        break;
    }
  }

  public static void forLooping() {
    for(int i = 0; i < 5; ++i) {
      System.out.println("# " + i);
    }

  }

  public static void DoWhileLooping() {
    int count = 1;
    do {
      System.out.println("Count value was " + count);
      count++;
    } while(count != 6);
  }

  public static void TypeConversion() {
    String numberAsString = "2018";
    int number = Integer.parseInt(numberAsString);
    double doubleNumber = Double.parseDouble(numberAsString);

    System.out.println((numberAsString += 1));
    System.out.println((number += 1));
    System.out.println((doubleNumber += 1));
  }

  public static void userInput() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter your year of birth:");
    int yearOfBirth = scanner.nextInt();
    scanner.nextLine(); //handle next line charater(enter key)

    System.out.println("Enter your name: ");
    String name = scanner.nextLine();
    int age = 2018 - yearOfBirth;

    System.out.println("Your name is: " + name + ", and you are " + age + " years old.");
    scanner.close();
  }
}
