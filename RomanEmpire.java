import java.util.Scanner;

public class RomanEmpire {
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

    public RomanEmpire() {
        hills = new Hills();
        System.out.println("What would you like to name your river?");
        String riverName = scan.next();
        river = new River(riverName);
        settlements = new Settlement[10];
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

    public boolean buildAqueduct(Settlement settlement) {
        if (settlement.build(treasury.getCoins(), population, 250, 30)) {
            treasury.spend(250);
            technology.increaseExperience(10);
            return true;
        } else {
            return false;
        }
        // cost 500 coins, 100 civilians
        // increase 10 experienceLevel
        // return true/false
    }

    public boolean buildBathHouse(Settlement settlement) {
        if (settlement.build(treasury.getCoins(), population, 110, 20)) {
            treasury.spend(110);
            technology.increaseExperience(10);
            return true;
        } else {
            return false;
        }
        // cost 50 coins, 10 civilians
        // increase 10 experienceLevel
        // return true/false
    }

    public boolean buildVilla(Settlement settlement) {
        if (settlement.build(treasury.getCoins(), population, 80, 15)) {
            treasury.spend(80);
            technology.increaseExperience(5);
            return true;
        } else {
            return false;
        }
        // cost 50 coins, 10 civilians
        // increase 10 experienceLevel
        // return true/false
    }

    public void studyPhilosophy() {
        technology.philosophize();
        population.decreaseHappiness(10);
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
