package eticaret;

// Main Class: User
public class User {
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}

// Subclass: Customer
class Customer extends User {
    private Cart cart;

    public Customer(String name, String email, String password) {
        super(name, email, password);  // Calls the constructor of the main class
        this.cart = new Cart();
    }

    public Cart getCart() {
        return cart;
    }

    public void addToCart(Product product) {
        cart.addProduct(product);
    }
}

// Subclass: Admin
class Admin extends User {

    public Admin(String name, String email,String password) {
        super(name, email, password); // Calls the constructor of the main class
    }

    public void addProduct(Product product) {
        System.out.println("Product " + product.getName() + " added to the store.");
    }

    public void removeProduct(Product product) {
        System.out.println("Product " + product.getName() + " removed from the store.");
    }
}

