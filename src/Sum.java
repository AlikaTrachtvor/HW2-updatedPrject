
public class Sum extends MultiSum {
    /***
     * The class represents a function combined from summarizing two functions
     */

    public Sum(Function function1, Function function2) {
        super(function1,function2);
    }

    @Override
    public double valueAt(double x) {
        return functions[0].valueAt(x) + functions[1].valueAt(x);
    }


}

