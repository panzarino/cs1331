public class Dog extends Animal {
    private boolean gotNewspaper;
    private boolean isGoodBoy;

    public Dog(
        String name, int age, String sound,
        boolean gotNewspaper, boolean isGoodBoy
    ) {
        super(name, age, sound);
        this.gotNewspaper = gotNewspaper;
        this.isGoodBoy = isGoodBoy;
    }

    @Override
    public String toString() {
        return super.toString() + " who is a good boy? " + isGoodBoy;
    }

    public boolean getIsGoodBoy() {
        return isGoodBoy;
    }

    public String makeNoise() {
        return getSound() + getSound() + getSound();
    }
}
