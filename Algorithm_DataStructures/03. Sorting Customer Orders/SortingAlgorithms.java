import java.util.*;

// Order.java
class Order {
    private String orderId;
    private String customerName;
    private double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}


public class SortingAlgorithms {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap orders[j] and orders[j+1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        Order pivot = orders[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (orders[j].getTotalPrice() < pivot.getTotalPrice()) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of orders:");
        int numOrders = Integer.parseInt(scanner.nextLine());

        Order[] orders = new Order[numOrders];

        for (int i = 0; i < numOrders; i++) {
            System.out.println("Enter order ID for order " + (i + 1) + ":");
            String orderId = scanner.nextLine();
            System.out.println("Enter customer name for order " + (i + 1) + ":");
            String customerName = scanner.nextLine();
            System.out.println("Enter total price for order " + (i + 1) + ":");
            double totalPrice = Double.parseDouble(scanner.nextLine());
            orders[i] = new Order(orderId, customerName, totalPrice);
        }

        System.out.println("Choose sorting method (1 for Bubble Sort, 2 for Quick Sort):");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            SortingAlgorithms.bubbleSort(orders);
        } else if (choice == 2) {
            SortingAlgorithms.quickSort(orders, 0, orders.length - 1);
        }

        System.out.println("Sorted orders by total price:");
        for (Order order : orders) {
            System.out.println(order);
        }

        scanner.close();
    }  
}