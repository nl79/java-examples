import java.util.Scanner;

public class Main {

  private static Scanner scanner = new Scanner(System.in);
  private static Button btnPrint = new Button("Print");

  public static void main(String[] args) {
    ITelephone myPhone;
    myPhone = new DeskPhone(12341234);
    myPhone.powerOn();
    myPhone.callPhone(23423423);
    myPhone.answer();

    myPhone = new MobilePhone(123412343);


    Player testPlayer = new Player("Test", 23423, 234);

    Gearbox mcLaren = new Gearbox(6);

    // Java Version 8 feature.
    // will only work if Gear is a public clas.
    //Gearbox.Gear first = mcLaren.new Gear(1, 12.3);

    // // Will not work because 'Gear' is not a static class of Gearbox
    // Gearbox.Gear second = new Gearbox.Gear(2, 15,2);
    
    // // Will not work
    // Gearbox.Gear third = new mcLarent.Gear(2, 14.2);

    //System.out.println(first.driveSpeed(1000));

    mcLaren.operateClutch(true);
    mcLaren.changeGear(1);
    mcLaren.operateClutch(false);
    System.out.println(mcLaren.wheelSpeed(1000));
    mcLaren.changeGear(2);
    System.out.println(mcLaren.wheelSpeed(3000));
    mcLaren.operateClutch(true);
    mcLaren.changeGear(3);
    mcLaren.operateClutch(true);
    System.out.println(mcLaren.wheelSpeed(6000));

    //Inner class that will be used as a click handler.
    //It will implemeent the interface required by a button click event.
    // class ClickListener implements Button.OnClickListener {
    //   public ClickListener() {
    //     System.out.println("I've been attached");
    //   }

    //   @Override
    //   public void onClick(String title) {
    //     System.out.println(title + " was clicked");
    //   }
    // }

    // btnPrint.setOnClickListener(new ClickListener()); 

    // Anonamous Classes.
    // The implementation of the OnClickListener interface is on the fly. 
    btnPrint.setOnClickListener(new Button.OnClickListener() {
      @Override
      public void onClick(String title) {
        System.out.println(title + " was clicked");
      }
    });
    listen();
    
  }

  private static void listen() {
    boolean quit = false;
    while(!quit) {
      int choice = scanner.nextInt();
      scanner.nextLine();
      switch(choice) {
        case 0:
          quit = true;
          break;
        case 1:
          btnPrint.onClick();

      }
    }
  }
}