public class Box<E, V> {
    E data;
    V value;
    public Box(E data, V value) {
        this.data = data;
        this.value = value;
    }
    public E getData() {
        return data;
    }
    public V getValue(){
        return value;
    }
}
