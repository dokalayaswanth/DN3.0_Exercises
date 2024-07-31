import java.util.ArrayList;
import java.util.List;

interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers;
    private String stockName;
    private double stockPrice;

    public StockMarket(String stockName) {
        this.stockName = stockName;
        this.stockPrice = 0.0;
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, stockPrice);
        }
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }
}

interface Observer {
    void update(String stockName, double stockPrice);
}

class MobileApp implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("MobileApp: Stock " + stockName + " price updated to " + stockPrice);
    }
}

class WebApp implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("WebApp: Stock " + stockName + " price updated to " + stockPrice);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket("ABC Corp");

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        System.out.println("Updating stock price to 150.75:");
        stockMarket.setStockPrice(150.75);

        System.out.println("\nUpdating stock price to 155.00:");
        stockMarket.setStockPrice(155.00);

        stockMarket.deregisterObserver(mobileApp);

        System.out.println("\nUpdating stock price to 160.00:");
        stockMarket.setStockPrice(160.00);
    }
}
