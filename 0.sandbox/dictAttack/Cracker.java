import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.ArrayList;
import java.security.MessageDigest;

public class Cracker {

  private String dictFilepath;
  private String pwFilepath;
  private ArrayList<String> tokens;

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
        String[] hashParts = parts[1].replace("^\\$", "").split("\\$");

        for(int i = 0; i < hashParts.length; ++i) {
          System.out.println(hashParts[i]);
        }

        // Loop over every password token,  
        for(int i=0; i < tokens.size(); ++i) {
          token = tokens.get(i);

          // hash it with the salt, and compare it.
          hash = MD5Shadow.crypt(token, hashParts[1]);
          // System.out.println(hash);
          // System.out.println(hashParts[2]);
          // System.out.println("-----------------------");
          if(hashParts[2].equals(hash)) {
            matches.add(parts[0] + ":" + token);
            System.out.println(parts[0] + ":" + token);
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