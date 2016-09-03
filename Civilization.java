import java.util.Scanner;

public class Civilization {
    static boolean playing = true;
    static boolean victory = false;
    static String input, civilization, name;
    static String[] cities;
    static int attacks, happiness, military, technology;
    static double gold, resources;
    static Scanner keyboard = new Scanner(System.in);

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
        resources += 1;
        if (happiness > 20) {
            resources += getLength() * 5;
        }

        gold += getLength() * 3;

        if ((resources % 2) == 0) {
            happiness++;
        } else {
            happiness -= 3;
        }
    }

    // for random tests
    public static void test() {
        System.out.println(name);
    }

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
            }
        } else {
            System.out.println("Maximum of 5 cities reached");
        }
    }

    public static boolean containsCity(String city) {
        boolean answer = false;
        for (int i = 4; i >= 0; i--) {
            if (cities[i] != null && cities[i].equalsIgnoreCase(city)) {
                answer = true;
            }
        }

        return answer;
    }

    public static void demolishCity(String city) {
        boolean demolished = false;
        for (int i = 0; i < cities.length; i++) {
            if (cities[i] != null && cities[i].equalsIgnoreCase(city)) {
                name = NAMES[i];
                System.out.printf("%s was demolished!", city);
                cities[i] = null;
                resources += 1.5;
                demolished = true;
            }
        }

        if (!demolished) {
            System.out.println("City does not exist!");
        }
    }

    public static void checkInput(String anInput) {
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

        }
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
            System.out.print("Enter a command: ");
            input = keyboard.nextLine();
            checkInput(input);
            update();
            hasQuit(input);
            checkVictory();
        }

        gameOver();
    }
}
