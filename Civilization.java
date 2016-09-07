import java.util.Scanner;

public class Civilization {
    private static boolean playing = true;
    private static boolean victory = false;
    private static String input, civilization, name;
    private static String[] cities;
    private static int attacks, happiness, military, technology;
    private static double gold, resources;
    private static Scanner keyboard = new Scanner(System.in);

    // list of valid civilizations
    static final String[] VALID_CIVS =
        {"American", "Zulu", "English", "Chinese"};

    // list of names, corresponds to civs
    static final String[] NAMES =
        {"George Washington", "Shaka", "Queen Elizabeth I", "Wu Zetian"};

    // sets the civilization entered by the user, checks if valid
    public static void setCivilization(String aCivilization) {
        if (!isValidCivilization(aCivilization)) {
            System.out.println(aCivilization + " is not a valid civilization.");
            System.exit(0);
        }
        civilization = aCivilization;
    }

    // checks if the civilization is a valid one
    public static boolean isValidCivilization(String aCivilization) {
        boolean isValid = false;

        for (String s : VALID_CIVS) {
            if (s.equalsIgnoreCase(aCivilization)) {
                isValid = true;
            }
        }

        return isValid;
    }

    // sets name according to civilization (already set)
    public static void setName(String aCivilization) {
        for (int i = 0; i < VALID_CIVS.length; i++) {
            if (VALID_CIVS[i].equalsIgnoreCase(aCivilization)) {
                name = NAMES[i];
            }
        }
    }

    // initializes all player variables
    public static void initialize(String cityName) {
        cities = new String[5];
        cities[0] = cityName;
        attacks = 0;
        gold = 20.5;
        resources = 30.0;
        happiness = 10;
        military = 0;
        technology = 0;
    }

    // checks if the player quits
    public static void hasQuit(String anInput) {
        if (anInput.equalsIgnoreCase("quit")) {
            playing = false;
        } else {
            playing = true;
        }
    }

    // checks if the player has won
    public static void checkVictory() {
        if (technology == 20) {
            victory = true;
            playing = false;
        }

        if (attacks == 10) {
            victory = true;
            playing = false;
        }
    }

    // when the game ends
    public static void gameOver() {
        if (victory) {
            System.out.println("Congratulations! You have won!");
        } else {
            System.out.println("You have lost!");
        }
    }

    // returns a nicely formatted string of cities
    public static String getCities() {
        String cityList = "";
        for (String s : cities) {
            if (s != null) {
                cityList = cityList + s + ", ";
            }
        }

        cityList = cityList.substring(0, cityList.length() - 2);

        return cityList;
    }

    // returns number of cities in cities array
    public static int getLength() {
        int numCities = 0;
        for (String s : cities) {
            if (s != null) {
                numCities++;
            }
        }

        return numCities;
    }

    // updates the player at the beginning of the turn
    public static void printUpdate() {
        // will update the player at the beginning of the turn
        // 2 decimal places
        System.out.printf("%nCities: %s%n", getCities());
        System.out.printf("Attacks: %d%n", attacks);
        System.out.printf("Gold: %.2f%n", gold);
        System.out.printf("Resources: %.2f%n", resources);
        System.out.printf("Happiness: %d%n", happiness);
        System.out.printf("Military: %d%n", military);
        System.out.printf("Technology: %d%n%n", technology);
    }

    // updates resources
    public static void update() {
        if ((roundResources(resources) % 2) == 0) {
            happiness++;
            System.out.println("You gained 1 happiness");
        } else {
            happiness -= 3;
            System.out.println("You lost 3 happiness");
        }

        double resourceGain = 1;
        if (happiness > 20) {
            resourceGain += getLength() * 5;
        }

        resources += resourceGain;
        System.out.printf("You gained %.2f resources%n", resourceGain);

        double goldGain = getLength() * 3;
        gold += goldGain;
        System.out.printf("You gained %.2f gold%n", goldGain);
    }

