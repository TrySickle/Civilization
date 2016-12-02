package model;

public class England extends Civilization {
    /**
     * Public constructor.
     */
    public England() {
        super("England");
    }

    @Override
    public String explore() {
        this.getTreasury().earn(25);
        return "You got 25 coins!";
    }

    @Override
    public Landmark getLandmark() {
        return new BigBen(this);
    }

    @Override
    public MeleeUnit getMeleeUnit() {
        return new CavalierUnit(this);
    }
}
