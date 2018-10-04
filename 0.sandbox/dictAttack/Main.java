import java.util.ArrayList;

public class Main {
  public static void main(String[]args){
    SimpleCracker sc = new SimpleCracker("./common-passwords.txt", "./shadow-simple");
    Cracker cracker = new Cracker("./common-passwords.txt", "./shadow");

    ArrayList<String> sc_matches = new ArrayList<String>();
    ArrayList<String> cracker_matches = new ArrayList<String>();

    // sc_matches = sc.crack();
    // cracker_matches = cracker.crack();

    // print(sc_matches);
    // System.out.println("------------------");
    // print(cracker_matches);

    Cracker crackerBig = new Cracker("./rockyou.txt", "./shadow");
    ArrayList<String> cracker_matches_big = new ArrayList<String>();

    cracker_matches_big = crackerBig.crack();

    print(cracker_matches_big);
  }

  public static void print(ArrayList<String> list) {
    for(int i=0;i<list.size();i++){
      System.out.println(list.get(i));
    }
  }
}
