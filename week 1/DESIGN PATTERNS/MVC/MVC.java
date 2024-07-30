public class MVC {
    public static class Student {
        private String name;
        private int id;
        private int grade;

        public Student(String name, int id, int grade) {
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

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }
    }

    public static class StudentView {
        public void displayStudentDetails(String name, int id, int grade) {
            System.out.println("Student Details:");
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Grade: " + grade);
        }
    }

    public static class StudentController {
        private Student model;
        private StudentView view;

        public StudentController(Student model, StudentView view) {
            this.model = model;
            this.view = view;
        }

        public void setStudentName(String name) {
            model.setName(name);
        }

        public void setStudentId(int id) {
            model.setId(id);
        }

        public void setStudentGrade(int grade) {
            model.setGrade(grade);
        }

        public String getStudentName() {
            return model.getName();
        }

        public int getStudentId() {
            return model.getId();
        }

        public int getStudentGrade() {
            return model.getGrade();
        }

        public void updateView() {
            view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
        }
    }

    public static void main(String[] args) {
        Student student = new Student("Sahi", 123, 90);
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);
        controller.updateView();
        controller.setStudentName("Sahithya");
        controller.setStudentGrade(95);
        controller.updateView();
    }

}
