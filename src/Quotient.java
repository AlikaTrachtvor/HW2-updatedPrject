
public class Quotient extends Function {
    private Function function1;
    private Function function2;

    public Quotient(Function function1,Function function2){
        this.function1 = function1;
        this.function2 = function2;
    }

    @Override
    public double valueAt(double x) {

        return function1.valueAt(x) / function2.valueAt(x);
    }

    @Override
    public Quotient derivative(){
        int i;
        Product func1 = new Product(this.function1.derivative(),this.function2);
        Product func2 = new Product(this.function2.derivative(),this.function1);
        Difference U = new Difference(func1,func2);
        Power V = new Power(this.function2,2);
        Quotient dvt = new Quotient(U,V);
        return dvt;
    }

    @Override
    public String toString() {
        String str = "(" + this.function1.toString() + " / " + this.function2.toString() + ")";
        return str;
    }
}

