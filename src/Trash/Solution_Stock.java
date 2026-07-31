package Trash;

import java.util.*;

import org.junit.*;

class Stock {
    /**
     * Data about a particular stock.
     */
    String symbol; // String, the symbol of the stock
    String name; // String, the name of the stock

    Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Stock stock = (Stock) other;
        return symbol.equals(stock.symbol) && name.equals(stock.name);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(symbol, name);
    }
}

class PriceRecord {
    /**
     * Data and methods about a single price record of a stock.
     */
    Stock stock; // Stock object representing the stock
    int price; // int, the price of the stock
    String date; // String, the date of the price record is of the format "YYYY-MM-DD"

    PriceRecord(Stock stock, int price, String date) {
        this.stock = stock;
        this.price = price;
        this.date = date;
    }
}

class StockCollection {
    /**
     * Data for a collection of price records for a particular stock, and methods for
     * getting useful statistics about the stock's prices.
     */
    ArrayList<PriceRecord> priceRecords = new ArrayList<>(); // list of PriceRecord objects, the price records for this particular stock
    Stock stock; // Stock, the Stock this StockCollection is for

    StockCollection(Stock stock) {
        this.stock = stock;
    }

    int getNumPriceRecords() {
        /** Returns the number of PriceRecords in this StockCollection */
        return priceRecords.size();
    }

    void addPriceRecord(PriceRecord priceRecord) {
        /** Adds a PriceRecord to this StockCollection. */
        if (!priceRecord.stock.equals(this.stock)) {
            throw new IllegalArgumentException("PriceRecord's Stock is not the same as the StockCollection's");
        }
        priceRecords.add(priceRecord);
    }

    // bug
    int getMaxPrice() {
        /** Return the maximum price recorded in this StockCollection. */
        if (priceRecords.isEmpty()) {
            return -1;
        }
        return priceRecords.stream().mapToInt(record -> record.price).max().getAsInt();
    }

    // bug
    int getMinPrice() {
        /** Return the minimum price recorded in this StockCollection. */
        if (priceRecords.isEmpty()) {
            return -1;
        }
        return priceRecords.stream().mapToInt(record -> record.price).min().getAsInt();
    }

    // bug
    double getAvgPrice() {
        /** Return the average price recorded in this StockCollection. */
        if (priceRecords.isEmpty()) {
            return -1.0;
        }
        double total = priceRecords.stream().mapToInt(record -> record.price).sum();
        return (total / priceRecords.size());
    }

    // implemented  code
    Object[] getBiggestChange() {
        if (priceRecords.size() < 2) {
            return null;
        }
        ArrayList<PriceRecord> sortedRecords =
                new ArrayList<>(priceRecords);
        sortedRecords.sort(
                (a, b) -> a.date.compareTo(b.date)
        );
        int biggestChange = 0;
        String startDate = "";
        String endDate = "";
        boolean first = true;
        for (int i = 1; i < sortedRecords.size(); i++) {
            int change =
                    sortedRecords.get(i).price -
                            sortedRecords.get(i - 1).price;
            if (first || Math.abs(change) > Math.abs(biggestChange)) {
                biggestChange = change;
                startDate = sortedRecords.get(i - 1).date;
                endDate = sortedRecords.get(i).date;
                first = false;
            }
        }
        return new Object[]{
                biggestChange,
                startDate,
                endDate
        };
    }
}

class Transaction {
    /**
     * Data about a buy/sell transaction of a stock.
     */
    Stock stock; // Stock object representing the stock
    String transactionType; // String, "buy" or "sell"
    String date; // String, the date of the transaction in the format "YYYY-MM-DD"
    int quantity; // int, the quantity of stocks involved in the transaction

    Transaction(Stock stock, String transactionType, String date, int quantity) {
        this.stock = stock;
        this.transactionType = transactionType;
        this.date = date;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Transaction: " + stock + ", Type: " + transactionType + ", Date: " + date + ", Quantity: " + quantity;
    }
}

class Tradebook {
    /**
     * Represents a list of transactions and a list of StockCollection objects for all stocks.
     */
    ArrayList<Transaction> transactions = new ArrayList<>(); // list of Transaction objects, represents all transactions

