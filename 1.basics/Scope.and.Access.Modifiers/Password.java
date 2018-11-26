
public class Password {
  private static final int key = 1235213512;
  private final int encryptedPassword;

  public Password(int password) {
    this.encryptedPassword = this.encryptDecrypt(password);
  }

  private int encryptDecrypt(int password) {
    return password ^ key;
  }

  public void storePassword() {
    System.out.println("Saving passwrod as " + this.encryptedPassword);
  }

  public boolean letMeIn(int password) {
    if(this.encryptDecrypt(password) == this.encryptedPassword) {
      System.out.println("Welcome");
      return true;
    } else {
      System.out.println("Nope, you cannot come in");
      return false;
    }
  }
}