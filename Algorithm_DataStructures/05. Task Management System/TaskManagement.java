import java.util.Scanner;

class Task {
    private int taskId;
    private String taskName;
    private String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "taskId=" + taskId +
               ", taskName=" + taskName +
               ", status=" + status;
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskManagement {
    private Node head;

    public TaskManagement() {
        this.head = null;
    }

    public void addTask(Task task) {
        if (searchTask(task.getTaskId()) != null) {
            System.out.println("Task with ID " + task.getTaskId() + " already exists.");
            return;
        }
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public Task searchTask(int taskId) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.getTaskId() == taskId) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.task.getTaskId() == taskId) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.task.getTaskId() != taskId) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Task not found.");
        } else {
            temp.next = temp.next.next;
        }
    }

    public void traverseTasks() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManagement tms = new TaskManagement();

        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Traverse Tasks");
            System.out.println("5. Exit");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Enter Task ID:");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter Task Name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter Task Status:");
                    String status = scanner.nextLine();
                    tms.addTask(new Task(id, name, status));
                    break;
                case 2:
                    System.out.println("Enter Task ID to search:");
                    int searchId = Integer.parseInt(scanner.nextLine());
                    Task task = tms.searchTask(searchId);
                    if (task != null) {
                        System.out.println("Task found: " + task);
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter Task ID to delete:");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    tms.deleteTask(deleteId);
                    break;
                case 4:
                    tms.traverseTasks();
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
