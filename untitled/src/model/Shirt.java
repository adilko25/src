package model;

import exception.InvalidInputException;

public class Shirt extends ClothingItem {

    private boolean hasPrint;

    public Shirt(int itemId, String name, String size, double price, boolean hasPrint)
            throws InvalidInputException {
        super(itemId, name, size, price);
        this.hasPrint = hasPrint;
    }

    @Override
    public String getType() {
        return "Shirt";
    }

    public boolean hasPrint() {
        return hasPrint;
    }

    @Override
    public void display() {
        System.out.println(toString() + " | Print: " + (hasPrint ? "Yes" : "No"));
    }
}
