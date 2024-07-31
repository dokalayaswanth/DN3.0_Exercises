import java.util.*;

class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  "employeeId=" + employeeId +
                ", name=" + name +
                ", position=" + position  +
                ", salary=" + salary;
    }
}

public class EmployeeManagement {
    private Employee[] employees;
    private int size;

    public EmployeeManagement(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size] = employee;
            size++;
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[size - 1] = null;
                size--;
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EmployeeManagement ems = new EmployeeManagement(10); // Capacity of 10

        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Traverse Employees");
            System.out.println("5. Exit");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Enter Employee ID:");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter Name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter Position:");
                    String position = scanner.nextLine();
                    System.out.println("Enter Salary:");
                    double salary = Double.parseDouble(scanner.nextLine());
                    ems.addEmployee(new Employee(id, name, position, salary));
                    break;
                case 2:
                    System.out.println("Enter Employee ID to search:");
                    int searchId = Integer.parseInt(scanner.nextLine());
                    Employee employee = ems.searchEmployee(searchId);
                    if (employee != null) {
                        System.out.println("Employee found: " + employee);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter Employee ID to delete:");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    ems.deleteEmployee(deleteId);
                    break;
                case 4:
                    ems.traverseEmployees();
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
