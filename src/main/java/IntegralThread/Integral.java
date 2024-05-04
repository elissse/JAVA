package IntegralThread;

public class Integral extends Thread {
    // funtcion : sin(e^x)
    private static int N = 1000;
    private double sum = 0;
    private double a;
    private double b;

    public double getSum() {
        return sum;
    }

    public Integral(double a, double b) {
        this.a = a;
        this.b = b;
    }

    private double function(double x) {
        return Math.sin(Math.exp(x));
    }

    @Override
    public void run() {
        double delta = (b - a) / N;
        for (int i = 0; i < N; i++) {
            sum += (function(a + delta * i)+function(a+delta*(i+1)))/2 * delta;
        }
    }
}
