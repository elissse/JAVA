package BuildingWithThreads;

import java.util.List;

public class Brigade {
    public String name;
    public List<BuildTask> workload;
    public long playingDomino;
    public boolean done;
    public long howLong;

    Brigade(String name, List<BuildTask> workload) {
        this.name = name;
        this.workload = workload;
        this.playingDomino = 0;
        this.done = false;
        this.howLong = 0;
    }

}
