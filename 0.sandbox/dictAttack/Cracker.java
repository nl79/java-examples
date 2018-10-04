import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.ArrayList;
import java.security.MessageDigest;

// https://raw.githubusercontent.com/danielmiessler/SecLists/master/Passwords/Common-Credentials/10-million-password-list-top-1000000.txt

/*
user0:kimberly
user1:stuttgart
user8:superstage
user9:mozart
*/

/*
user0:kimberly
user1:stuttgart
user5:honeydew
user8:superstage
user9:mozart
*/
public class Cracker {

  private String dictFilepath;
  private String pwFilepath;
  private ArrayList<String> tokens;


  public static void main(String[]args) {

    Cracker cracker = new Cracker("./common-passwords.txt", "./shadow");
    ArrayList<String> matches = new ArrayList<String>();

    matches = cracker.crack();

    for(int i=0;i<matches.size();i++){
      System.out.println(matches.get(i));
    }
  }

  public Cracker(String dictFilepath, String pwFilepath) {
    this.dictFilepath = dictFilepath;
    this.pwFilepath = pwFilepath;
    this.tokens = this.readDictionary(this.dictFilepath);
  }

  public static String toHex(byte[] bytes) {
    BigInteger bi = new BigInteger(1, bytes);
    return String.format("%0" + (bytes.length << 1) + "X", bi);
  }

  private ArrayList<String> readDictionary(String filepath) {
    File file = new File(filepath);
    ArrayList<String> tokens = new ArrayList<String>();
    String token;
    if(!file.exists() || file.isDirectory()) {
      System.out.println("Invalid Filepath Supplied");
    }

    try {
      Scanner sc = new Scanner(file);

      while(sc.hasNextLine()) {
        token = sc.nextLine();
        tokens.add(token);
      }

      sc.close();
    } catch(FileNotFoundException e) {
      System.out.println("File Not Found");
    }

    return tokens;
  }

  public ArrayList<String> crack() {
    return this.crack(this.tokens, this.pwFilepath);
  }

  public ArrayList<String> crack(ArrayList<String> tokens, String filepath) {
    ArrayList<String> matches = new ArrayList<String>();
    MessageDigest messageDigest;
    String hash;
    File file = new File(filepath);
    String entry;
    String token;

    // Validate if the password file exists.
    if(!file.exists() || file.isDirectory()) {
      System.out.println("Invalid Password Filepath Supplied");
      return matches;
    }

    try {
      messageDigest = MessageDigest.getInstance("MD5");
    } catch(Exception e) {
      System.out.println("MessageDigest.getInstance(): No such Algorithm");
      return matches;
    }

    // Scan Each line of the password file and compute the hash.
    try {
      Scanner sc = new Scanner(file);

      while(sc.hasNextLine()) {
        entry = sc.nextLine();
        
        // Split the entry and extract the salt and password.
        String[] parts = entry.split(":");

        // Strip the first $ character from the password field
        // Split the password field into chunks on the $ character
        String[] pwHashParts = parts[1].replaceAll("^[$]", "").split("\\$");
        
        // Loop over every password token,  
        for(int i=0; i < tokens.size(); ++i) {
          token = tokens.get(i);
          //System.out.println(token);
          // hash it with the salt, and compare it.
          try {
            hash = MD5Shadow.crypt(token, pwHashParts[1]);
          } catch(Exception e) {
            //System.out.println("Failed to Hash! Salt: " + pwHashParts[1] + "| Token: " + token);
            continue;
          }
          
          // System.out.println(hash);
          // System.out.println(hashParts[2]);
          // System.out.println("-----------------------");
          if(pwHashParts[2].equals(hash)) {
            matches.add(parts[0] + ":" + token);
          }
        }
      }

      sc.close();
    } catch(FileNotFoundException e) {
      System.out.println("Password File Not Found");
    }

    return matches;
  }
}