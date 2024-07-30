public class DependencyInjection {

    public static class Customer {
        private int id;
        private String name;
        private String email;

        public Customer(int id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }

    public interface CustomerRepository {
        Customer findCustomerById(int id);
    }

    public static class CustomerRepositoryImpl implements CustomerRepository {
        @Override
        public Customer findCustomerById(int id) {
            return new Customer(id, "Sahi", "sahi@gmail.com");
        }
    }

    public static class CustomerService {
        private final CustomerRepository customerRepository;

        public CustomerService(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }

        public Customer getCustomerById(int id) {
            return customerRepository.findCustomerById(id);
        }
    }

    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);
        Customer customer = customerService.getCustomerById(1);

        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Customer Email: " + customer.getEmail());
    }
}
