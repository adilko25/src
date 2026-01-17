package menu;

import exception.InvalidInputException;
import model.ClothingItem;
import model.Jacket;
import model.Shirt;

import java.util.ArrayList;
import java.util.Scanner;

public class ClothingMenuManager implements Menu {

    private final ArrayList<ClothingItem> items = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public ClothingMenuManager() {
        // Test data (optional but useful)
        try {
            items.add(new Shirt(1, "T-Shirt", "M", 7000, true));
            items.add(new Jacket(2, "Winter Jacket", "L", 25000, true));
        } catch (InvalidInputException e) {
            System.out.println("Test data error: " + e.getMessage());
        }
    }

    @Override
    public void displayMenu() {
        System.out.println("\n=== CLOTHING STORE SYSTEM (Week 6) ===");
        System.out.println("1. Add Shirt");
        System.out.println("2. Add Jacket");
        System.out.println("3. View All Items (Polymorphic)");
        System.out.println("4. Demonstrate Polymorphism (display())");
        System.out.println("5. Apply Discount to Item");
        System.out.println("6. View Jackets Only (instanceof)");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1 -> addShirt();
                    case 2 -> addJacket();
                    case 3 -> viewAllItems();
                    case 4 -> demonstratePolymorphism();
                    case 5 -> applyDiscountToItem();
                    case 6 -> viewJacketsOnly();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid choice.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a number (e.g., 1, 2, 3).");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
        System.out.println("Goodbye!");
    }

    private void addShirt() {
        try {
            System.out.println("\n--- ADD SHIRT ---");
            int id = readInt("Item ID: ");
            String name = readString("Name: ");
            String size = readString("Size: ");
            double price = readDouble("Price: ");
            boolean hasPrint = readBoolean("Has print? (true/false): ");

            items.add(new Shirt(id, name, size, price, hasPrint));
            System.out.println("Shirt added!");
        } catch (InvalidInputException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }

    private void addJacket() {
        try {
            System.out.println("\n--- ADD JACKET ---");
            int id = readInt("Item ID: ");
            String name = readString("Name: ");
            String size = readString("Size: ");
            double price = readDouble("Price: ");
            boolean hasHood = readBoolean("Has hood? (true/false): ");

            items.add(new Jacket(id, name, size, price, hasHood));
            System.out.println("Jacket added!");
        } catch (InvalidInputException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }

    private void viewAllItems() {
        if (items.isEmpty()) {
            System.out.println("No items found.");
            return;
        }
        for (ClothingItem item : items) {
            System.out.println(item);
        }
    }

    private void demonstratePolymorphism() {
        System.out.println("\n--- POLYMORPHISM DEMO: display() ---");
        for (ClothingItem item : items) {
            item.display(); // overridden display() runs depending on real type
        }
    }

    private void viewJacketsOnly() {
        System.out.println("\n--- JACKETS ONLY ---");
        int count = 0;
        for (ClothingItem item : items) {
            if (item instanceof Jacket) {
                count++;
                System.out.println(count + ". " + item);
            }
        }
        if (count == 0) System.out.println("No jackets found.");
    }

    private void applyDiscountToItem() {
        if (items.isEmpty()) {
            System.out.println("No items to discount.");
            return;
        }

        int id = readInt("Enter item ID to discount: ");
        double percent = readDouble("Discount percent (0-100]: ");

        ClothingItem found = null;
        for (ClothingItem item : items) {
            if (item.getItemId() == id) {
                found = item;
                break;
            }
        }

        if (found == null) {
            System.out.println("Item not found.");
            return;
        }

        found.applyDiscount(percent); // interface method
        System.out.println("Discount applied. New item:");
        found.display();
    }

    private int readInt(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine().trim());
    }

    private double readDouble(String prompt) {
        System.out.print(prompt);
        return Double.parseDouble(scanner.nextLine().trim());
    }

    private boolean readBoolean(String prompt) {
        System.out.print(prompt);
        return Boolean.parseBoolean(scanner.nextLine().trim());
    }

    private String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
