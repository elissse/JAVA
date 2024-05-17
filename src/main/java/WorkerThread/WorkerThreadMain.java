package WorkerThread;

import java.util.ArrayList;
import java.util.Arrays;

public class WorkerThreadMain {
    public static void main(String[] args) {
        BlockingQueue queue = new BlockingQueue();
        Thread worker = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) { // флаг при выбросе исключения сбрасывается
                    Runnable task = queue.get();
                    if (task != null)
                        task.run();
                }
            }
        });
        worker.start();
        for (int i = 0; i < 10; i++) {
            queue.put(getTask());
        }
        try {
            Thread.sleep(5000);
            worker.interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static Runnable getTask() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("task started: " + this);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("task finished: " + this);
            }
        };
    }

    public static class BlockingQueue {
        ArrayList<Runnable> tasks = new ArrayList<>();

        public synchronized Runnable get() {
            Runnable task = null;
            while (tasks.isEmpty()) {
                try {
                    wait();
                    task = tasks.get(0);
                    tasks.remove(task);
                    return task;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return task;
                }
            }
            task = tasks.get(0);
            tasks.remove(task);
            return task;
        }

        public synchronized void put(Runnable task) {
            tasks.add(task);
            notify();
        }
    }
}
