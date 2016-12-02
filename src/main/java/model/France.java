package model;

public class France extends Civilization {
    private Hills hills = new Hills();
    /**
     * Public constructor.
     */
    public France() {
        super("France");
    }

    @Override
    public String explore() {
        int food = hills.hunt().getHealth();
        hills.replenishGame();
        makeFood(food);
        return "You go hunting and get " + food + " food!";
    }

    @Override
    public Landmark getLandmark() {
        return new Eiffel(this);
    }

    @Override
    public RangedUnit getRangedUnit() {
        return new GrenadierUnit(this);
    }
}
