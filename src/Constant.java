public class Constant extends Polynomial{
    /***
     * this class represents a constant function. It inherits the class Polynomial since
     * a constant function is a polynomial with just one coefficient for x^0
     */
    public Constant(double c){ super(c);}

    /***
     * this method calculates the derivative of a constant function
     * @return a constant function with value 0
     */
    @Override
    public Constant derivative(){
        Constant dvt = new Constant(0);
        return dvt;
    }
}

