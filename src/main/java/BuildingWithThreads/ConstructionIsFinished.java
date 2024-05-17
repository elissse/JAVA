package BuildingWithThreads;

public class ConstructionIsFinished extends Thread {
    public final int id = 16;
    public final int[] connected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    public final int days = -1;
    public boolean finished = false;

    @Override
    public void run() {
        System.out.println("start construction is finished");
        System.out.println("end construction is finished");
        finished = true;
    }
}