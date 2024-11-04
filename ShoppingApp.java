package eticaret;
import java.util.Scanner;

public class ShoppingApp {
    private static Scanner scanner = new Scanner(System.in);
    private static ProductManager productManager = new ProductManager();
    private static UserAndAdminList userAndAdminList = new UserAndAdminList();

    public static void main(String[] args) {
        System.out.println("Are you an admin or customer?");
        
        while (true) {
            System.out.print("Enter role (admin/customer) or type 'quit' to exit: ");
            String role = scanner.nextLine();

            if (role.equalsIgnoreCase("quit")) {
                System.out.println("See you later! <3");
                return;
            }
            
            if (role.equalsIgnoreCase("admin") || role.equalsIgnoreCase("customer")) {
                System.out.print("Enter email: ");
                String email = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                if (userAndAdminList.login(email, password, role)) {
                    if (role.equalsIgnoreCase("admin")) {
                        Admin admin = userAndAdminList.getAdminByEmail(email);
                        adminMenu(admin);
                    } else {
                        Customer customer = userAndAdminList.getUserByEmail(email);
                        mainMenu(customer);
                    }
                } else {
                    System.out.println("Invalid email or password. Please try again.");
                }
            } else {
                System.out.println("Invalid role. Please enter 'admin' or 'customer'.");
            }
        }
    }

    public static void adminMenu(Admin admin) {
        System.out.println("\nWelcome to administrator,\nMr. " + admin.getName() + "!");
        System.out.println("What would you like to do today?");
    
        while (true) {
            System.out.println("\n1. Wiew Products");
            System.out.println("2. Add Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Log Out");
            System.out.print("Make your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear the newline character
    
            switch (choice) {
                case 1:
                    productManager.displayProducts();
                    break;
                case 2:
                    System.out.print("Please enter the new Product's name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Please enter the product's price: ");
                    double productPrice = scanner.nextDouble();
                    System.out.print("Please enter the product's stock: ");
                    int productStock = scanner.nextInt();
                    scanner.nextLine(); // Clear the newline character
                    productManager.addProduct(productName, productPrice, productStock);
                    break;
                case 3:
                    System.out.print("Please enter the product name to remove: ");
                    String productToRemove = scanner.nextLine();
                    productManager.removeProduct(productToRemove);
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    public static void mainMenu(Customer customer) {
        System.out.println("\nWelcome, " + customer.getName() + "!");
        
        while (true) {
            System.out.println("\n1. Wiew Products");
            System.out.println("2. Wiew Cart");
            System.out.println("3. Log Out");
            System.out.print("Make your choice: ");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    productManager.displayProducts();
                    selectProduct(customer);
                    break;
                case 2:
                    viewCart(customer);
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void selectProduct(Customer customer) {
        System.out.print("Select the product number to add to the cart: ");
        int productChoice = scanner.nextInt() - 1; // Adjust to list index
    
        Product product = productManager.getProduct(productChoice);
        if (product != null && product.isAvailable()) {
            customer.addToCart(product);
            product.reduceStock(1); // Reduce stock for added product
        } else {
            System.out.println("This product is out of stock..");
        }
    }
    

    public static void viewCart(Customer customer) {
        System.out.println("\nCart Contents:");
        Cart cart = customer.getCart();
        double total = cart.getTotalPrice();
        System.out.println("Total Price: " + total + " TL");
    }
}
