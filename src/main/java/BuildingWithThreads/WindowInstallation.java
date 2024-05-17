package BuildingWithThreads;

public class WindowInstallation extends Thread {
    public final int id = 8;
    private final int days = 1;
    public final int[] connected = {2, 7};
    public boolean finished = false;

    @Override
    public void run() {
        System.out.println("start window installation");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end window installation");
        finished = true;
    }
}