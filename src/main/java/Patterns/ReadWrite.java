package Patterns;

import java.io.*;
import java.util.Scanner;

public class ReadWrite {
    private static ReadWrite instance;
    private static String fileName = "D:\\JetBrains\\IdeaProjects\\JAVA\\src\\main\\java\\Patterns\\filefilefile";

    private ReadWrite() {
    } // other classes cannot create instance of this class!

    //if we put synchronised in public static synchronised SingleObj get() then many threads cannot get in this method bad ;(

    public static ReadWrite getInstance() { // проблемы будут когда будет несколько потоков, нужно синхронизировать
        if (instance == null) {
            synchronized (SingletonObj.class) {
                if (instance == null) {
                    instance = new ReadWrite();
                }
            }
        }
        return instance;
    }

    private void write() {
        try (Writer fw = new FileWriter(fileName, true)) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String string = scanner.next() + "\n";
                fw.write(string);
            }
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void read() {
        try (InputStream is = new FileInputStream(fileName)) {
            int b;
            while ((b = is.read()) != -1) {
                System.out.print(b);
                System.out.print(", ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
