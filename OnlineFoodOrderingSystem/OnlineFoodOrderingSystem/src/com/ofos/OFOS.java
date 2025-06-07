package com.ofos;
import java.util.*;

class FoodItem {
    int id;
    String name;
    double price;

    public FoodItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class Order {
    List<FoodItem> cart = new ArrayList<>();
    String specialInstructions = "";
    final double TAX_RATE = 0.05; // 5%
    final double DELIVERY_CHARGE = 30.0;

    public void addToCart(FoodItem item) {
        cart.add(item);
        System.out.println(item.name + " added to cart.");
    }

    public double calculateTotal() {
        double subtotal = 0.0;
        for (FoodItem item : cart) {
            subtotal += item.price;
        }
        double tax = subtotal * TAX_RATE;
        return subtotal + tax + DELIVERY_CHARGE;
    }

    public void setSpecialInstructions(String instructions) {
        this.specialInstructions = instructions;
    }

    public void printInvoice() {
        System.out.println("\n---- Your Order ----");
        for (FoodItem item : cart) {
            System.out.println(item.name + " - ₹" + item.price);
        }
        System.out.println("Special Instructions: " + (specialInstructions.isEmpty() ? "None" : specialInstructions));
        System.out.println("Delivery Charge: ₹" + DELIVERY_CHARGE);
        System.out.printf("Total with tax (5%%): ₹%.2f\n", calculateTotal());
    }
}

public class OFOS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<FoodItem> menu = Arrays.asList(
            new FoodItem(1, "Burger", 99.0),
            new FoodItem(2, "Pizza", 199.0),
            new FoodItem(3, "Fries", 59.0),
            new FoodItem(4, "Coke", 39.0),
            new FoodItem(5, "Ice Cream", 79.0)
        );

        Order order = new Order();
        int choice;

        System.out.println("=== Welcome to QuickEats ===");

        do {
            System.out.println("\nMenu:");
            for (FoodItem item : menu) {
                System.out.println(item.id + ". " + item.name + " - ₹" + item.price);
            }
            System.out.print("Enter item number to add to cart (0 to finish): ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= menu.size()) {
                order.addToCart(menu.get(choice - 1));
            } else if (choice != 0) {
                System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        scanner.nextLine(); // Consume newline
        System.out.print("Enter any special instructions (press Enter to skip): ");
        String instructions = scanner.nextLine();
        order.setSpecialInstructions(instructions);

        order.printInvoice();

        System.out.println("Thank you for ordering with QuickEats!");
        scanner.close();
    }
}

