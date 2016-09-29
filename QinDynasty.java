import java.util.Scanner;

public class QinDynasty {
    private Hills hills;
    private River river;
    private Settlement[] settlements;
    private int settlementNum;
    private Population population;
    private Strategy strategy;
    private Technology technology;
    private Treasury treasury;
    private CoalMine coalMine;

    private static Scanner scan = new Scanner(System.in);

    public QinDynasty() {
        hills = new Hills();
        river = new River();
        settlements = new Settlement[10];
        settlementNum = 0;
        population = new Population();
        strategy = new Strategy();
        technology = new Technology();
        treasury = new Treasury();
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

    public boolean buildWall(Settlement settlement) {
        if (settlement.build(treasury.getCoins(), population, 1000, 500)) {
            treasury.spend(1000);
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
        if (settlement.build(treasury.getCoins(), population, 30, 8)) {
            treasury.spend(30);
            technology.increaseExperience(10);
            return true;
        } else {
            return false;
        }
        // cost 50 coins, 10 civilians
        // increase 10 experienceLevel
        // return true/false
    }

    public void establishLegalism() {
        technology.philosophize();
        population.decreaseHappiness(20);
    }

    public Hills getHills() {
        return hills;
    }

    public River getRiver() {
        return river;
    }

    public Settlement[] getSettlements() {
        return settlements;
    }

    public int getNumSettlements() {
        return settlementNum;
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
