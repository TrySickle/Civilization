public class Strategy {
    private int strategyLevel;
    private static final int BATTLE_INCREASE = 10;
    private static final int SIEGE_INCREASE = 40;
    private boolean conqueredTheWorld;

    public Strategy() {
        strategyLevel = 0;
        conqueredTheWorld = false;
    }

    public void battle() {
        strategyLevel += BATTLE_INCREASE;
    }

    public void siege() {
        strategyLevel += SIEGE_INCREASE;
    }

    public boolean conqueredTheWorld() {
        if (strategyLevel > 180) {
            conqueredTheWorld = true;
        }

        return conqueredTheWorld;
    }

    public int getStrategyLevel() {
        return strategyLevel;
    }
}