    void addTransaction(Transaction transaction) {
        /** Adds a Transaction to the Tradebook. */
        transactions.add(transaction);
    }

// implemented code
    int getTotal(ArrayList<StockCollection> stockCollections) {
        HashMap<Stock, Integer> holdings = new HashMap<>();
        /*
         * Calculate how many shares of each stock are currently owned.
         */
        for (Transaction transaction : transactions) {
            int quantity =
                    holdings.getOrDefault(transaction.stock, 0);
            if (transaction.transactionType.equals("buy")) {
                quantity += transaction.quantity;
            } else if (transaction.transactionType.equals("sell")) {

                quantity -= transaction.quantity;
            }
            holdings.put(transaction.stock, quantity);
        }
        int total = 0;
        /*
         * Calculate value using the latest price record for each stock.
         */
        for (StockCollection collection : stockCollections) {
            int owned =
                    holdings.getOrDefault(collection.stock, 0);
            if (owned == 0) {
                continue;
            }
            PriceRecord latestRecord = null;
            for (PriceRecord record : collection.priceRecords) {
                if (latestRecord == null ||
                        record.date.compareTo(latestRecord.date) > 0) {
                    latestRecord = record;
                }
            }
            if (latestRecord != null) {
                total += owned * latestRecord.price;
            }
        }
        return total;
    }
}

public class Solution_Stock {

    public static void main(String[] args) {
        testPriceRecord();
        testStockCollection();
        testGetBiggestChange();
        testTradebook();

        System.out.println("All tests passed!");
    }

    public static void testPriceRecord() {
        // Test basic PriceRecord functionality
        System.out.println("Running testPriceRecord");
        Stock testStock = new Stock("AAPL", "Apple Inc.");
        PriceRecord testPriceRecord = new PriceRecord(testStock, 100, "2023-07-01");

        Assert.assertEquals(testPriceRecord.stock, testStock);
        Assert.assertEquals(testPriceRecord.price, 100);
        Assert.assertEquals(testPriceRecord.date, "2023-07-01");
    }

    private static StockCollection makeStockCollection(Stock stock, Object[][] priceData) {
        StockCollection stockCollection = new StockCollection(stock);
        for (Object[] priceRecordData : priceData) {
            PriceRecord priceRecord = new PriceRecord(stock, (int) priceRecordData[0], (String) priceRecordData[1]);
            stockCollection.addPriceRecord(priceRecord);
        }
        return stockCollection;
    }

    public static void testStockCollection() {
        System.out.println("Running testStockCollection");
        // Test basic StockCollection functionality
        Stock testStock = new Stock("AAPL", "Apple Inc.");
        StockCollection stockCollection = new StockCollection(testStock);

        Assert.assertEquals(0, stockCollection.getNumPriceRecords());
        Assert.assertEquals(-1, stockCollection.getMaxPrice());
        Assert.assertEquals(-1, stockCollection.getMinPrice());
        Assert.assertEquals(-1.0, stockCollection.getAvgPrice(), 0.001);

        /*
         * Price Records: Price: 110 112 90 105 Date: 2023-06-29 2023-07-01 2023-06-28
         * 2023-07-06
         */
        Object[][] priceData = {{110, "2023-06-29"}, {112, "2023-07-01"}, {90, "2023-06-28"},
                {105, "2023-07-06"}};
        testStock = new Stock("AAPL", "Apple Inc.");
        stockCollection = makeStockCollection(testStock, priceData);

        Assert.assertEquals(priceData.length, stockCollection.getNumPriceRecords());
        Assert.assertEquals(112, stockCollection.getMaxPrice());
        Assert.assertEquals(90, stockCollection.getMinPrice());
        Assert.assertEquals(104.25, stockCollection.getAvgPrice(), 0.1);
    }

    public static void testGetBiggestChange() {
        // Test the getBiggestChange method
        System.out.println("Running testGetBiggestChange");
        Stock testStock = new Stock("AAPL", "Apple Inc.");
        StockCollection stockCollection = new StockCollection(testStock);

        Assert.assertNull(stockCollection.getBiggestChange());

        /*
         * Price Records: Price: 110 112 90 105 Date: 2023-06-29 2023-07-01 2023-06-25
         * 2023-07-06
         */
        Object[][] priceData = {{110, "2023-06-29"}, {112, "2023-07-01"}, {90, "2023-06-25"},
                {105, "2023-07-06"}};
        stockCollection = makeStockCollection(testStock, priceData);

        Assert.assertArrayEquals(new Object[]{20, "2023-06-25", "2023-06-29"}, stockCollection.getBiggestChange());

        /*
         * Price Records: Price: 200 210 190 180 Date: 2000-01-04 1999-12-30 2000-01-03
         * 2000-01-01
         */
        Object[][] priceData2 = {{200, "2000-01-04"}, {210, "1999-12-30"}, {190, "2000-01-03"},
                {180, "2000-01-01"}};
        stockCollection = makeStockCollection(testStock, priceData2);

        Assert.assertArrayEquals(new Object[]{-30, "1999-12-30", "2000-01-01"}, stockCollection.getBiggestChange());
    }

