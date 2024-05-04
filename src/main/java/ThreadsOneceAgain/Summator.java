package ThreadsOneceAgain;

public class Summator implements ISummator {
    public volatile double summa = 0;

    public void addSum(double partValue) { // syncronised чтобы не было конфликта между потоками но будем терять в произвродительности
        synchronized (this) {
            summa += partValue;
        }
    }

    public double getSum() {
        return summa;
    }
}
