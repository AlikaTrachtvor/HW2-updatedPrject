public class Constant extends Polynomial{
    public Constant(double c){ super(c);}
    @Override
    public Constant derivative(){
        Constant dvt = new Constant(0);
        return dvt;
    }

    /*public  String toString() {
        if (this.coefficients[0] % 1 == 0)
            return "(" + (int) this.coefficients[0] + ")";
        else
            return "(" + this.coefficients[0] + ")";
    }*/
}

