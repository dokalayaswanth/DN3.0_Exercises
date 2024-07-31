class Student {
    private String name;
    private int id;
    private String grade;

    public Student(String name, int id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

class StudentView {
    public void displayStudentDetails(String name, int id, String grade) {
        System.out.println("Student: ");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Grade: " + grade);
    }
}

class StudentController {
    private Student student;
    private StudentView view;

    public StudentController(Student student, StudentView view) {
        this.student = student;
        this.view = view;
    }

    public void setStudentName(String name) {
        student.setName(name);
    }

    public String getStudentName() {
        return student.getName();
    }

    public void setStudentId(int id) {
        student.setId(id);
    }

    public int getStudentId() {
        return student.getId();
    }

    public void setStudentGrade(String grade) {
        student.setGrade(grade);
    }

    public String getStudentGrade() {
        return student.getGrade();
    }

    public void updateView() {
        view.displayStudentDetails(student.getName(), student.getId(), student.getGrade());
    }
}

public class MVCPattern {
    public static void main(String[] args) {
        Student student = new Student("John Doe", 1, "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        controller.updateView();

        controller.setStudentName("Jane Doe");
        controller.setStudentId(2);
        controller.setStudentGrade("B");

        controller.updateView();
    }
}
