package BuildingWithThreads;

public class Project extends Thread {
    public final int id = 1;
    private final int days = 7;
    public final int[] connected = {0};
    public boolean finished = false;
    @Override
    public void run() {
        System.out.println("start project");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end project");
        finished = true;
    }
}