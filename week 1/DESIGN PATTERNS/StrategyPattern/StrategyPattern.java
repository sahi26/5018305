public class StrategyPattern {
    public interface PaymentStrategy {
        void pay(double amt);
    }

    public static class CreditCardPayment implements PaymentStrategy {
        @Override
        public void pay(double amt) {
            System.out.println("Paid " + amt + " through credit card");
        }
    }

    public static class PaypalPayment implements PaymentStrategy {
        @Override
        public void pay(double amt) {
            System.out.println("Paid " + amt + " through PayPal");
        }
    }

    public static class PaymentContext {
        private PaymentStrategy paymentStrategy;

        public PaymentContext(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void executePayment(double amt) {
            paymentStrategy.pay(amt);
        }
    }

    public static void main(String[] args) {
        PaymentContext context = new PaymentContext(new CreditCardPayment());

        context.executePayment(153.06);

        context.setPaymentStrategy(new PaypalPayment());
        context.executePayment(6155.0);
    }
}
