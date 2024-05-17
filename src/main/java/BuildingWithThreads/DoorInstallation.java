package BuildingWithThreads;

public class DoorInstallation extends Thread {
    public final int id = 9;
    private final int days = 1;
    public final int[] connected = {3, 7};
    public boolean finished = false;

    @Override
    public void run() {
        System.out.println("start door installation");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end door installation");
        finished = true;
    }
}