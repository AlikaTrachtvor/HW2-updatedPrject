import java.lang.Math;
public abstract class Function {

    public abstract double valueAt(double x);
    public abstract String toString();
    public abstract Function derivative();
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
    public double bisectionMethod(double a, double b){
        double epsilon = 0.00001;
        return bisectionMethod(a, b, epsilon);
    }

    public double newtonRaphsonMethod(double a, double epsilon){
        double x = a;
        Function dvt = derivative();
        while(Math.abs(valueAt(x)) >= epsilon)
            x = x - ((valueAt(x)) / (dvt.valueAt(x)));
        return x;
    }
    public double newtonRaphsonMethod(double a){
        double epsilon = 0.00001;
        return newtonRaphsonMethod(a, epsilon);
    }

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