    // rounds resources so that demolishing works
    public static double roundResources(double r) {
        String s = String.valueOf(r);
        if ((s.substring(s.length() - 3, s.length() - 2)).equals(".5")) {
            r += 0.5;
        }

        return r;
    }

    // settles a city
    public static void addCity() {
        int index = 1;
        if (getLength() < 5) {
            for (int i = 4; i >= 0; i--) {
                if (cities[i] == null) {
                    index = i;
                }
            }
            System.out.print("Name your city: ");
            String cityName = keyboard.nextLine();
            if (containsCity(cityName)) {
                System.out.println("City already exists");
            } else {
                cities[index] = cityName;
                gold -= 15.5;
                System.out.printf("%s was settled! You lose 15.5 gold%n",
                    cityName);
            }
        } else {
            System.out.println("Maximum of 5 cities reached");
        }
    }

    // checks if the cities array contains a certain city
    public static boolean containsCity(String city) {
        boolean answer = false;
        for (int i = 4; i >= 0; i--) {
            if (cities[i] != null && cities[i].equalsIgnoreCase(city)) {
                answer = true;
            }
        }

        return answer;
    }

    // demolishes a city
    public static void demolishCity(String city) {
        boolean demolished = false;
        for (int i = 0; i < cities.length; i++) {
            if (cities[i] != null && cities[i].equalsIgnoreCase(city)) {
                System.out.printf("%s was demolished!"
                    + " You gain 1.5 resources%n", city);
                cities[i] = null;
                resources += 1.5;
                demolished = true;
            }
        }

        if (!demolished) {
            System.out.println("City does not exist!");
        }
    }

    // takes the player command and performs it
    public static int checkInput(String anInput) {
        if (anInput.equalsIgnoreCase("Settle a City")) {
            if (gold >= 15.5) {
                addCity();
            } else {
                System.out.println("Insufficient gold");
            }
        } else if (anInput.equalsIgnoreCase("Demolish a City")) {
            if (getLength() > 1) {
                System.out.printf("%nCities: %s%n", getCities());
                System.out.print("Enter a city to demolish: ");
                String demolish = keyboard.nextLine();
                demolishCity(demolish);
            } else {
                System.out.println("You can not demolish your only city!");
            }
        } else if (anInput.equalsIgnoreCase("Build Militia")) {
            if (gold >= 5.0 && resources >= 3.0) {
                military++;
                gold -= 5.0;
                resources -= 3.0;
                System.out.println("You gain 1 militia and lose 5 gold "
                    + "and 3 resources");
            } else {
                System.out.println("Insufficient gold and/or resources!");
            }
        } else if (anInput.equalsIgnoreCase("Research Technology")) {
            if (gold >= 50.0 && resources >= 2.0) {
                technology++;
            }
        } else if (anInput.equalsIgnoreCase("Attack Enemy City")) {
            if (military >= 6) {
                gold += 10;
                happiness -= 3;
                military -= 6;
                attacks++;
                System.out.println("You attacked an enemy city! You gain 10 "
                    + "gold and lose 6 militia and lose 3 happiness");
            } else {
                System.out.println("Insufficient militia");
            }
        } else if (anInput.equalsIgnoreCase("End Turn")) {
            System.out.println("You skipped your turn");
        } else if (anInput.equalsIgnoreCase("?")) {
            System.out.println("(Not case sensitive) Settle a City, Demolish a"
                + " City, Build Militia, Attack an Enemy City, Research"
                + " Technology, End Turn, Quit");
            return 0;
        }

        return 1;
    }

    public static void main(String[] args) {
        System.out.print("What civilization would you like to lead?: ");
        input = keyboard.next();
        setCivilization(input);
        setName(input);

        keyboard.nextLine();

        System.out.print("Name your city: ");
        input = keyboard.nextLine();
        initialize(input);

        while (playing) {
            printUpdate();
            System.out.printf("(? for Commands) Enter a command, %s: ", name);
            input = keyboard.nextLine();
            if (checkInput(input) == 1) {
                update();
                hasQuit(input);
                checkVictory();
            }
        }

        gameOver();
    }
}
