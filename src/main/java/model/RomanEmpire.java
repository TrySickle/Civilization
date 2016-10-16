package model;

class RomanEmpire extends Civilization {
    public RomanEmpire() {
        super("Roman Empire");
    }

    @Override
    public String explore() {
        int foundResources = getHills().mineCoal();
        produceResources(foundResources);
        return String.format("You explore your surroundings and acquire %d"
            + " resources!", foundResources);
    }

    @Override
    public MeleeUnit getMeleeUnit() {
        return new LegionUnit(this);
    }

    @Override
    public Landmark getLandmark() {
        return new Coliseum(this);
    }
}
