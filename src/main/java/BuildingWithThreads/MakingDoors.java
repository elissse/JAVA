package BuildingWithThreads;

public class MakingDoors extends Thread {
    public final int id = 3;
    private final int days = 7;
    public final int[] connected = {1};
    public boolean finished = false;

    @Override
    public void run() {
        System.out.println("start making doors");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end making doors");
        finished = true;
    }
}