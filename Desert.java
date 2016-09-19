import java.util.Scanner;
import java.util.Random;

public class Desert {
    private Scanner scan = new Scanner(System.in);
    private static Random rand = new Random();

    public int findTreasure() {
        // YOUR CODE HERE
        // A valid treasure trove must be greater than 0
        if ((int) (Math.random() * 10) == 0) {
            while (lost()) {
                // checkstyle plz
                System.out.print("");
            }
        }

        return rand.nextInt(500);
    }

    public boolean lost() {
        System.out.println("You have gotten lost! Press 1 to try escaping the"
            + " Desert.\nHopefully you can make it out alive.");
        int move = scan.nextInt();
        return (move == 1) ? false : true;
    }
}
