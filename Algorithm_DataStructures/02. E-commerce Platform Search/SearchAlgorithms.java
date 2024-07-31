import java.util.*;

class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}


public class SearchAlgorithms {
    public static int binarySearch(Product[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int compareResult = products[mid].getProductName().compareToIgnoreCase(targetName);

            if (compareResult == 0) {
                return mid;
            } else if (compareResult < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int linearSearch(Product[] products, String targetName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductName().equalsIgnoreCase(targetName)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of products:");
        int numProducts = Integer.parseInt(scanner.nextLine());

        Product[] products = new Product[numProducts];

        for (int i = 0; i < numProducts; i++) {
            System.out.println("Enter product ID for product " + (i + 1) + ":");
            String productId = scanner.nextLine();
            System.out.println("Enter product name for product " + (i + 1) + ":");
            String productName = scanner.nextLine();
            System.out.println("Enter product category for product " + (i + 1) + ":");
            String category = scanner.nextLine();
            products[i] = new Product(productId, productName, category);
        }

        Arrays.sort(products, Comparator.comparing(Product::getProductName));

        System.out.println("Enter product name to search:");
        String target = scanner.nextLine();

        int linearResult = linearSearch(products, target);
        System.out.println("Linear Search result: " + (linearResult >= 0 ? "Found at index " + linearResult : "Not Found"));

        int binaryResult = binarySearch(products, target);
        System.out.println("Binary Search result: " + (binaryResult >= 0 ? "Found at index " + binaryResult : "Not Found"));

        scanner.close();
    }
}
