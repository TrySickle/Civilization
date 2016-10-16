package model;

class WarChariot extends RangedUnit {
    public WarChariot(Civilization owner) {
        super(owner);
        setBaseEndurance(getBaseEndurance() * 2);
    }

    @Override
    public char symbol() {
        return 'W';
    }

    @Override
    public String toString() {
        return "War Chariot Unit. " + super.toString();
    }
}
