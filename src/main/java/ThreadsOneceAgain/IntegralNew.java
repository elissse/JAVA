package ThreadsOneceAgain;


public class IntegralNew extends Thread {
    // funtcion : sin(e^x)
    private static int N = 1000;
    private double sum = 0;
    private double a;
    private double b;
    private ISummator summator;

    public double getSum() {
        return sum;
    }

    IntegralNew(double a, double b, ISummator summator) {
        this.a = a;
        this.b = b;
        this.summator = summator;
    }

    private double function(double x) {
        return Math.sin(Math.exp(x));
    }

    @Override
    public void run() {
        double delta = (b - a) / N;
        double summ =0 ;
        for (int i = 0; i < N; i++) {
            summ += (function(a + delta * i) + function(a + delta * (i + 1))) / 2 * delta;

        }
        summator.addSum(summ);
    }
}
