package TImerTasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskMain {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        AlarmClock alarmClock = new AlarmClock(new File("D:\\JetBrains\\IdeaProjects\\JAVA\\src\\main\\java\\TImerTasks\\when do i need to wake uppp"), "D:\\JetBrains\\IdeaProjects\\JAVA\\src\\main\\java\\TImerTasks\\alarmSound.wav");
        alarmClock.on();

//
//        TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("hi i'm timer task yay");
//            }
//        };
//        Timer timer = new Timer();
//        System.out.println("planning execution of task");
//       // timer.schedule(task, 3000);
//        Date time = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse("11.05.2024 12:29:05");
//        timer.schedule(task, time);
//        //timer.cancel();
    }
}
