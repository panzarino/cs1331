public class DobermanTester {
    public static void main(String[] args) {
        Doberman wash = new Doberman("Washington");
        Doberman d = wash;
        System.out.println(d);
        wash.setName("Carlos");
        System.out.println(Doberman.getDobieCount());
    }
}
