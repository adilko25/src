public class Jacket extends ClothingItem {

    private boolean hasHood;

    public Jacket(int itemId, String name, String size, double price, boolean hasHood) {
        super(itemId, name, size, price);
        this.hasHood = hasHood;
    }

    @Override
    public String getType() {
        return "Jacket";
    }

    @Override
    public void display() {
        System.out.println("Jacket: " + name + " | Hood: " + (hasHood ? "Yes" : "No"));
    }

    // Child-specific method
    public boolean hasHood() {
        return hasHood;
    }
}
