

public class ExtendedPassword {
  private int decryptedPassword;

  public ExtendedPassword(int password) {
    super(password);
    this.decryptedPassword = password;
  }

  @Override
  public void storePassword() {
    System.out.println("Saving password as " + this.decryptedPassword);
  }
}