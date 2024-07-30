/*
 Bubble Sort is a simple comparison-based algorithm. It repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. The pass through the list is repeated until the list is sorted.
Time Complexity: O(n^2) in the average and worst case. O(n) in the best case

nsertion Sort builds the final sorted array one item at a time. It is much less efficient on large lists than more advanced algorithms such as Quick Sort or Merge Sort.
Time Complexity: O(n^2) in the average and worst case. O(n) in the best case.

Quick Sort is an efficient, in-place sorting algorithm that, on average, makes O(n log n) comparisons to sort n items. It works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot.
Time Complexity: O(n log n) on average and in the best case. O(n^2) in the worst case.

Merge Sort is a stable, comparison-based, divide and conquer algorithm. It divides the unsorted list into n sub-lists, each containing one element, and then repeatedly merges sub-lists to produce new sorted sub-lists until there is only one sub-list remaining.
Time Complexity: O(n log n) in all cases.
 */
public class Sorting {

    public static class Order {
        private int orderId;
        private String customerName;
        private double totalPrice;

        public Order(int orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        public int getId() {
            return orderId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        @Override
        public String toString() {
            return "Order ID: " + orderId + ", Name: " + customerName + ", Price: " + totalPrice;
        }
    }

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
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
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
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
        Order[] orders = {
                new Order(1, "Alice", 250.0),
                new Order(2, "Bob", 150.0),
                new Order(3, "Charlie", 300.0),
        };

        System.out.println("Orders before sorting:");
        for (Order order : orders) {
            System.out.println(order);
        }

        bubbleSort(orders);
        System.out.println("\nOrders after Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }

        quickSort(orders, 0, orders.length - 1);
        System.out.println("\nOrders after Quick Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
/*
 * Bubble Sort: O(n^2) in the worst and average cases due to nested loops. Best
 * case is O(n) if the array is already sorted.
 * Quick Sort: O(n log n) on average and in the best case. The worst case is
 * O(n^2), but this is rare if a good pivot selection strategy is used (e.g.,
 * choosing the median).
 */