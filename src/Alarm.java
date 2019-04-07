import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalTime;
import java.util.Date;

public class Alarm implements Runnable {

    private final File dingWav = new File("C:\\Users\\niigga\\Desktop\\eclipse\\FirstJava\\audio\\stopwatchding.WAV");
    private final Menu menu = new Menu();
    private final SimpleDateFormat _24hrSDF = new SimpleDateFormat("hh:mm");
    private final SimpleDateFormat _12hrSDF = new SimpleDateFormat("hh:mm");
    private Date curTime;
    private Date setTime;

    Alarm(String inpStr) {
        try {
            setTime = _12hrSDF.parse(inpStr);
            System.out.println(_12hrSDF.format(setTime));
        }
        catch (ParseException e) {System.out.println("error");
        }
    }

    @Override
    public void run() {

        try {
            String amPm;
            Thread.sleep(2000);
            LocalTime _curTime = LocalTime.now();

            int hour = _curTime.getHour(); int minute = +_curTime.getMinute();
            if (hour >= 12) {
                amPm = "am";
            }
            else {
                amPm = "pm";
            }
            String _curTimeStr = (hour + ":" + minute);
            curTime = _24hrSDF.parse(_curTimeStr);
            System.out.println(curTime);
            curTime = _12hrSDF.parse(_curTimeStr  + " " + amPm);
            System.out.println(_12hrSDF.format(curTime));

            String setTimeConv = _12hrSDF.format(setTime); // TODO: find a better fuckin way to do this...
            String curTimeConv = _12hrSDF.format(curTime);
            LocalTime __setTime = LocalTime.parse(setTimeConv);
            LocalTime __curTime = LocalTime.parse(curTimeConv);


            if (__setTime.toString().equalsIgnoreCase(__curTime.toString())) {
                System.out.println("ALARM HAS FINISHED");
                playSound(dingWav);
                menu.mainMenu();
            } else {
                run();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        } catch (ParseException e) {

        }
    }

    public void playSound(File soundFile) {
        try {
            Clip clip  = AudioSystem.getClip(); // make a new clip
            clip.open(AudioSystem.getAudioInputStream(soundFile)); // open audio file
            clip.start(); // blaze it
        }
        catch (Exception e) {
            System.out.println("Error: I dunno lol");
        }
    }
}
