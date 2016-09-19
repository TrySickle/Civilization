import java.util.Random;

public class Population {
    private int warriors;
    private int civilians;
    private int happiness;

    private static Random rand = new Random();

    public Population() {
        // how many????
        warriors = 0;
        civilians = 0;
        happiness = 0;
    }

    public int getCivilians() {
        return civilians;
    }

    public int getWarriors() {
        return warriors;
    }

    public void setWarriors(int warriors) {
        this.warriors = warriors;
    }

    public boolean canWork(int requiredWorkers) {
        if (civilians >= requiredWorkers) {
            return true;
        } else {
            return false;
        }
    }

    public boolean canBattle() {
        if (warriors > rand.nextInt(100)) {
            warriors -= rand.nextInt(20);
            return true;
        }
        return false;
    }

    public void increaseHappiness(int amount) {
        happiness += amount;
    }

    public void decreaseHappiness(int amount) {
        if (happiness - amount >= 0) {
            happiness -= amount;
        }
    }

    public Game hunt(Hills hills) {
        return hills.hunt();
    }

    public Fish fish(River river) {
        return river.getFish();
    }

    public boolean canCook(Game game, CoalMine coalMine) {
        if (coalMine.getCoal() / (coalMine.getBurnCost() * 4) > 0) {
            for (int i = 0; i < 4; i++) {
                coalMine.burn();
            }

            warriors += 40;
            civilians += 60;
            return true;
        } else {
            return false;
        }
    }

    public boolean canCook(Fish fish, CoalMine coalMine) {
        if (coalMine.getCoal() / (coalMine.getBurnCost() * 4) > 0) {
            for (int i = 0; i < 4; i++) {
                coalMine.burn();
            }

            warriors += 10;
            civilians += 15;
            return true;
        } else {
            return false;
        }
    }
}
