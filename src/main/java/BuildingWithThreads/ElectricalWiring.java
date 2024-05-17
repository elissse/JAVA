package BuildingWithThreads;

public class ElectricalWiring extends Thread {
    public int id = 11;
    private final int days = 3;
    public final int[] connected = {5, 7};
    public boolean finished = false;

    @Override
    public void run() {
        System.out.println("start electrical wiring");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end electrical wiring");
        finished = true;
    }
}