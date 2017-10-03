public class Zoo {
    public static void main(String[] args) {
        Animal a1 = new Dog("Rudy", 3, "Bark", false, true);
        System.out.println(a1);
        System.out.println(a1.makeNoise());
    }
}
