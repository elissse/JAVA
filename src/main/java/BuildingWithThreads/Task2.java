package BuildingWithThreads;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Task2 {
    public static boolean check(BuildTask buildTask) {
        for (BuildTask x : buildTask.connected) {
            if (!x.finished) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BuildTask beginConstruction = new BuildTask("begin construction", new ArrayList<>(), 0, 0);
        BuildTask project = new BuildTask("project", new ArrayList<>(List.of(beginConstruction)), 1, 7);
        BuildTask makingWindows = new BuildTask("making windows", new ArrayList<>(List.of(project)), 2, 7);
        BuildTask makingDoors = new BuildTask("making doors", new ArrayList<>(List.of(project)), 3, 7);
        BuildTask buildingFoundation = new BuildTask("building foundation", new ArrayList<>(List.of(project)), 4, 14);
        BuildTask layingCommunications = new BuildTask("laying communications", new ArrayList<>(List.of(buildingFoundation)), 5, 4);
        BuildTask wallConstruction = new BuildTask("wall construction", new ArrayList<>(List.of(buildingFoundation)), 6, 14);
        BuildTask roofConstruction = new BuildTask("roof construction", new ArrayList<>(List.of(wallConstruction)), 7, 3);
        BuildTask windowInstallation = new BuildTask("window installation", new ArrayList<>(List.of(makingWindows, roofConstruction)), 8, 1);
        BuildTask doorInstallation = new BuildTask("door installation", new ArrayList<>(List.of(makingDoors, roofConstruction)), 9, 1);
        BuildTask heatingInstallation = new BuildTask("heating installation", new ArrayList<>(List.of(layingCommunications, windowInstallation, doorInstallation)), 10, 3);
        BuildTask electricalWiring = new BuildTask("electrical wiring", new ArrayList<>(List.of(layingCommunications, roofConstruction)), 11, 3);
        BuildTask wallAndCeilingDecoration = new BuildTask("wall & ceiling decoration", new ArrayList<>(List.of(windowInstallation, doorInstallation, electricalWiring)), 12, 7);
        BuildTask floorFinishing = new BuildTask("floor finishing", new ArrayList<>(List.of(wallAndCeilingDecoration)), 13, 7);
        BuildTask lightingInstallation = new BuildTask("lighting installation", new ArrayList<>(List.of(wallAndCeilingDecoration)), 14, 1);
        BuildTask plumbingInstallation = new BuildTask("plumbing installation", new ArrayList<>(List.of(layingCommunications, electricalWiring, wallAndCeilingDecoration)), 15, 2);
        BuildTask constructionIsFinished = new BuildTask("construction is finished", new ArrayList<>(List.of(beginConstruction, project, makingWindows, makingDoors, buildingFoundation, layingCommunications,
                wallConstruction, roofConstruction, windowInstallation, doorInstallation, heatingInstallation, electricalWiring, wallAndCeilingDecoration, floorFinishing, lightingInstallation, plumbingInstallation)), 16, 0);

        List<BuildTask> construction = new ArrayList<>(List.of(beginConstruction, project, makingWindows, makingDoors, buildingFoundation, layingCommunications,
                wallConstruction, roofConstruction, windowInstallation, doorInstallation, heatingInstallation, electricalWiring, wallAndCeilingDecoration,
                floorFinishing, lightingInstallation, plumbingInstallation, constructionIsFinished));

        Brigade masons = new Brigade("very cool masons", new ArrayList<>(List.of(buildingFoundation, wallConstruction)));
        Brigade carpenters = new Brigade("the best carpenters in the world", new ArrayList<>(List.of(makingWindows, makingDoors, roofConstruction, windowInstallation, doorInstallation)));
        Brigade plumbers = new Brigade("wicked plumbers yes", new ArrayList<>(List.of(layingCommunications, heatingInstallation, plumbingInstallation)));
        Brigade plasterers = new Brigade("really smart plasterers", new ArrayList<>(List.of(wallAndCeilingDecoration, floorFinishing)));
        Brigade electricians = new Brigade("kung fu electricians", new ArrayList<>(List.of(electricalWiring, lightingInstallation)));

        List<Brigade> brigades = new ArrayList<>(List.of(masons, carpenters, plumbers, plasterers, electricians));

        while (true) {
            Stack<BuildTask> process = new Stack<>();
            for (int i = 0; i < 16; i++) {
                if (!construction.get(i).finished & check(construction.get(i))) process.add(construction.get(i));
            }
            long start = System.nanoTime();
            process.forEach(Thread::start);
            process.forEach(thread -> {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            long end = System.nanoTime();
            if (!process.empty() && !process.get(0).equals(project)) {
                process.stream().map(x -> x.id).forEach(x -> System.out.print(x + " "));
                System.out.println((end - start) / 1000000000);
                for (Brigade brigade : brigades) {
                    boolean flag = true;
                    for (BuildTask buildTask : process) {
                        if (brigade.workload.contains(buildTask)) {
                            flag = false;
                            brigade.howLong += buildTask.days;
                        }
                    }
                    if (flag && !brigade.done) {
                        brigade.playingDomino += (end - start) / 1000000000;
                    } else if (!brigade.done & brigade.howLong > 0) {
                        brigade.playingDomino += (end - start) / 1000000000 - brigade.howLong;
                        System.out.println(brigade.name + " " + brigade.howLong);
                    }
                    brigade.howLong = 0;
                    boolean check = false;
                    for (BuildTask bd : brigade.workload) {
                        if (!bd.finished) {
                            check = true;
                        }
                    }
                    if (!check) {
                        brigade.done = true;
                    }
                }
            }
            if (process.empty()) break;
        }
        for (Brigade brigade : brigades) {
            System.out.println(brigade.name + " " + brigade.playingDomino);
        }

    }
}
