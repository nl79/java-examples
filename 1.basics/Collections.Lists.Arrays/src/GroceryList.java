import java.util.ArrayList;

public class GroceryList {
  private ArrayList<String> groceryList = new ArrayList<String>();

  public void addGroceryItem(String item) {
    this.groceryList.add(item);
  }

  public void printGroceryList() {
    System.out.println("You have " + this.groceryList.size() + " Items in the list");
    for(int i = 0; i < groceryList.size(); ++i) {
      System.out.println((i + 1) + ". " + groceryList.get(i));
    }
  }

  public void modifyGroceyItem(int position, String newItem) {
    this.groceryList.set(position, newItem);
    System.out.println("Grocery Item " + (position+1) + " has been modified");
  }

  public void removeGroceryItem(int position) {
    String item = this.groceryList.get(position);
    groceryList.remove(position);
  }

  public String findItem(String query) {
    //boolean exists = groceryList.contains(query);
    int position = this.groceryList.indexOf(query);

    if(position >= 0) {
      return this.groceryList.get(position);
    }

    return null;
  }
}