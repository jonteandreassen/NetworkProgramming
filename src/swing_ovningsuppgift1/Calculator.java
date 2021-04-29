package swing_ovningsuppgift1;

public class Calculator {
    double milesNow;
    double milesYearAgo;
    double gasConsumed;

    public double getMilesNow() { return milesNow; }
    public void setMilesNow(double milesNow) { this.milesNow = milesNow; }
    public double getMilesYearAgo() { return milesYearAgo; }
    public void setMilesYearAgo(double milesYearAgo) { this.milesYearAgo = milesYearAgo; }
    public double getGasConsumed() { return gasConsumed; }
    public void setGasConsumed(double gasConsumed) { this.gasConsumed = gasConsumed; }

    //Calculator method
    public double getMiles(){
        return  this.milesYearAgo - this.milesNow;
    }
    public double getFuel(){
        return this.getGasConsumed();
    }
    public double getGas(){
        return this.gasConsumed / this.getMiles();
    }
    public Calculator(int milesNow, double milesYearAgo, double gasConsumed) {
        this.milesNow = milesNow;
        this.milesYearAgo = milesYearAgo;
        this.gasConsumed = gasConsumed;
    }
}
