import java.util.Scanner;

public class Civilization {
    static boolean playing = true;

    // checks if the player is still playing, quit means quit
    public static boolean stillPlaying(String input) {
        boolean answer;
        if (input.equalsIgnoreCase("quit"))
            answer = false;
        else
            answer = true;
        return answer;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String command;
        
        while(playing) {
            //Your game code here

            //Use this to break out of the game loop.
            //Feel free to move it around.

            System.out.print("Enter a command: ");
            command = keyboard.next();
            playing = stillPlaying(command);
        }
    }
}
