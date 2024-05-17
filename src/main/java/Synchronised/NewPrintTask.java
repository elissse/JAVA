package Synchronised;

public class NewPrintTask implements Runnable {
    private String data;
    private IPrintUtil printUtil;

    NewPrintTask(IPrintUtil printUtil, String data) {
        this.data = data;
        this.printUtil = printUtil;
    }

    @Override
    public void run() {
        printUtil.printSyncBlock(data);
    }
}