package uppgift_1;
//import uppgift_1a.Shoes;


import java.util.ArrayList;
import java.util.List;

public class ShoeMain {
    int index = -1;
    List<Shoes> shoes = new ArrayList<>();
    public void addShoe(String name, int size, String color){
        Shoes newShoe = new Shoes(name, size, color);
        shoes.add(newShoe);
    }

    public void removeShoe(String name, int size, String color){
        for (int i = 0; i < shoes.size(); i++){
            if(shoes.get(i).getColor().equalsIgnoreCase(color) && shoes.get(i).getName().equalsIgnoreCase(name)
                    && shoes.get(i).getSize()==size){
                index = i;
            }
        }
        if (index != -1){
            shoes.remove(index);
        }
    }

    public void updateColor(int size, String oldColor, String name, String newColor){
        for (int i = 0; i < shoes.size(); i++){
            if(shoes.get(i).getColor().equalsIgnoreCase(oldColor) && shoes.get(i).getName().equalsIgnoreCase(name)
                    && shoes.get(i).getSize()==size){
                index = i;
            }
        }
        shoes.get(index).setColor(newColor);
    }

    public ShoeMain() {
        Shoes s1 = new Shoes("Nike", 45, "Black");
        Shoes s2 = new Shoes("Adidas", 43, "White");
        Shoes s3 = new Shoes("New Balance", 42, "Blue");
        Shoes s4 = new Shoes("Lidl", 41, "Cyan");
        s2.setName("myDidas");
        s3.setSize(54);
        //Adding shoes to list
        addShoe(s1.getName(), s1.getSize(), s1.getColor());
        addShoe(s2.getName(), s2.getSize(), s2.getColor());
        addShoe(s3.getName(), s3.getSize(), s3.getColor());
        addShoe(s4.getName(), s4.getSize(), s4.getColor());
        //Looping through shoelist
        System.out.println("Old List");
        for (Shoes shoe : shoes){
            System.out.println(shoe.getShoes());
        }
        removeShoe(s4.getName(),s4.getSize(),s4.getColor());
        updateColor(s1.getSize(), s1.getColor(), s1.getName(), "GOLDEN");

        //Looping through shoelist
        System.out.println("New list");
        for (Shoes shoe : shoes){
            System.out.println(shoe.getShoes());
        }
    }

    public static void main(String[] args){
        ShoeMain s = new ShoeMain();
    }
}
