import java.util.Scanner;

public class Desert {
    private Scanner scan = new Scanner(System.in);

    public int findTreasure() {
        // YOUR CODE HERE
        // A valid treasure trove must be greater than 0
        return -1;
    }

    public boolean lost() {
        System.out.println("You have gotten lost! Press 1 to try escaping the"
            + " Desert.\nHopefully you can make it out alive.");
        int move = scan.nextInt();
        return (move == 1) ? false : true;
    }
}