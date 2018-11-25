class MobilePhone implements ITelephone {
  private int myNumber;
  private boolean isRinging;
  private boolean isOn = false;

  public MobilePhone(int myNumber) {
    this.myNumber = myNumber;
  }
  @Override
  public void powerOn() {
    this.isOn = true;
    System.out.println("Phone powered up");

  }

  @Override
  public void dial(int phoneNumber) {
    if(this.isOn) {
      System.out.println("Now ringing " + phoneNumber + " on deskphone");
    } else {
      System.out.println("Phone is switched off");
    }
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