public class Human {
    String name;
    int age;
    int heightInInches;
    String eyeColor;
    
    public Human() { }

    public Human(String name, int age, String eyeColor, int heightInInches) {
        this.age = age;
        this.eyeColor = eyeColor;
        this.heightInInches = heightInInches;
        this.name = name;
    }
    public void speak() {
        System.out.println("Hello, my name is " + name);
        System.out.println("I am " + heightInInches + " inches tall");
        System.out.println("I am " + age + " years old ");
        System.out.println("My eye color is " + eyeColor);
    }

    public void walk() {
        System.out.println("walking...");
    }
    public void eat() {
        System.out.println("eating...");
    }
    public void work() {
        System.out.println("working...");
    }
}