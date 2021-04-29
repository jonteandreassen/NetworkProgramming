package uppgift_4;

import java.util.Scanner;

public class mainScanner {
    public Scanner myScanner = new Scanner(System.in);
    public double getParams(String Message){
        System.out.println(Message);
        System.out.flush();
        return myScanner.nextDouble();
    }

    public mainScanner(){
        double currentMiles = getParams("Ange mätarställning nu: ");
        double oldMiles = getParams("Ange mätarställning för ett år sedan: ");
        double amountOfGas = getParams("Ange antal liter förbrukad bensin: ");

        double drivenMiles = currentMiles - oldMiles;
        double gasPerMil = amountOfGas / drivenMiles;

        System.out.println("Antal körda mil: "+drivenMiles);
        System.out.println("Antal liter bensin: "+amountOfGas);
        System.out.println("Förbrukning per mil: " + String.format("2%f", gasPerMil));
    }
    public static void main(String[] args) {
        mainScanner s = new mainScanner();
    }
}
