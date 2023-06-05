
public class Product extends MultiProduct{
    /***
     * The class represents a function combined from multiplying two separate functions
     */

    public Product(Function function1,Function function2){
        super(function1, function2);
    }

    @Override
    public double valueAt(double x) {
        return functions[0].valueAt(x) * functions[1].valueAt(x);
    }

}

