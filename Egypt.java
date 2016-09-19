import java.util.Scanner;

public class Egypt {
    private Desert desert;
    private River river;
    private Settlement[] settlements;
    int settlementNum;
    private Population population;
    private Strategy strategy;
    private Technology technology;
    private Treasury treasury;
    private CoalMine coalMine;

    private static Scanner scan = new Scanner(System.in);

    public Egypt() {
        desert = new Desert();
        System.out.println("What would you like to name your river?");
        String riverName = scan.next();
        river = new River(riverName);
        settlements = new Settlement[/* some number*/5];
        settlementNum = 0;
        population = new Population();
        strategy = new Strategy();
        technology = new Technology();
        treasury = new Treasury(0);
        coalMine = new CoalMine();
    }

    public boolean settle(Settlement settlement) {
        // settle stuff
        if (settlementNum < settlements.length) {
            settlements[settlementNum] = settlement;
            settlementNum++;
            return true;
        } else {
            return false;
        }

    }

    public boolean buildPyramid(Settlement settlement) {
        if (settlement.build(treasury.getCoins(), population, 500, 100)) {
            treasury.spend(500);
            technology.increaseExperience(10);
            return true;
        } else {
            return false;
        }
        // cost 500 coins, 100 civilians
        // increase 10 experienceLevel
        // return true/false
    }

    public boolean buildHouse(Settlement settlement) {
        if (settlement.build(treasury.getCoins(), population, 50, 10)) {
            treasury.spend(50);
            technology.increaseExperience(1);
            return true;
        } else {
            return false;
        }
        // cost 50 coins, 10 civilians
        // increase 10 experienceLevel
        // return true/false
    }

    public void practiceHieroglyphics() {
        technology.improveWriting();
        population.increaseHappiness(10);
    }

    public Desert getDesert() {
        return desert;
    }

    public River getRiver() {
        return river;
    }

    public Settlement[] getSettlements() {
        return settlements;
    }

    public int getNumSettlements() {
        return settlements.length;
    }

    public Population getPopulation() {
        return population;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public Technology getTechnology() {
        return technology;
    }

    public Treasury getTreasury() {
        return treasury;
    }

    public CoalMine getCoalMine() {
        return coalMine;
    }
}