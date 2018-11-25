public class DeskPhone implements ITelephone {
  private int myNumber;
  private boolean isRinging;

  public DeskPhone(int myNumber) {
    this.myNumber = myNumber;
  }
  @Override
  public void powerOn() {
    System.out.println("No Action taken, desk phon does not have a power button");

  }

  @Override
  public void dial(int phoneNumber) {
    System.out.println("Now ringing " + phoneNumber + " on deskphone");
  }

  @Override
  public void answer() {
    if(this.isRinging) {
      System.out.println("Answering phone");
      this.isRinging = false;
    }
  }

  @Override
  public boolean callPhone(int phoneNumber) {
    if(phoneNumber == myNumber) {
      isRinging = true;
      System.out.println("Ring ring");
    } else {
      isRinging = false;
    }
    return isRinging;
  }

  @Override
  public boolean isRinging() {
    return this.isRinging;
  }
}