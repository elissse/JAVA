package BuildingWithThreads;

public class LightingInstallation extends Thread {
    public int id = 14;
    private final int days = 1;
    public final int[] connected = {12};
    public boolean finished = false;
    @Override
    public void run() {
        System.out.println("start lighting installation");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end lighting installation");
        finished = true;
    }
}