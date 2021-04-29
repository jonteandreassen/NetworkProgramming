package uppgift_3;

import java.util.ArrayList;
import java.util.List;

public class FordonMain {
    public static void main(String[] args) {
        Bil bil = new Bil(2, 4, 100, 2000, 4);
        Boat boat = new Boat(100, 44, 1200);
        Train train = new Train(55, 284, 10000, 128);
        Cykel cykel = new Cykel(21, 13, 10, 4, 2);
        List<Fordon> fordon = new ArrayList<>();
        fordon.add(bil);
        fordon.add(boat);
        fordon.add(train);
        fordon.add(cykel);
        Hjulburen newCar = () -> {
            for(Hjulburen h : fordon){
                h.getAntalHjul();
            }
        };
        newCar.getAntalHjul();

        System.out.println("*** Vehicle functions ***");
        boat.turn();
        bil.changeGear();
        cykel.changeGear();
        train.attachCart();
        System.out.println("*** Vehicle information ***");
        Printable newPrint = () -> {
            for (Fordon f : fordon){
                f.printMe();
            }
        };
        newPrint.printMe();
    }
}
