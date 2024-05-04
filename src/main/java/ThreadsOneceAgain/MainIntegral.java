package ThreadsOneceAgain;

public class MainIntegral implements Summator{
    private double sum = 0;

    public synchronized void addSum(double partValue) { // syncronised чтобы не было конфликта между потоками но будем терять в произвродительности
        sum += partValue;
    }

    public double getSum() {
        return sum;
    }
}
