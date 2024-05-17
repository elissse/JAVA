package ExecutorService;

import org.example.Main;

import java.awt.image.BufferedImage;
import java.util.concurrent.*;

public class ExecutorServiceMain {
    public static void main(String[] args) {
        Double sum = 0d;
        ExecutorService poolService = Executors.newFixedThreadPool(4);
        Future<Double> future1 = poolService.submit(new Task(0, 0.1));
        Future<Double> future2 = poolService.submit(new Task(0.1, 0.2));
        Future<Double> future3 = poolService.submit(new Task(0.2, 0.3));
        Future<Double> future4 = poolService.submit(new Task(0.3, 0.4));
        Future<Double> future5 = poolService.submit(new Task(0.4, 0.5));
        Future<Double> future6 = poolService.submit(new Task(0.5, 0.6));
        Future<Double> future7 = poolService.submit(new Task(0.6, 0.7));
        Future<Double> future8 = poolService.submit(new Task(0.7, 0.8));
        Future<Double> future9 = poolService.submit(new Task(0.8, 0.9));
        Future<Double> future10 = poolService.submit(new Task(0.9, 1.0));
        Future<Double> future11 = poolService.submit(new Task(1.0, 1.1));
        Future<Double> future12 = poolService.submit(new Task(1.1, 1.2));
        try {
            sum += future1.get();
            sum += future2.get();
            sum += future3.get();
            sum += future4.get();
            sum += future5.get();
            sum += future6.get();
            sum += future7.get();
            sum += future8.get();
            sum += future9.get();
            sum += future10.get();
            sum += future11.get();
            sum += future12.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(sum);
        poolService.shutdown();
    }

    public static class Task implements Callable<Double> {
        private double a;
        private double b;

        Task(double a, double b) {
            this.a = a;
            this.b = b;
        }

        public Task(int i, BufferedImage out, BufferedImage picture) {
        }

        public Double call() {
            System.out.println("start");
            Double result = 0d;
            double h = ((double) b - a) / 100000;
            for (int i = 0; i < 100000; i++) {
                result = Math.sin(a + h * i) * h;
            }
            System.out.println("end");
            return result;
        }
    }
}
