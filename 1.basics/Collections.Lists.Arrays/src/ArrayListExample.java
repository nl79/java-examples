import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {

  private static Scanner scanner = new Scanner(System.in);
  private static GroceryList list = new GroceryList();

  private ArrayList<String> groceryList = new ArrayList<String>();
  public static void main(String[] args) {
    boolean quit = false;
    int choice = 0;
    printInstructions();
    while(!quit) {
      System.out.println("Enter your choice: ");
      choice = scanner.nextInt();
      scanner.nextLine();
      switch(choice) {
        case 0:
          printInstructions();
          break;
        case 1:
          list.printGroceryList();
          break;
        case 2:
          addItem();
          break;
        case 3:
          modifyItem();
          break;
        case 4:
          removeItem();
          break;
        case 5:
          searchItem();
          break;
        case 6:
          quit = true;
          break;
      }
    }
  }

  public static void printInstructions() {
    System.out.println("\nPress ");
    System.out.println("\t 0 - To print choice optoins.");
    System.out.println("\t 1 - To print the list of grocery items.");
    System.out.println("\t 2 - To add an item to the list.");
    System.out.println("\t 3 - To modify an item in the list.");
    System.out.println("\t 4 - To remove an item from the list");
    System.out.println("\t 5 - To search for an item in the list.");
    System.out.println("\t 6 - To quit the application");
  }

  public static void addItem() {
    System.out.print("Please enter the grocery item: ");
    list.addGroceryItem(scanner.nextLine());
  }

  public static void modifyItem() {
    System.out.print("Enter item number: ");
    int item = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter replacement item: ");
    String newItem = scanner.nextLine();
    list.modifyGroceyItem(item-1, newItem);
  }

  public static void removeItem() {
    System.out.print("Enter item number: ");
    int item = scanner.nextInt();
    scanner.nextLine();
    list.removeGroceryItem(item-1);
  }

  public static void searchItem() {
    System.out.print("Item to search for: ");
    String item = scanner.nextLine();

    if(list.findItem(item) != null) {
      System.out.println("Found " + item + " in our grocery list" );
    } else {
      System.out.println(item + " is not in the shopping list");
    }
    
  }


}