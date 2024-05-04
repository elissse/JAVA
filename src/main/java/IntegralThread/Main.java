package IntegralThread;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();
        Integral thread = new Integral(0, 1);
        thread.run();
        long end = System.nanoTime();
        System.out.println(thread.getSum());
        System.out.println("time if there's only one thread: " +(end - start));
        //thread.join();

        double a = 0;
        double b = 1;
        int threads = Runtime.getRuntime().availableProcessors();
        double dist = (b - a) / threads;
        List<Integral> integralshehe = new ArrayList<>();

        for (int i = 0; i < threads; i++) {
            Integral threadd = new Integral(a + dist * i, a + dist * (i + 1));
            integralshehe.add(threadd);
        }
        start = System.nanoTime();
        integralshehe.forEach(Thread::start);
        integralshehe.forEach(thr -> {
            try {
                thr.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        double sum = integralshehe.stream().mapToDouble(Integral::getSum).sum();

        end = System.nanoTime();
        System.out.println(sum);
        System.out.println("time if there're 12 threads: " +(end - start));
    }
}
