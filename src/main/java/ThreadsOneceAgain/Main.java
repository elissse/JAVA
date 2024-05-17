package ThreadsOneceAgain;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Summator mainIntegral = new Summator();
        double a = 0;
        double b = 1;
        int threads = Runtime.getRuntime().availableProcessors();
        double dist = (b - a) / threads;
        List<IntegralNew> integralshehe = new ArrayList<>();

        for (int i = 0; i < threads; i++) {
            IntegralNew threadd = new IntegralNew(a + dist * i, a + dist * (i + 1), mainIntegral);
            integralshehe.add(threadd);
        }
        long start = System.nanoTime();
        integralshehe.forEach(Thread::start);
        integralshehe.forEach(thr -> {
            try {
                thr.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        double sum = integralshehe.stream().mapToDouble(IntegralNew::getSum).sum();

        long end = System.nanoTime();
        System.out.println(mainIntegral.getSumma());
        System.out.println("time if there're 12 threads: " + (end - start));
        System.out.println();
    }
}