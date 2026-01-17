package model;

import exception.InvalidInputException;

public class Jacket extends ClothingItem {

    private boolean hasHood;

    public Jacket(int itemId, String name, String size, double price, boolean hasHood)
            throws InvalidInputException {
        super(itemId, name, size, price);
        this.hasHood = hasHood;
    }

    @Override
    public String getType() {
        return "Jacket";
    }

    public boolean hasHood() {
        return hasHood;
    }

    @Override
    public void display() {
        System.out.println(toString() + " | Hood: " + (hasHood ? "Yes" : "No"));
    }
}
