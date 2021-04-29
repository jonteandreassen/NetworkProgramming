package uppgift_7;

import java.io.BufferedReader;
import java.io.FileReader;

public class upggiftMain {
    public upggiftMain(){
        String tempLine;
        double temp = 0.0;
        double sumTemp = 0.0;
        double maxTemp = 0.0;//Double.MAX_VALUE;
        double minTemp = 0.0;//Double.MIN_VALUE;
        int nrOfDays = 0;

        try(BufferedReader bufin = new BufferedReader(new FileReader("C:\\Users\\jonte\\IdeaProjects\\mytest\\src\\uppgift_7\\temp.txt"));)
        {
            while((tempLine = bufin.readLine())!= null){
                //System.out.println(tempLine);
                temp = Double.parseDouble(tempLine.trim());
                if(temp > maxTemp){
                    maxTemp = temp;
                }if(temp < minTemp){
                    minTemp = temp;
                }
                nrOfDays++;
                sumTemp = temp;
            }
        }

        catch (Exception e){
            System.out.println("File could not be found");
            e.printStackTrace();
            System.out.flush();
            System.exit(0);
        }
        System.out.println("Max temp is: " + maxTemp);
        System.out.println("Min temp is: " + minTemp);
        System.out.println("Avg temp is: " + sumTemp/nrOfDays);
        System.out.println("Calculated on " + nrOfDays + " Days");


    }
    public static void main(String[] args) {
        upggiftMain m = new upggiftMain();
    }
}
