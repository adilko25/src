import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //polymorphism: Parent type list
    private static ArrayList<ClothingItem> items = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Initial data
        items.add(new ClothingItem(1, "Basic Item", "M", 3000));
        items.add(new Shirt(2, "T-Shirt", "L", 7000, true));
        items.add(new Jacket(3, "Winter Jacket", "XL", 25000, true));

        customers.add(new Customer(100, "Alice", "+7701...", 50));
        customers.add(new Customer(101, "Bob", "+7702...", 150));

        boolean running = true;

        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addShirt();
                case 2 -> addJacket();
                case 3 -> viewAllItems();
                case 4 -> demonstratePolymorphism();
                case 5 -> viewJacketsOnly();
                case 0 -> running = false;
                default -> System.out.println("Invalid choice!");
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
        System.out.println("Program ended.");
    }

    private static void displayMenu() {
        System.out.println("\n=== CLOTHING STORE SYSTEM ===");
        System.out.println("1. Add Shirt");
        System.out.println("2. Add Jacket");
        System.out.println("3. View All Items");
        System.out.println("4. Demonstrate Polymorphism");
        System.out.println("5. View Jackets Only");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private static void addShirt() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Size: ");
        String size = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Has print? (true/false): ");
        boolean print = scanner.nextBoolean();
        scanner.nextLine();

        items.add(new Shirt(items.size() + 1, name, size, price, print));
        System.out.println("Shirt added!");
    }

    private static void addJacket() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Size: ");
        String size = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Has hood? (true/false): ");
        boolean hood = scanner.nextBoolean();
        scanner.nextLine();

        items.add(new Jacket(items.size() + 1, name, size, price, hood));
        System.out.println("Jacket added!");
    }

    private static void viewAllItems() {
        for (ClothingItem item : items) {
            System.out.println(item);
        }
    }

    private static void demonstratePolymorphism() {
        System.out.println("\n--- POLYMORPHISM DEMO ---");
        for (ClothingItem item : items) {
            item.display(); // same method, different behavior
        }
    }

    private static void viewJacketsOnly() {
        System.out.println("\n--- JACKETS ONLY ---");
        for (ClothingItem item : items) {
            if (item instanceof Jacket) {
                Jacket jacket = (Jacket) item;
                System.out.println(jacket);
            }
        }
    }
}

