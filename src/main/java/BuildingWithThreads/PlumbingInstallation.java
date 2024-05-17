package BuildingWithThreads;

public class PlumbingInstallation extends Thread {
    public int id = 15;
    private final int days = 2;
    public final int[] connected = {5,11,12};
    public boolean finished = false;
    @Override
    public void run() {
        System.out.println("start plumbing installation");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end plumbing installation");
        finished = true;
    }
}
