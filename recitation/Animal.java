public class Animal {
    private String name;
    private String sound;
    private String species;
    private int lifeSpan;

    public Animal(String name, String sound, String species, int lifeSpan) {
        this.name = name;
        this.sound = sound;
        this.species = species;
        this.lifeSpan = lifeSpan;
    }

    public Animal(String name, String sound, int lifeSpan) {
        this(name, sound, "Default Species", lifeSpan);
    }

    public String getName() {
        return name;
    }

    public int getLifeSpan() {
        return lifeSpan;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "My " + species + " " + name + " says " + sound;
    }

    public static void main(String[] args) {
        Animal dog = new Animal("Fido", "Woof", "Labrador", 10);
        Animal rhino = new Animal("Will", "Roar", 40);
        System.out.println(dog.getName());
        System.out.println(rhino.getLifeSpan());
        dog.setName("George");
        System.out.println(dog.getName());
        System.out.println(dog);
        System.out.println(rhino);
    }
}
