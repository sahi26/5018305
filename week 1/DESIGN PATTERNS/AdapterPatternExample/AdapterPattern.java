public class AdapterPattern {

    public interface PaymentProcessor {
        void processPayment(double amt);
    }

    public static class Gpay {
        public void send(double amt) {
            System.out.println("Paying " + amt + " through Gpay");
        }
    }

    public static class Paypal {
        public void makePay(double amt) {
            System.out.println("Paying " + amt + " through Paypal");
        }
    }

    public static class Phonepe {
        public void debit(double amt) {
            System.out.println("Paying " + amt + " through Phonepe");
        }
    }

    public static class GpayProcessor implements PaymentProcessor {
        private Gpay gpay;

        public GpayProcessor(Gpay gpay) {
            this.gpay = gpay;
        }

        @Override
        public void processPayment(double amt) {
            gpay.send(amt);
        }
    }

    public static class PaypalProcessor implements PaymentProcessor {
        private Paypal paypal;

        public PaypalProcessor(Paypal paypal) {
            this.paypal = paypal;
        }

        @Override
        public void processPayment(double amt) {
            paypal.makePay(amt);
        }
    }

    public static class PhonepeProcessor implements PaymentProcessor {
        private Phonepe phonepe;

        public PhonepeProcessor(Phonepe phonepe) {
            this.phonepe = phonepe;
        }

        @Override
        public void processPayment(double amt) {
            phonepe.debit(amt);
        }
    }

    public static void main(String[] args) {

        Gpay gpay = new Gpay();
        Paypal paypal = new Paypal();
        Phonepe phonepe = new Phonepe();

        PaymentProcessor gPayProcessor = new GpayProcessor(gpay);
        PaymentProcessor paypalProcessor = new PaypalProcessor(paypal);
        PaymentProcessor phonepeProcessor = new PhonepeProcessor(phonepe);

        gPayProcessor.processPayment(100.23);
        paypalProcessor.processPayment(200.45);
        phonepeProcessor.processPayment(300.67);
    }
}
