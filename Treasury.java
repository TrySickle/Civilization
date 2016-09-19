public class Treasury {
    private int coins;

    public Treasury(int coins) {
        this.coins = coins;
    }

    public boolean spend(int cost) {
        if (coins >= cost) {
            coins -= cost;
            return true;
        } else {
            return false;
        }
    }

    public void earn(int coins) {
        this.coins += coins;
    }

    public int getCoins() {
        return coins;
    }
}
