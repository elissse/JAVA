package BuildingWithThreads;

public class RoofConstruction extends Thread {
    public final int id = 7;
    private final int days = 3;
    public final int[] connected = {6};
    public boolean finished = false;
    @Override
    public void run() {
        System.out.println("start roof construction");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end roof construction");
        finished = true;
    }
}