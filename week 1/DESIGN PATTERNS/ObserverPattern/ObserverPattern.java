import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public interface Stock {
        void registerObserver(Observer observer);

        void deregisterObserver(Observer observer);

        void notifyObservers();
    }

    public static class StockMarket implements Stock {
        private List<Observer> observers;
        private double price;

        public StockMarket() {
            this.observers = new ArrayList<>();
        }

        @Override
        public void registerObserver(Observer observer) {
            this.observers.add(observer);
        }

        @Override
        public void deregisterObserver(Observer observer) {
            this.observers.remove(observer);
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(price);
            }
        }

        public void setStockPrice(double stockPrice) {
            this.price = stockPrice;
            notifyObservers();
        }
    }

    public interface Observer {
        void update(double price);
    }

    public static class MobileApp implements Observer {
        private String name;

        public MobileApp(String name) {
            this.name = name;
        }

        @Override
        public void update(double price) {
            System.out.println(name + " received stock price update: " + price);
        }
    }

    public static class WebApp implements Observer {
        private String name;

        public WebApp(String name) {
            this.name = name;
        }

        @Override
        public void update(double price) {
            System.out.println(name + " received stock price update: " + price);
        }
    }

    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Observer m1 = new MobileApp("MobileApp 1");
        Observer w1 = new WebApp("WebApp 1");

        stockMarket.registerObserver(m1);
        stockMarket.registerObserver(w1);
        // stockMarket.deregisterObserver(w1);
        stockMarket.setStockPrice(100.00);
        stockMarket.setStockPrice(150.00);

    }
}
