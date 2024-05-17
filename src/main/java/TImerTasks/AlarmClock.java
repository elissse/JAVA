package TImerTasks;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AlarmClock {
    private List<Date> wakeUp = new ArrayList<>();
    private File wav;

    AlarmClock(File file, String alarm) throws FileNotFoundException, ParseException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            Date time = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(scanner.nextLine());
            wakeUp.add(time);
        }
        this.wav = new File(alarm);
    }

    public void on() throws ParseException {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                playWavFromFile(wav);
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, wakeUp.get(0));
    }

    public static void playWavFromFile(File soundFile) {
        SourceDataLine clipSDL = null;
        byte[] b = new byte[2048];
        try (AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);) {
            AudioFormat af = ais.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, af);
            if (AudioSystem.isLineSupported(info)) {
                clipSDL = (SourceDataLine) AudioSystem.getLine(info);
                clipSDL.open(af);
                clipSDL.start();
                int num = 0;
                while ((num = ais.read(b)) != -1)
                    clipSDL.write(b, 0, num);
                clipSDL.drain();
//                ais.close();
//                Thread.sleep(clipSDL.getMicrosecondLength()/1000);
                clipSDL.stop();
                clipSDL.close();
            } else {
                System.out.println("Format " + soundFile.getName() + " not support!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
