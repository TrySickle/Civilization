package model;

class SettlerUnit extends Unit implements Convertable {
    private String townName;

    public SettlerUnit(Civilization owner, String townName) {
        super(owner);
        this.townName = townName;
    }

    @Override
    public Building convert() {
        getOwner().incrementNumSettlements();
        return getOwner().getSettlement(townName);
    }

    @Override
    public boolean canConvert(TileType type) {
        return type == TileType.PLAINS;
    }

    public String getTownName() {
        return townName;
    }

    @Override
    public char symbol() {
        return 's';
    }

    @Override
    public String toString() {
        return String.format("Settlers of %s. %s", getTownName(),
            super.toString());
    }
}
