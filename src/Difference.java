
public class Difference extends Function {
    private Function function1;
    private Function function2;
    public Difference(Function function1, Function function2) {
        this.function1 = function1;
        this.function2 = function2;
    }
    @Override
    public double valueAt(double x){
        double value = this.function1.valueAt(x) - this.function2.valueAt(x);
        return value;
    }

    @Override
    public Difference derivative(){
        Function dvt1 = this.function1.derivative();
        Function dvt2 = this.function2.derivative();
        Difference dvt = new Difference(dvt1, dvt2);
        return dvt;
    }
    @Override
    public String toString(){
        String str = "(" + this.function1 + " - " + this.function2 + ")";
        return str;
    }
}



