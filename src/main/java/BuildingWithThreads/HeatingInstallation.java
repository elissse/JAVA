package BuildingWithThreads;

public class HeatingInstallation extends Thread {
    public final int id = 10;
    private final int days = 3;
    public final int[] connected = {5, 8, 9};
    public boolean finished = false;

    @Override
    public void run() {
        System.out.println("start heating installation");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end heating installation");
        finished = true;
    }
}