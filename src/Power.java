
public class Power extends Function{
    /***
     * The class represents a power function
     */

    private int power;
    private Function function1;
    private Function [] funcs;

    public Power(Function function1, int power) {
        int i=0;
        this.power = power;
        this.function1 = function1;
        this.funcs =  new Function[this.power];
        for(i=0;i<this.power;i++){
            this.funcs[i] = this.function1;
        }
    }

    @Override
    public double valueAt(double x){
        double value = Math.pow(this.function1.valueAt(x), this.power);
        /*for(int i = 0; i < this.power; i++)
            value *= this.funcs[i].valueAt(x);*/
        return value;
    }
    @Override
    public Function derivative(){
        int i=0;
        if(this.power == 1)
            return this.function1.derivative();
        else{
            Function[] devFunc = new Function[3];
            devFunc[0] = new Constant(this.power);
            devFunc[1] = new Power(this.function1, this.power - 1);
            devFunc[2] = this.function1.derivative();
            MultiProduct dvt = new MultiProduct(devFunc);
            return dvt;
        }
    }

    @Override
    public String toString(){
        String str = "(" + this.function1.toString() + "^" + this.power + ")";
        /*for(int i = 0; i < this.power - 1; i++)
            str += this.function1.toString() + " * ";
        str += this.funcs[this.power - 1].toString() + ")";*/
        return str;
    }
}



