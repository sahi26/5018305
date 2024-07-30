
/*Linear Search - It is used to check all the elements of an array sequentially until the desired element is found
 Time complexity - O(n) , n= no. of elements in an array.worst case- the algorithm should check the entire array if the element to be found is in the last.
 Binary Search - It  is usually used for sorted array. The algorithm divides the array into halves and access the middle element .If the element to be found is less than that element, then the same process is repeated in the left half of the array , else it is done in the right half of the array.
 Time complexity - O(log n). It reduces the search range by half in each step.
 */
import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSystem {
    public static class Product {
        private int productId;
        private String productName;
        private int quantity;
        private double price;

        public Product(int productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        public int getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Product ID: " + productId + ", Name: " + productName + ", Quantity: " + quantity + ", Price: "
                    + price;
        }
    }

    public static class Inventory {
        private Map<Integer, Product> products;

        public Inventory() {
            products = new HashMap<>();
        }

        public void addProduct(int productId, String productName, int quantity, double price) {
            if (products.containsKey(productId)) {
                System.out.println("Product with ID " + productId + " already exists.");
            } else {
                Product newProduct = new Product(productId, productName, quantity, price);
                products.put(productId, newProduct);
                System.out.println("Product added: " + newProduct);
            }
        }

        public void updateProduct(int productId, String productName, int quantity, double price) {
            if (products.containsKey(productId)) {
                Product product = products.get(productId);
                product.setQuantity(quantity);
                product.setPrice(price);
                System.out.println("Product updated: " + product);
            } else {
                System.out.println("Product with ID " + productId + " not found.");
            }
        }

        public void deleteProduct(int productId) {
            if (products.containsKey(productId)) {
                Product removedProduct = products.remove(productId);
                System.out.println("Product deleted: " + removedProduct);
            } else {
                System.out.println("Product with ID " + productId + " not found.");
            }
        }

        public void displayProducts() {
            if (products.isEmpty()) {
                System.out.println("No products in the inventory.");
            } else {
                for (Product product : products.values()) {
                    System.out.println(product);
                }
            }
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addProduct(1, "Laptop", 50, 1000.00);
        inventory.addProduct(2, "Smartphone", 100, 500.00);

        inventory.displayProducts();

        inventory.updateProduct(2, "Smartphone", 150, 450.00);
        inventory.displayProducts();
    }
}
