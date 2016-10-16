package model;

class Egypt extends Civilization {
    public Egypt() {
        super("Egypt");
    }

    @Override
    public String explore() {
        int treasureFound = getDesert().findTreasure();
        getTreasury().earn(treasureFound);
        return String.format("You explore your surroundings and acquire %d"
            + " treasure!", treasureFound);
    }

    @Override
    public RangedUnit getRangedUnit() {
        return new WarChariot(this);
    }

    @Override
    public Landmark getLandmark() {
        return new Pyramid(this);
    }
}
