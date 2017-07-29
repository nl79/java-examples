public class Earth {
    public static void main(String args[]) {
        Human tom;
        Human joe;

        // Empty constructor.
        tom = new Human();
        tom.age = 5;
        tom.eyeColor = "brown";
        tom.heightInInches = 72;
        tom.name = "Tom Awesome";
        tom.speak();

        // Overloaded Constructor.
        joe = new Human("Tom", 1234, "green", 234 );
        joe.speak();
    }
}