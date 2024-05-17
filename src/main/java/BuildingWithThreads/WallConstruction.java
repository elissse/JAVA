package BuildingWithThreads;

public class WallConstruction extends Thread {
    public final int id = 6;
    private final int days = 14;
    public final int[] connected = {4};
    public boolean finished = false;

    @Override
    public void run() {
        System.out.println("start wall construction");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end wall construction");
        finished = true;
    }
}
