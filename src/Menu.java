import java.time.DateTimeException;
import java.time.LocalTime;
import java.util.Scanner;

public class Menu {
    public void mainMenu () {
        LocalTime setTime;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter duration in hh:mm:ss format: ");
        String setTimeStr = scanner.nextLine();
        try {
            setTime = LocalTime.parse(setTimeStr);
            Runnable alarm = new Alarm(setTime);
            alarm.run();
        } catch (DateTimeException e) {
            System.out.println("invalid format.");
        }

        //String blockExit = scanner.nextLine();
    }
}
