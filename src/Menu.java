import java.time.DateTimeException;
import java.util.Scanner;

public class Menu {
    public void mainMenu () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter duration in hh:mm:ss format: ");
        String inpStr = scanner.nextLine();
        try {
            Runnable alarm = new Alarm(inpStr);
            alarm.run();
        } catch (DateTimeException e) {
            System.out.println("invalid format.");
        }

        //String blockExit = scanner.nextLine();
    }
}
