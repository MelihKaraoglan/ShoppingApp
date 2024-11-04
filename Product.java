package eticaret;
import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;
    private int stock; 

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int quantity) {
        if (stock >= quantity) {
            stock -= quantity;
        } else {
            System.out.println("Insufficient stock!");
        }
    }

    public boolean isAvailable() {
        return stock > 0;
    }
}

class ProductManager {
    private List<Product> productList; // List for all of the products

    public ProductManager() {
        this.productList = new ArrayList<>();
        initializeProducts();
    }

    private void initializeProducts() {
        productList.add(new Product("Phone", 35000, 8));
        productList.add(new Product("Laptop", 55000, 5));
        productList.add(new Product("Headphones", 4000, 20));
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void displayProducts() {  
        System.out.println("\nProduct List::");
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            System.out.println((i + 1) + ". " + product.getName() + " - " + product.getPrice() + " TL (Stock: " + product.getStock() + ")");
        }
    }

    public void addProduct(String name, double price, int stock) {
        Product newProduct = new Product(name, price, stock);
        productList.add(newProduct);
        System.out.println(name + " was successfully added.");
    }

    public void removeProduct(String name) {
        Product productToRemove = null;
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                productToRemove = product;
                break;
            }
        }

        if (productToRemove != null) {
            productList.remove(productToRemove);
            System.out.println(name + " was successfully removed.");
        } else {
            System.out.println(name + " not found.");
        }
    }

    public Product getProduct(int index) {
        if (index >= 0 && index < productList.size()) {
            return productList.get(index);
        } else {
            System.out.println("Invalid product number.");
            return null;
        }
    }
}




class Cart{

    private List<Product> products;

    public Cart(){
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " added to cart.");
    }

    public void removeProduct(Product product) {
        products.remove(product);
        System.out.println(product.getName() + " removed from cart.");
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

}
