package uppgift_3;

public class Boat extends Fordon implements Printable {
    int deadVikt;

    @Override
    public void getAntalHjul() {}

    @Override
    public void changeSpeed() {}

    @Override
    public void printMe() {
        System.out.print("Boat > ");
        System.out.print("Dead Weight: " + deadVikt);
        System.out.print(" Speed: " + hastighet);
        System.out.println(" Weight: " + vikt);
    }

    public void turn(){
        double turnDegrees = 0.0;
            if (turnDegrees == 0.0){
                turnDegrees = 180;
            }
        System.out.println("You have turned 180 degrees");
    }

    public Boat(int deadVikt, int hastighet, int vikt) {
        super(hastighet, vikt);
        this.deadVikt = deadVikt;
    }
}
