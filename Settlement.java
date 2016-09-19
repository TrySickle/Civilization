public class Settlement {
    private String name;
    private Building[] buildings;
    private int numBuildings;

    public Settlement(String name) {
        this.name = name;
        buildings = new Building[10];
        numBuildings = 0;
    }

    public String getName() {
        return name;
    }

    public void addBuilding(Building building) {
        if (numBuildings >= buildings.length) {
            expandSettlement();
        }
        buildings[numBuildings] = building;
        numBuildings++;
    }

    public void expandSettlement() {
        Building[] newBuildings = new Building[buildings.length * 2];

        for (int i = 0; i < buildings.length; i++) {
            newBuildings[i] = buildings[i];
        }

        buildings = newBuildings;
    }

    public boolean build(int allottedMoney, Population population, int cost,
                         int workersRequired) {
        if (cost < allottedMoney && population.canWork(workersRequired)) {
            addBuilding(new Building(cost, workersRequired));
            return true;
        } else {
            return false;
        }
    }
}
