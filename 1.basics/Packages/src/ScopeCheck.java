

public class ScopeCheck {
  public int publicVar = 0;
  private int privateVar = 1;

  public ScopeCheck() {
    System.out.println("ScoreCheck created, publicVar = " + this.publicVar + " : privateVar = " + this.privateVar);

  }

  public int getPrivateVar() {
    return this.privateVar;
  }

  public void timesTwo() {
    int privateVar = 2;
    for(int i = 0; i < 10; ++i) {
      System.out.println(i + " times two is " + i * privateVar);
    }
  }

  public void userInner() {
    InnerClass innerClass = new InnerClass();
    System.out.println("varThree from outter class " + innerClass.varThree);
  }

  public class InnerClass {
    //public int privateVar = 3;
    private int varThree = 3;

    public InnerClass() {
      System.out.println("InnerClass created, privateVar is " + privateVar);
    }

    public void timesTwo() {
      int privateVar = 2;
      // This will jump up to the parent class and use the privateVar value of the parent ScopeCheck class.
      for(int i = 0; i < 10; ++i) {
        System.out.println(i + " times two is " + i * privateVar);
      }

      for(int i = 0; i < 10; ++i) {
        System.out.println(i + " times two is " + i * ScopeCheck.this.privateVar);
      }

      // Will call the enclosing classes 'timesTwo' method.
      ScopeCheck.this.timesTwo();
    }
  }
}