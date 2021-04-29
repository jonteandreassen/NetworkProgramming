package uppgift_3;

public class Train extends Fordon implements Printable, Hjulburen {
    int antalVagnar;
    int antalHjul;

    public void getAntalHjul() {
        System.out.println("The train has: " + antalHjul + " Wheels");
    }

    @Override
    public void changeSpeed() { }

    @Override
    public void printMe() {
        System.out.print("Train > ");
        System.out.print("Number of Carts: " + antalVagnar);
        System.out.print(" Speed: " + hastighet);
        System.out.print(" Weight: " + vikt);
        System.out.println(" Number of Wheels: " + antalHjul);
    }

    public void attachCart(){
        antalVagnar = antalVagnar + 1;
        System.out.println("Added a cart");
    }


    public Train(int antalVagnar, int hastighet, int vikt, int antalHjul) {
        super(hastighet, vikt);
        this.antalVagnar = antalVagnar;
        this.antalHjul = antalHjul;
    }
}
