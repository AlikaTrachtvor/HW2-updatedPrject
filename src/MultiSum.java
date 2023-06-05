public class MultiSum extends Function{
    /***
     *  This class represents a function that is made by summarizes different functions (must be at least 2 functions)
     */
    protected Function [] functions;
    private int numOfFunc;

    public MultiSum(Function...functions) {
        this.numOfFunc = functions.length;
        this.functions = new Function[numOfFunc];
        for (int i = 0; i < numOfFunc; i++)
            this.functions[i] = functions[i];
    }

    @Override
    public double valueAt(double x) {
        double sum = 0;
        for (int i = 0; i < numOfFunc; i++) {
            sum += functions[i].valueAt(x);
        }
        return sum;
    }

    @Override
    public MultiSum derivative(){
        int i;
        Function[] miniFunc = new Function[this.numOfFunc];
        for(i=0; i < numOfFunc; i++){
            miniFunc[i] = this.functions[i].derivative();
        }
        MultiSum finalDvt = new MultiSum(miniFunc);
        return finalDvt;
    }

    @Override
    public String toString(){
        String str = "(";
        for(int i = 0; i < this.numOfFunc - 1; i++){
            str += this.functions[i].toString() + " + ";
        }
        str += this.functions[this.numOfFunc - 1].toString() + ")";
        return str;
    }


}

