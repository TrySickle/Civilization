package model;

import java.util.Random;

/**
 * represents a FishingShack type of Building on a Tile on the Map
 * @author Ryan Voor
 * @version 3.0
 */
class FishingShack extends Building {
    private SimpleSet<Fish> fish;
    private static Random rand = new Random();

    /**
     * constructs a new FishingShack object with the
     * given Civilization as its owner
     */
    public FishingShack(Civilization owner) {
        super(200, owner, 5, 0, 10, 0, 0, 10);
        fish = new MySet<>();
        invest();
    }

    @Override
    public void invest() {
        replenishFish();
        int foodGeneration = 0;
        int goldGeneration = 0;
        for (Fish f : fish.toArray()) {
            foodGeneration += (int) (f.getHealth() / 2);
            goldGeneration += f.getHealth() - foodGeneration;
        }
        setFoodGeneration(foodGeneration);
        setGoldGeneration(goldGeneration);
    }

    @Override
    public char symbol() {
        return '&';
    }

    /**
     * Returns a random Fish from the FishingShack if there are
     * any Fish in the FishingShack. The Fish that is returned
     * should be removed. Returns null if there
     * are no Fish in the FishingShack.
     * @return the fish removed from the FishingShack
     */
    public Fish getFish() {
        try {
            Fish randomFish = fish.getRandomElement();
            fish.remove(randomFish);
            return randomFish;
        } catch (ElementDoesNotExistException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Puts 5 new Fish into the FishingShack if the FishingShack is
     * empty.
     * Each Fish should be passed 2 random numbers from 0 (inclusive)
     * to 5 (exclusive)
     * Returns true if the FishingShack's Fish were replenished.
     * Returns false if the FishingShack's Fish were not replenished.
     * @return whether the FishingShack's Fish were replenished
     */
    public boolean replenishFish() {
        if (fish.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                while (!fish.add(new Fish(rand.nextInt(5), rand.nextInt(5)))) {
                    System.out.println("");
                }
            }

            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "FishingShack. " + super.toString();
    }
}