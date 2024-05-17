package BuildingWithThreads;

import java.util.ArrayList;
import java.util.List;

public class BeginTheWorks extends Thread {
    public final int id = 0;
    public final int[] connected = {};
    public final int days = -1;
    public boolean finished = false;


    @Override
    public void run() {
        System.out.println("start begin the works");
        System.out.println("end begin the works");
        finished = true;
    }
}