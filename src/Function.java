import java.lang.Math;
public abstract class Function {
    /***
     * this is an abstract class for mathematical functions
     */

    /***
     * this method calculate the value of the function given a specific x
     * @param x the value the function is activated on
     * @return the value of the function in x
     */
    public abstract double valueAt(double x);

    /***
     * this method creates a String representation of the function
     * @return a String representing the function
     */
    public abstract String toString();

    /***
     * this method generate the derivative of the function
     * @return a Function object representing the derivative
     */
    public abstract Function derivative();

    /***
     * this method calculates the root in a given section using the bisection method
     * @param a the left end of the section
     * @param b the right end of the section
     * @param epsilon error range
     * @return a root value
     */
    public double bisectionMethod(double a, double b, double epsilon){
        double left = a, right = b;
        while(right - left > epsilon){
            double mid = (left + right) / 2;
            if(valueAt(left) * valueAt(mid) > 0)
                left = mid;
            else
                right = mid;
        }
        return (left + right) / 2;
    }

    /***
     * this method calculates the root in a given section using the bisection method with error range
     * 10^-5
     * @param a the left end of the section
     * @param b the right end of the section
     * @return a root value
     */
    public double bisectionMethod(double a, double b){
        double epsilon = 0.00001;
        return bisectionMethod(a, b, epsilon);
    }

    /***
     * this method calculates the root around point a using the Newton-Raphson method
     * @param a a chosen point to be checked
     * @param epsilon error range
     * @return a root value
     */
    public double newtonRaphsonMethod(double a, double epsilon){
        double x = a;
        Function dvt = derivative();
        while(Math.abs(valueAt(x)) >= epsilon)
            x = x - ((valueAt(x)) / (dvt.valueAt(x)));
        return x;
    }

    /***
     * this method calculates the root around point a using the Newton-Raphson method with error range
     * 10^-5
     * @param a a chosen point to be checked
     * @return
     */
    public double newtonRaphsonMethod(double a){
        double epsilon = 0.00001;
        return newtonRaphsonMethod(a, epsilon);
    }

    /***
     * this method calculate n!
     * @param n the number the factorial is calculated for
     * @return n!
     */
    private double factorial(int n){
        if(n == 0 || n == 1)
            return 1;
        else{
            double value = 1;
            for(int i = 2; i <= n; i++)
                value *= i;
            return value;
        }
    }

    /***
     * this method builds the Taylor Polynomial of the function around x = 0
     * @param n order of the Taylor Polynomial
     * @return a Polynomial object representing the Taylor Polynomial
     */
    public Polynomial taylorPolynomial(int n){
        double[] coff = new double[n + 1];
        Function current = this;
        for(int i = 0; i < n + 1; i++){
            coff[i] = current.valueAt(0) / factorial(i);
            current = current.derivative();
        }
        Polynomial taylor = new Polynomial(coff);
        return taylor;
    }

}

