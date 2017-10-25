import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<Integer>();
        System.out.println(myList);
        myList.add(42);
        myList.add(71);
        myList.add(42);
        myList.remove(new Integer(71));
        System.out.println(myList.get(0));

        Box<String, Integer> myBox = new Box<>("Hello", 42);
        System.out.println(myBox.getData());
        System.out.println(myBox.getValue());
    }
}
