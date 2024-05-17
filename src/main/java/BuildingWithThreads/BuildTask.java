package BuildingWithThreads;

import java.util.List;

public class BuildTask extends Thread {
    public String name;
    public List<BuildTask> connected;
    public int id;
    public int days;
    public boolean finished;

    BuildTask(String name, List<BuildTask> connected, int id, int days) {
        this.name = name;
        this.connected = connected;
        this.id = id;
        this.days = days;
        this.finished = false;
    }


    @Override
    public void run() {
        System.out.println("start " + name);
        try {
            Thread.sleep(1000L * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end "+name);
        finished = true;
    }
}
