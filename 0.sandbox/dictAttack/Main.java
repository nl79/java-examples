import java.util.ArrayList;

public class Main {
  public static void main(String[]args){
    SimpleCracker sc = new SimpleCracker("./common-passwords.txt", "./shadow-simple");

    ArrayList<String> matches = new ArrayList<String>();

    matches = sc.crack();

    for(int i=0;i<matches.size();i++){
      System.out.println(matches.get(i));
    }

  }
}
