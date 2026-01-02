public class ClothingItem {

    //protected fields
    protected int itemId;
    protected String name;
    protected String size;
    protected double price;

    public ClothingItem(int itemId, String name, String size, double price) {
        this.itemId = itemId;
        setName(name);
        setSize(size);
        setPrice(price);
    }

    // Validation
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            this.name = "Unknown";
        }
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            this.price = 0;
        }
    }

    // Methods to override
    public String getType() {
        return "Clothing Item";
    }

    public void display() {
        System.out.println(name + " (" + size + ") - " + price + " KZT");
    }

    @Override
    public String toString() {
        return "[" + getType() + "] " + name + " | Size: " + size + " | Price: " + price + " KZT";
    }
}

