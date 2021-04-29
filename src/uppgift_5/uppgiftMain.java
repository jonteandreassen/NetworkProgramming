package uppgift_5;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class uppgiftMain {

    public uppgiftMain(){

        calculator calculator = new calculator();
        double num1;
        double num2;
        double result;
        String operator;
        String answer = "";

            while (true) {
                System.out.println("Calculate something: ");
                Scanner myScanner = new Scanner(System.in);
                try {
                    num1 = myScanner.nextDouble();
                    operator = myScanner.next();
                    num2 = myScanner.nextDouble();
                    result = calculator.calculate(num1, num2, operator);
                    answer = "Results in: " + result;
                    System.out.println(result);
                } catch (InputMismatchException e) {
                    answer = "Wrong format on data";
                    System.out.println(answer);
                } catch (NoSuchElementException e) {
                    answer = "Unable to read data";
                    System.out.println(answer);
                } catch (nonSupportedOperatorsException e) {
                    answer += e.getMessage();
                    System.out.println(answer);
                }

            }

    }
    public static void main(String[] args){
        uppgiftMain m = new uppgiftMain();
    }
}
