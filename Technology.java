public class Technology {
    private int understanding;
    private int experienceLevel;
    private boolean foundMeaningOfLife;
    private boolean builtWonderOfTheWorld;

    public Technology() {
        understanding = 0;
        experienceLevel = 0;
        foundMeaningOfLife = false;
        builtWonderOfTheWorld = false;
    }

    public void philosophize() {
        understanding += 25;
    }

    public void improveWriting() {
        understanding += 10;
    }

    public void increaseExperience(int increase) {
        experienceLevel += increase;
    }

    public boolean hasTechnologyWin() {
        if (understanding > 200) {
            foundMeaningOfLife = true;
            return foundMeaningOfLife;
        } else if (experienceLevel > 200) {
            builtWonderOfTheWorld = true;
            return builtWonderOfTheWorld;
        } else {
            return false;
        }
    }

    public int getUnderstanding() {
        return understanding;
    }

    public int getBuildExperience() {
        return experienceLevel;
    }
}
