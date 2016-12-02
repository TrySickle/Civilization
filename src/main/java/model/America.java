package model;

public class America extends Civilization {
    /**
     * Public constructor.
     */
    public America() {
        super("America");
    }

    @Override
    public String explore() {
        this.getTechnology().increaseBuildExperience();
        return "You got 25 Tech Points!";
    }

    @Override
    public Landmark getLandmark() {
        return new Capitol(this);
    }

    @Override
    public HybridUnit getHybridUnit() {
        return new SoldierUnit(this);
    }
}
