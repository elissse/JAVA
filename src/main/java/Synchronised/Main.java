package Synchronised;

import ParallelThreadsIGuess.PrintTask;

public class Main {
    public static void main(String[] args) {
        IPrintUtil printUtil = new PrintUtil();
        new Thread(new NewPrintTask(printUtil,"hi hello hey"), "thread 1").start();
        new Thread(new NewPrintTask(printUtil,"hi hello he gdifuhufhuidfhiudhfiuy"), "thread 2").start();
        new Thread(new NewPrintTask(printUtil,"hi hello he fuhodufhodshfohfoy"), "thread 3").start();
    }
}

