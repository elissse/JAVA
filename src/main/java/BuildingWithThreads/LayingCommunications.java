package BuildingWithThreads;

public class LayingCommunications extends Thread {
    public final int id = 5;
    private final int days = 4;
    public final int[] connected = {4};
    public boolean finished = false;
    @Override
    public void run() {
        System.out.println("start laying communications");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end laying communications");
        finished = true;
    }
}
