import java.util.*;
public class FinancialForecasting {
    public static double recursiveFutureValue(double initialValue, double growthRate, int periods){
        if (periods <= 0) {
            return initialValue;
        } else {
            return calculateFutureValue(initialValue * (1 + growthRate), growthRate, periods - 1);
        }
    }
    public static double calculateFutureValue(double initialValue, double growthRate, int periods) {
        double futureValue = initialValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the initial value:");
        double initialValue = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter the growth rate (as a decimal, e.g., 0.05 for 5%):");
        double growthRate = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter the number of periods (e.g., years):");
        int periods = Integer.parseInt(scanner.nextLine());
        
        System.out.printf("The future value after %d periods using recursive approach is: %.2f%n", periods, recursiveFutureValue(initialValue, growthRate, periods));
        System.out.printf("The future value after %d periods without using recursive approach is: %.2f%n", periods, calculateFutureValue(initialValue, growthRate, periods));

        scanner.close();
    }
}
