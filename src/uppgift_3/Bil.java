package uppgift_3;

public class Bil extends Fordon implements Printable, Hjulburen{
    int antalVaxlar;
    int vaxelJustNu;
    int antalHjul;
    @Override
    public void getAntalHjul() {
        System.out.println("The car has: " + antalHjul + " Wheels");
    }
    @Override
    public void changeSpeed() { }

    @Override
    public void printMe() {
        System.out.print("Car > ");
        System.out.print("Gear Amount: " + antalVaxlar);
        System.out.print(" Current Gear: " + vaxelJustNu);
        System.out.print(" Speed: " + hastighet);
        System.out.print(" Weight: " + vikt);
        System.out.println(" Number of Wheels: " + antalHjul);
    }
    public void changeGear(){
        vaxelJustNu = vaxelJustNu +1;
        System.out.println("Gear has been changed");
    }


    public Bil(int antalVaxlar, int vaxelJustNu, int hastighet, int vikt, int antalHjul) {
        super(hastighet, vikt);
        this.antalVaxlar = antalVaxlar;
        this.vaxelJustNu = vaxelJustNu;
        this.antalHjul = antalHjul;
    }
}
