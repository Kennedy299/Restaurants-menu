import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantsMenu {

    static ArrayList<String> menuItems = new ArrayList<String>();
    static ArrayList<Double> menuPrices = new ArrayList<Double>();
    static double totalBill = 0.0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // add initial menu items
        menuItems.add("Chapo");
        menuPrices.add(10.0);
        menuItems.add("Rice");
        menuPrices.add(30.0);
        menuItems.add("Coke");
        menuPrices.add(20.0);

        while (true) {
            System.out.println("Welcome to the restaurant!");
            System.out.println("Please select an option:");
            System.out.println("1. View menu");
            System.out.println("2. Add item to menu");
            System.out.println("3. Place order");
            System.out.println("4. View total bill");
            System.out.println("5. Make payment");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewMenu();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    placeOrder();
                    break;
                case 4:
                    viewBill();
                    break;
                case 5:
                    makePayment();
                    break;
                case 6:
                    System.out.println("Thank you for visiting the restaurant!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // view the current menu
    public static void viewMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(menuItems.get(i) + " - $" + menuPrices.get(i));
        }
    }

    // add an item to the menu
    public static void addItem() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the name of the item:");
        String item = sc.nextLine();

        System.out.println("Enter the price of the item:");
        double price = sc.nextDouble();

        menuItems.add(item);
        menuPrices.add(price);

        System.out.println("Item added to menu.");
    }

    // place an order
    public static void placeOrder() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the name of the item:");
        String item = sc.nextLine();

        int index = menuItems.indexOf(item);

        if (index == -1) {
            System.out.println("Item not found on menu.");
        } else {
            System.out.println("Enter the quantity of " + item + ":");
            int quantity = sc.nextInt();

            double price = menuPrices.get(index);
            double subtotal = price * quantity;

            System.out.println("Subtotal: $" + subtotal);
            totalBill += subtotal;
        }
    }

    // view the current total bill
    public static void viewBill() {
        System.out.println("Total bill: $" + totalBill);
    }

    // make a payment
    public static void makePayment() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the amount to pay:");
        double amount = sc.nextDouble();

        if (amount < totalBill) {
            System.out.println("Amount entered is less than total bill.");
        } else {
            System.out.println("Payment successful. Thank you for dining with us!");
            totalBill = 0.0;
        }
    }
}
