public class Doberman {
    public static final String STD_SIZE = "Large";
    private static int dobieCount = 0;
    private String name;

    public Doberman() {
        this.name = "Doby";
        dobieCount++;
    }

    public Doberman(String name) {
        this.name = name;
        dobieCount++;
    }

    public String toString() {
        return "A doberman named " + this.name + ".";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getDobieCount() {
        return dobieCount;
    }
}
