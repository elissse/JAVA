package BuildingWithThreads;

public class MakingWindows extends Thread {
    public final int id = 2;
    private final int days = 7;
    public final int[] connected = {1};
    public boolean finished = false;
    @Override
    public void run() {
        System.out.println("start making windows");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end making windows");
        finished = true;
    }
}