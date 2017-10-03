public abstract class Animal {
    private String name;
    private int age;
    private String sound;

    public Animal(String name, int age, String sound) {
        this.name = name;
        this.age = age;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSound() {
        return sound;
    }

    public String toString() {
        return name + " that is " + age + " years old makes the sound " + sound;
    }

    public abstract String makeNoise();
}
