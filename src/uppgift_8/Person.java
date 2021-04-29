package uppgift_8;

public class Person {
    String name;
    String adress;
    String postNr;
    int age;
    int weight;
    int lenght;


    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getAdress() {return adress;}
    public void setAdress(String adress) {this.adress = adress;}
    public String getPostNr() {return postNr;}
    public void setPostNr(String postNr) {this.postNr = postNr;}
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
    public int getWeight() {return weight;}
    public void setWeight(int weight) {this.weight = weight;}
    public int getLenght() {return lenght;}
    public void setLenght(int lenght) {this.lenght = lenght;}

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", postNr='" + postNr + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", lenght=" + lenght +
                '}';
    }
    public Person(){}
    public Person(String name, String adress, String postNr, int age, int weight, int lenght) {
        this.name = name;
        this.adress = adress;
        this.postNr = postNr;
        this.age = age;
        this.weight = weight;
        this.lenght = lenght;
    }
}
