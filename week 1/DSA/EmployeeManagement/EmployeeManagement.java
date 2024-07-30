/*
 Arrays are a contiguous block of memory where elements are stored sequentially. This makes access time O(1) for index-based retrieval. However, arrays have a fixed size, which can be a limitation.
 */
public class EmployeeManagement {

    public static class Employee {
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

        public String getPosition() {
            return position;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
        }
    }

    private Employee[] employees;
    private int size;

    public EmployeeManagement(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(int employeeId, String name, String position, double salary) {
        if (size >= employees.length) {
            System.out.println("Array is full.");
            return;
        }
        employees[size++] = new Employee(employeeId, name, position, salary);
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        if (size == 0) {
            System.out.println("No employees.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(int employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Employee not found.");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[--size] = null;
        System.out.println("Employee with ID " + employeeId + " deleted.");
    }

    public static void main(String[] args) {
        EmployeeManagement em = new EmployeeManagement(5);

        em.addEmployee(1, "Sahithya", "Developer", 70000);
        em.addEmployee(2, "Tinu", "Manager", 90000);
        em.addEmployee(3, "Cara", "Designer", 65000);

        System.out.println("All Employees:");
        em.traverseEmployees();

        Employee e = em.searchEmployee(2);
        if (e != null) {
            System.out.println("\nEmployee found: " + e);
        } else {
            System.out.println("\nEmployee not found.");
        }
        em.deleteEmployee(2);
        System.out.println("\nAfter deletion:");
        em.traverseEmployees();
    }
}
/*
 * Add Operation: O(1)
 * Search Operation: O(n)
 * Traverse Operation: O(n).
 * Delete Operation: O(n)
 * Limitations:
 * Fixed size
 * Inefficiency for frequent insertion/ deletion
 */