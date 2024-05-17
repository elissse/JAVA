package BuildingWithThreads;

public class WallAndCeilingDecoration extends Thread {
    private final int id = 12;
    private final int days = 7;
    public final int[] connected = {8,9,11};
    public boolean finished = false;
    @Override
    public void run() {
        System.out.println("start wall and ceiling decoration");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end wall and ceiling decoration");
        finished = true;
    }
}