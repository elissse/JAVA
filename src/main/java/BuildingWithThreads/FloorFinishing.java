package BuildingWithThreads;

public class FloorFinishing extends Thread {
    public int id = 13;
    private final int days = 7;
    public final int[] connected = {12};
    public boolean finished = false;
    @Override
    public void run() {
        System.out.println("start floor finishing");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end floor finishing");
        finished = true;
    }
}