package model;

import exception.InvalidInputException;

public abstract class ClothingItem implements Discountable {

    protected int itemId;
    protected String name;
    protected String size;
    protected double price;

    public ClothingItem(int itemId, String name, String size, double price) throws InvalidInputException {
        setItemId(itemId);
        setName(name);
        setSize(size);
        setPrice(price);
    }

    // Abstract method (Week 6 requirement)
    public abstract String getType();

    public int getItemId() { return itemId; }
    public String getName() { return name; }
    public String getSize() { return size; }
    public double getPrice() { return price; }

    // ALL setters throw exceptions (no warning prints)
    public void setItemId(int itemId) throws InvalidInputException {
        if (itemId <= 0) throw new InvalidInputException("Item ID must be positive.");
        this.itemId = itemId;
    }

    public void setName(String name) throws InvalidInputException {
        if (name == null || name.trim().isEmpty())
            throw new InvalidInputException("Name cannot be empty.");
        this.name = name.trim();
    }

    public void setSize(String size) throws InvalidInputException {
        if (size == null || size.trim().isEmpty())
            throw new InvalidInputException("Size cannot be empty.");
        this.size = size.trim().toUpperCase();
    }

    public void setPrice(double price) throws InvalidInputException {
        if (price < 0) throw new InvalidInputException("Price cannot be negative.");
        this.price = price;
    }

    // Extra interface method implementation
    @Override
    public void applyDiscount(double percent) {
        if (percent <= 0 || percent > 100) {
            throw new IllegalArgumentException("Discount must be in range (0, 100].");
        }
        this.price = this.price * (1 - percent / 100.0);
    }

    // Polymorphic method to demonstrate behavior
    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "[" + getType() + "] ID: " + itemId + " | " + name +
                " | Size: " + size + " | Price: " + price + " KZT";
    }
}
