public interface Adoptable {
    boolean hasBeenAdopted();
    String previousOwner();
    int timeSinceLastOwner();
}
