package uppgift_3;

import java.util.ArrayList;
import java.util.List;

public abstract class Fordon implements Printable, Hjulburen {
    int hastighet;
    int vikt;

    public abstract void changeSpeed();

    public Fordon(int hastighet, int vikt) {
        this.hastighet = hastighet;
        this.vikt = vikt;
    }
}
