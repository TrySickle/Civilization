public class Settlement {
    private String name;
    private Building[] buildings;
    private int numBuildings;

    public Settlement(String name) {
        this.name = name;
        buildings = new Building[5];
        numBuildings = 0;
    }

    public String getName() {
        return name;
    }

    public void addBuilding(Building building) {
        if (numBuildings < buildings.length) {
            buildings[numBuildings] = building;
            numBuildings++;
        }
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
