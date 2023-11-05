import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class NauticalFishGame {
    public static int level = 1;
    public static int lowerLevel;
    public static int upperLevel;
    public static int[] levelFish = new int[2];
    public static ArrayList<Integer> score = new ArrayList<>();
    public static String answer = "";

    public static void main(String[] args) {
        gameStart();
    }

    public static void gameStart() {
        if (level <= 100) {
            level1Boat();
            showWater();
            printFish();
            processing();
        } else if (level <= 500) {
            level2Boat();
            showWater();
            printFish();
            processing();
        } else {
            level3Boat();
            showWater();
            printFish();
            processing();
        }
    }

    public static void level1Boat() {
        System.out.printf("%50s\n", "|>");
        System.out.printf("%50s\n", "_|_");
        System.out.printf("%50s%15s\n", "|_/", "lvl. " + level);
    }

    public static void level2Boat() {
        System.out.printf("%50s\n", "|>>");
        System.out.printf("%50s\n", "|_|_|");
        System.out.printf("%50s%15s\n", "|___/", "lvl. " + level);
    }

    public static void level3Boat() {
        System.out.printf("%50s\n", "<<|");
        System.out.printf("%50s\n", "_____|");
        System.out.printf("%50s\n", "|_|_|_/");
        System.out.printf("%50s%15s\n", "|__|__/", "lvl. " + level);
    }

    public static void showWater() {
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
    }

    public static String getFish() {
        String[] fish = new String[5];
        fish[0] = "><(((*>";
        fish[1] = "<@)))><";
        fish[2] = "<*}}}><";
        fish[3] = "><(((o>";
        fish[4] = "><(((o>";
        int i = (int) (4 * Math.random());
        return fish[i];
    }

    public static void printFish() {
        System.out.printf("%35s%35s\n", getFish(), getFish());

        lowerLevel = level - (int) ((level - 1) * Math.random());
        upperLevel = level + (int) (15 * Math.random());

        double predict = Math.random();

        if (predict <= 0.5) {
            levelFish[0] = lowerLevel;
        } else {
            levelFish[0] = upperLevel;
        }
        if (levelFish[0] == lowerLevel) {
            levelFish[1] = upperLevel;
        } else {
            levelFish[1] = lowerLevel;
        }

        System.out.printf("%35s%35s\n", "lvl. " + levelFish[0], "lvl. " + levelFish[1]);
        System.out.printf("%35s%35s\n", "a", "b");
    }

    public static void processing() {
        System.out.println("Choose a fish to catch");

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time is up!");
                timer.cancel(); // Stop the timer task
            }
        };
        timer.schedule(task, 60000);

        answer = JOptionPane.showInputDialog("Choose a fish to catch (a or b)");
        System.out.println(answer);
        System.out.println("Time is up!");
    }
}
