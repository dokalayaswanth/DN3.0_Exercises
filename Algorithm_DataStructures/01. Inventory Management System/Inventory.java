import java.util.HashMap;
import java.util.Scanner;

public class Inventory {
    private HashMap<String, Product> inventory;

    public Inventory() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            System.out.println("Product already exists. Use updateProduct to modify.");
        } else {
            inventory.put(product.getProductId(), product);
            System.out.println("Product added: " + product);
        }
    }

    public void updateProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            inventory.put(product.getProductId(), product);
            System.out.println("Product updated: " + product);
        } else {
            System.out.println("Product not found: " + product.getProductId());
        }
    }

    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            Product removedProduct = inventory.remove(productId);
            System.out.println("Product removed: " + removedProduct);
        } else {
            System.out.println("Product not found: " + productId);
        }
    }

    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    public void listProducts() {
        if (inventory.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            inventory.values().forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        Inventory manager = new Inventory();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nEnter a command (ADD, UPDATE, DELETE, GET, LIST, EXIT):");
            String command = scanner.nextLine().toUpperCase();

            switch (command) {
                case "ADD":
                    System.out.println("Enter product ID:");
                    String addId = scanner.nextLine();
                    System.out.println("Enter product name:");
                    String addName = scanner.nextLine();
                    System.out.println("Enter quantity:");
                    int addQuantity = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter price:");
                    double addPrice = Double.parseDouble(scanner.nextLine());
                    Product addProduct = new Product(addId, addName, addQuantity, addPrice);
                    manager.addProduct(addProduct);
                    break;

                case "UPDATE":
                    System.out.println("Enter product ID:");
                    String updateId = scanner.nextLine();
                    System.out.println("Enter product name:");
                    String updateName = scanner.nextLine();
                    System.out.println("Enter quantity:");
                    int updateQuantity = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter price:");
                    double updatePrice = Double.parseDouble(scanner.nextLine());
                    Product updateProduct = new Product(updateId, updateName, updateQuantity, updatePrice);
                    manager.updateProduct(updateProduct);
                    break;

                case "DELETE":
                    System.out.println("Enter product ID:");
                    String deleteId = scanner.nextLine();
                    manager.deleteProduct(deleteId);
                    break;

                case "GET":
                    System.out.println("Enter product ID:");
                    String getId = scanner.nextLine();
                    Product product = manager.getProduct(getId);
                    if (product != null) {
                        System.out.println("Product found: " + product);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case "LIST":
                    manager.listProducts();
                    break;

                case "EXIT":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }

        scanner.close();
        System.out.println("Exiting inventory. Goodbye!");
    }
}
