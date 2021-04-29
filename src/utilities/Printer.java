package utilities;

public class Printer {
    String name;
    int price;

    public String getName(){return name;}
    public void setName(String name) {this.name = name;}
    public void print(String x){System.out.println(x);}
    public void setPrice(int price) {this.price = price;}
    public int getPrice() {return price;}

    //Constructor
    public Printer(String name, int price){
        System.out.println(name + " Says: ");
        this.name = name;
        this.price = price;
    }
}
