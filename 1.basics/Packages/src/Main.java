
import java.lang.Integer;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.example.mypackage.*;

public class Main {

  public static void main(String[] args) {

    java.util.ArrayList list = null;
    // MyWindow myWindow = new MyWindow("Awesome Java");
    // myWindow.setVisible(true);

    Sample sample = new Sample("Test Sample");
    sample.print();

    String privateVar = "this is a private to main()";

    ScopeCheck scopeInstance = new ScopeCheck();
    System.out.println("scopeInstance privateVar is " + scopeInstance.getPrivateVar());
    System.out.println(privateVar);

    scopeInstance.timesTwo();
    ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
    innerClass.timesTwo();

    scopeInstance.userInner();
  }

  
}