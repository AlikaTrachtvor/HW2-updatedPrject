public class Negation extends Function{
    private Function function;
    public Negation (Function function){this.function = function;}
    @Override
    public double valueAt(double x){
        double value = this.function.valueAt(x);
        value *= -1;
        return value;
    }
    @Override
    public Negation derivative(){
        Function dvtTemp = this.function.derivative();
        Negation dvt = new Negation(dvtTemp);
        return dvt;
    }
    @Override
    public String toString(){
        String str = "(-" + this.function.toString() + ")";
        return str;
    }
}

