/*
 Big O notation describes the upper bound of an algorithm's time complexity, providing an upper limit on how the runtime grows with the size of the input.
 Time Complexity:

Linear Search:
Best Case: O(1) (Target found at the beginning)
Average Case: O(n) (Target found at some position)
Worst Case: O(n) (Target not found or found at the end)
Binary Search:
Best Case: O(1) (Target found in the middle)
Average Case: O(log n) (Target found after dividing the array multiple times)
Worst Case: O(log n) (Target not found after multiple divisions)
Suitability:

Linear Search: Best used when the array is unsorted or the dataset is small. It does not require sorting but can be slow for large datasets.
Binary Search: Efficient for large, sorted datasets due to its logarithmic time complexity. Requires the array to be sorted but provides fast search performance.
 */

import java.util.Arrays;

public class ECommerceSearch {

    public static class Product {
        private int productId;
        private String productName;
        private String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public int getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public String getCategory() {
            return category;
        }

        @Override
        public String toString() {
            return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
        }
    }

    public static Product linearSearch(Product[] products, String productName) {
        for (Product p : products) {
            if (p.getProductName().equalsIgnoreCase(productName)) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String productName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            int result = products[mid].getProductName().compareToIgnoreCase(productName);

            if (result == 0) {
                return products[mid];
            }
            if (result < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(1, "Laptop", "Electronics"),
                new Product(2, "Smartphone", "Electronics"),
                new Product(3, "Chair", "Furniture"),
                new Product(4, "Table", "Furniture"),
                new Product(5, "Headphones", "Electronics")
        };

        Product foundProduct = linearSearch(products, "Chair");
        if (foundProduct != null) {
            System.out.println("Linear Search : " + foundProduct);
        } else {
            System.out.println("Linear Search - Product not found.");
        }

        Arrays.sort(products, (p1, p2) -> p1.getProductName().compareToIgnoreCase(p2.getProductName()));

        foundProduct = binarySearch(products, "Table");
        if (foundProduct != null) {
            System.out.println("Binary Search : " + foundProduct);
        } else {
            System.out.println("Binary Search - Product not found.");
        }
    }
}
