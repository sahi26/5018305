public class Decorator {
    public interface Notifier {
        void send(String msg);
    }

    public class EmailNotifier implements Notifier {
        @Override
        public void send(String msg) {
            System.out.println("Sending email: " + msg);
        }
    }

    public abstract class NotifierDecorator implements Notifier {
        protected Notifier wrappedNotifier;

        public NotifierDecorator(Notifier notifier) {
            this.wrappedNotifier = notifier;
        }

        @Override
        public void send(String msg) {
            wrappedNotifier.send(msg);
        }
    }

    public class SMSNotifierDecorator extends NotifierDecorator {
        public SMSNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        @Override
        public void send(String msg) {
            super.send(msg);
            sending(msg);
        }

        private void sending(String msg) {
            System.out.println("Sending SMS: " + msg);
        }
    }

    public class SlackNotifierDecorator extends NotifierDecorator {
        public SlackNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        @Override
        public void send(String msg) {
            super.send(msg);
            mailing(msg);
        }

        private void mailing(String msg) {
            System.out.println("Sending Slack message: " + msg);
        }
    }

    public static void main(String[] args) {
        Decorator decorator = new Decorator();
        Notifier emailNotifier = decorator.new EmailNotifier();
        Notifier smsAndEmail = decorator.new SMSNotifierDecorator(emailNotifier);
        Notifier all = decorator.new SlackNotifierDecorator(smsAndEmail);
        all.send("Hello!");

        Notifier slackAndEmail = decorator.new SlackNotifierDecorator(emailNotifier);
        slackAndEmail.send("How are you?");
    }
}