    public static void testTradebook() {
        // Test Tradebook functionality
        System.out.println("Running testTradebook");
        Tradebook tradebook = new Tradebook();
        Stock testStock1 = new Stock("AAPL", "Apple Inc.");
        Object[][] testPriceData1 = {{110, "2023-06-29"}, {112, "2023-07-01"}, {90, "2023-06-25"},
                {105, "2023-07-06"}};
        StockCollection testStockCollection1 = makeStockCollection(testStock1, testPriceData1);

        ArrayList<StockCollection> testStockCollections = new ArrayList<>();
        testStockCollections.add(testStockCollection1);

        Transaction transaction1 = new Transaction(testStock1, "buy", "2023-06-25", 10);
        tradebook.addTransaction(transaction1);
        // Total price = 10 * 105 = 1050
        Assert.assertEquals(1050, tradebook.getTotal(testStockCollections));

        Transaction transaction2 = new Transaction(testStock1, "buy", "2023-06-29", 5);
        Transaction transaction3 = new Transaction(testStock1, "sell", "2023-07-01", 3);
        tradebook.addTransaction(transaction2);
        tradebook.addTransaction(transaction3);
        // Total stocks = 10 + 5 - 3 = 12
        // Total price = 12 * 105 = 1260
        Assert.assertEquals(1260, tradebook.getTotal(testStockCollections));

        Stock testStock2 = new Stock("GOOG", "Alphabet Inc.");
        Stock testStock3 = new Stock("MSFT", "Microsoft Corporation");
        Stock testStock4 = new Stock("AMZN", "Amazon.com Inc.");
        Object[][] testPriceData2 = {{1500, "2023-06-29"}, {1550, "2023-07-01"}, {1475, "2023-06-25"},
                {1520, "2023-07-06"}};
        Object[][] testPriceData3 = {{250, "2023-06-29"}, {255, "2023-07-01"}, {260, "2023-07-06"},
                {245, "2023-06-25"}};
        Object[][] testPriceData4 = {{3550, "2023-07-06"}, {3500, "2023-06-29"}, {3600, "2023-07-01"},
                {3450, "2023-06-25"}};
        StockCollection testStockCollection2 = makeStockCollection(testStock2, testPriceData2);
        StockCollection testStockCollection3 = makeStockCollection(testStock3, testPriceData3);
        StockCollection testStockCollection4 = makeStockCollection(testStock4, testPriceData4);
        testStockCollections.add(testStockCollection2);
        testStockCollections.add(testStockCollection3);
        testStockCollections.add(testStockCollection4);

        Transaction transaction4 = new Transaction(testStock2, "buy", "2023-06-25", 15);
        Transaction transaction5 = new Transaction(testStock2, "sell", "2023-06-29", 10);
        Transaction transaction6 = new Transaction(testStock2, "sell", "2023-07-01", 1);
        tradebook.addTransaction(transaction4);
        tradebook.addTransaction(transaction5);
        tradebook.addTransaction(transaction6);

        Transaction transaction7 = new Transaction(testStock3, "sell", "2023-07-01", 5);
        Transaction transaction8 = new Transaction(testStock3, "buy", "2023-06-29", 20);
        Transaction transaction9 = new Transaction(testStock3, "buy", "2023-06-25", 10);
        tradebook.addTransaction(transaction7);
        tradebook.addTransaction(transaction8);
        tradebook.addTransaction(transaction9);

        Transaction transaction10 = new Transaction(testStock4, "buy", "2023-07-01", 5);
        Transaction transaction11 = new Transaction(testStock4, "buy", "2023-06-29", 5);
        Transaction transaction12 = new Transaction(testStock4, "buy", "2023-06-25", 1);
        tradebook.addTransaction(transaction10);
        tradebook.addTransaction(transaction11);
        tradebook.addTransaction(transaction12);
        // Stocks: APPL GOOG MSFT AMZN
        // Total stocks: 12 4 25 11
        // Latest price: 105 1520 260 3550
        // Total price: 1260 + 6080 + 6500 + 39050 = 52890
        Assert.assertEquals(52890, tradebook.getTotal(testStockCollections));
    }
}

