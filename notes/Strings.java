public class Strings {
    public static void main(String[] args) {
        String name = "Georgia Tech";
        String name2 = new String("Georgia Tech");
        String name3;
        name3 = "Georgia Tech";
        String name4 = name + name2 + name3;
        String name5 = name4 + 42;
        System.out.println(name);
        System.out.println(name2);
        System.out.println(name3);
        System.out.println(name4);
        System.out.println(name5);

        // Strings are immutable

        name = "Tech";

        String shortname = name.substring(0, 3);
        System.out.println(shortname);

        int place = name.indexOf('e');
        System.out.println(place);

        name = name.toUpperCase();
        System.out.println(name);

        System.out.println("cat".compareTo("CAT"));

        String empty = "";
        System.out.println(empty.length());
        String emptyalso = null;
        System.out.println(emptyalso);
    }
}
