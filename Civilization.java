import java.util.Scanner;

public class Civilization {
    static boolean playing = true;
    static String input, civilization, name;
    static String[] cities;
    static int attacks, happiness, military, technology;
    static double gold, resources;

    static final String[] VALID_CIVS =
        {"American", "Zulu", "English", "Chinese"};

    static final String[] NAMES =
        {"George Washington", "Shaka", "Queen Elizabeth I", "Wu Zetian"};

    public static void setCivilization(String aCivilization) {
        if (!isValidCivilization(aCivilization)) {
            System.out.println(aCivilization + " is not a valid civilization.");
            System.exit(0);
        }
        civilization = aCivilization;
    }

    public static boolean isValidCivilization(String civilization) {
        boolean isValid = false;

        for (String s : VALID_CIVS) {
            if (s.equalsIgnoreCase(civilization)) {
                isValid = true;
            }
        }

        return isValid;
    }

    public static void setName(String aCivilization) {
        for (int i = 0; i < VALID_CIVS.length; i++) {
            if (VALID_CIVS[i].equalsIgnoreCase(aCivilization))
                name = NAMES[i];
        }
    }

    // checks if the player is still playing, quit means quit
    public static boolean stillPlaying(String input) {
        boolean answer;

        if (input.equalsIgnoreCase("quit"))
            answer = false;
        else
            answer = true;

        return answer;
    }

    public static void initialize() {
        cities = new String[5];
        attacks = 0;
        gold = 20.5;
        resources = 30.0;
        happiness = 10;
        military = 0;
        technology = 0;

    }

    public static void listCommands() {
        System.out.println("Settle a City, Demolish a City, Build Militia, Research Technology, Attack Enemy City, End Turn");
    }

    public static void update() {
        //will update the player at the beginning of the turn
        //2 decimal places
    }

    public static void test() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("What civilization would you like to lead?: ");
        input = keyboard.next();
        setCivilization(input);
        setName(input);
        initialize();

        while(playing) {
            System.out.print("(? for list of commands) Enter a command: ");
            input = keyboard.next();
            //checkInput(input);
            playing = stillPlaying(input);
            test();
        }
    }
}
