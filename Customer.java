public class Customer {

    private int customerId;
    private String name;
    private String phone;
    private int loyaltyPoints;

    public Customer(int customerId, String name, String phone, int loyaltyPoints) {
        this.customerId = customerId;
        setName(name);
        this.phone = phone;
        setLoyaltyPoints(loyaltyPoints);
    }

    public void setName(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name;
        } else {
            this.name = "Unknown"; //test
        }
    }

    public void setLoyaltyPoints(int points) {
        if (points >= 0) {
            this.loyaltyPoints = points;
        } else {
            this.loyaltyPoints = 0;
        }
    }

    public boolean isVIP() {
        return loyaltyPoints > 100;
    }

    @Override
    public String toString() {
        return name + " | Points: " + loyaltyPoints + (isVIP() ? " (VIP)" : "");
    }
}

