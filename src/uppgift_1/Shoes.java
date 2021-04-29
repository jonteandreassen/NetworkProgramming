package uppgift_1;

public class Shoes {
    private String name;
    private int size;
    private String color;

    public String getShoes(){
        return "Brand: " + getName() + " Size: " + getSize() + " Color: " + getColor();
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getName() {
        return name;
    }
    public int getSize() {
        return size;
    }
    public String getColor() {
        return color;
    }

    public Shoes(String name, int size, String color) {
        this.name = name;
        this.size = size;
        this.color = color;
    }
}
