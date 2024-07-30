/*
 A singly linked list is a linear data structure where each element (node) contains a data part and a reference (or link) to the next node in the sequence. The last node points to null, indicating the end of the list.
 A doubly linked list is similar to a singly linked list but includes an additional reference to the previous node, allowing for traversal in both directions (forward and backward).

 */
public class TaskManagementSystem {

    public static class Task {
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

        public String getTaskName() {
            return taskName;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "Task ID: " + taskId + ", Name: " + taskName + ", Status: " + status;
        }
    }

    public static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    public static class SinglyLinkedList {
        private Node head;

        public void addTask(Task task) {
            Node newNode = new Node(task);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            System.out.println("Task added: " + task);
        }

        public Task searchTask(int taskId) {
            Node current = head;
            while (current != null) {
                if (current.task.getTaskId() == taskId) {
                    return current.task;
                }
                current = current.next;
            }
            return null;
        }

        public void traverseTasks() {
            Node current = head;
            while (current != null) {
                System.out.println(current.task);
                current = current.next;
            }
        }

        public void deleteTask(int taskId) {
            if (head == null) {
                System.out.println("Task not found.");
                return;
            }
            if (head.task.getTaskId() == taskId) {
                head = head.next;
                System.out.println("Task deleted with ID: " + taskId);
                return;
            }
            Node current = head;
            while (current.next != null && current.next.task.getTaskId() != taskId) {
                current = current.next;
            }
            if (current.next == null) {
                System.out.println("Task not found.");
            } else {
                current.next = current.next.next;
                System.out.println("Task deleted with ID: " + taskId);
            }
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList taskList = new SinglyLinkedList();

        taskList.addTask(new Task(1, "Design Database", "Pending"));
        taskList.addTask(new Task(2, "Implement API", "In Progress"));
        taskList.addTask(new Task(3, "Write Tests", "Not Started"));

        System.out.println("All tasks:");
        taskList.traverseTasks();

        Task task = taskList.searchTask(2);
        if (task != null) {
            System.out.println("Task found: " + task);
        } else {
            System.out.println("Task not found.");
        }
        taskList.deleteTask(2);
        System.out.println("Tasks after deletion:");
        taskList.traverseTasks();
    }
}

/*
 * Time Complexity:
 * Add Operation: O(1)
 * Search Operation: O(n)
 * Traverse Operation: O(n)
 * Delete Operation: O(n) in the worst case,
 * Advantages of Linked Lists over Arrays:
 * Dynamic Size
 * Ease of Insertion/Deletion
 * No Wasted Space
 */