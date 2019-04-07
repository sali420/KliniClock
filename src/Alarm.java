import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.time.LocalTime;

public class Alarm implements Runnable {

    private final File dingWav = new File("C:\\Users\\niigga\\Desktop\\eclipse\\FirstJava\\audio\\stopwatchding.WAV");
    private final Menu menu = new Menu();

    private LocalTime setTime;

    Alarm(LocalTime setTime) {
        this.setTime = setTime;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(10000);
            System.out.println("Current system time: " + LocalTime.now());
            if (setTime.getHour() == LocalTime.now().getHour() && setTime.getMinute() == LocalTime.now().getMinute()) {
                System.out.println("ALARM HAS FINISHED");
                playSound(dingWav);
                menu.mainMenu();

            } else {
                run();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
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
