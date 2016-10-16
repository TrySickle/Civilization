package model;

class QinDynasty extends Civilization {
    public QinDynasty() {
        super("Qin Dynasty");
    }

    @Override
    public String explore() {
        int foodFound = getHills().hunt().getHealth();
        getHills().replenishGame();
        makeFood(foodFound);
        return String.format("You explore your surroundings and acquire %d"
            + " foods!", foodFound);
    }

    @Override
    public SiegeUnit getSiegeUnit() {
        return new BlackPowderUnit(this);
    }

    @Override
    public Landmark getLandmark() {
        return new GreatWall(this);
    }
}
