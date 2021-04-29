package uppgift_5;

public class calculator {
    public boolean operatorSupported(String operator){
        if (!operator.equalsIgnoreCase("+") && !operator.equalsIgnoreCase("-")
                && !operator.equalsIgnoreCase("*") && !operator.equalsIgnoreCase("/")) {
            return false;
        }
        return true;
    }

    public double calculate(double a, double b, String operator) throws nonSupportedOperatorsException{
        if (!operatorSupported(operator)){
            throw new nonSupportedOperatorsException("Faulty operator");
        }
        if (a == 0 || b == 0 && operator.equals("/")){
            System.out.println("Unable to devide by 0");
        }
        if(operator.equalsIgnoreCase("+")) return a + b;
        else if (operator.equalsIgnoreCase("-")) return a - b;
        else if (operator.equalsIgnoreCase("*")) return a * b;
        else return a / b;
    }
}
