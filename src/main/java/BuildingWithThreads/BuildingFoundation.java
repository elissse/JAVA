package BuildingWithThreads;

import java.util.ArrayList;
import java.util.List;

public class BuildingFoundation extends Thread {
    public int id = 4;
    private int days = 7;
    public final int[] connected = {1};
    public boolean finished = false;

    @Override
    public void run() {
        System.out.println("start building foundation");
        try {
            Thread.sleep(1000*days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end building foundation");
        finished = true;
    }
}
