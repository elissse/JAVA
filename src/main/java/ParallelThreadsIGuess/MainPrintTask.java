package ParallelThreadsIGuess;

public class MainPrintTask {
    public static void main(String[] args) {
//        int n = Runtime.getRuntime().availableProcessors();
//        System.out.println(n);

        String data = "Ээээ... ведьмина лачужка, верно? Надеюсь хоть в этот раз мы не отправимся прямиком в печь...";

//        Thread thread1 = new Thread(new PrintTask(data));
//        Thread thread2 = new Thread(new PrintTask(data));
//
//        Thread thread1 = new Thread(() -> {
//            for (int i = 0; i < data.length(); i++)
//                System.out.print(data.charAt(i));
//            System.out.println();
//        });
//        Thread thread2 = new Thread(() -> {
//            for (int i = 0; i < data.length(); i++)
//                System.out.print(data.charAt(i));
//            System.out.println();
//        });
        Thread thread1 = new PrintTaskThread(data);
        Thread thread2 = new PrintTaskThread(data);
        thread1.setDaemon(true);
        thread2.setDaemon(true);

        thread1.start();
        thread2.start();
        /*
        currentThread() - returns link to current thread, analogy of this
        getId() - целое число идентифекатор потока, экземпляр создается только один для потока
        getName() / setName(String name) - lets give thread a string name

        join() - waiting for thread to finish, not static

        {
          thread.join()
          ...
          // код будет выполнен только после завершения потока thread
        }


        setDaemon(boolean on) - making sure the thread is not daemon(demon) hehe ?
        or we can make our thread a demon:
        thread.setDaemon(true)
        demon thread stop their work when their parent finishes work,
        if thread is not a demon then parent waits for them to finish working

         */
    }
}
