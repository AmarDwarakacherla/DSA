package Trash;

/*
We are developing a payment Transactionn monitoring system that tracks accounts and their Transactionns.
The system can compute each account's current balance and basic statistics.

Definitions:
* An "account" has a unique accountId and an owner name.
* A "Transactionn" represents money moving in or out of an account.
  - CREDIT increases the account balance.
  - DEBIT decreases the account balance.
* "AccountManager" manages accounts and Transactionns and provides balance-related methods.

To begin with, we present you with two tasks:
1-1) Read through and understand the code below. Please take as much time as necessary, and feel free to run it.
1-2) The test for AccountManager is not passing due to a bug in the code.
     Make the necessary changes to AccountManager to fix the bug.
/*
We are extending our payment Transactionn monitoring system to support
basic analytics over Transactionns.

For this task, we want to calculate the average Transactionn amount per account.

2) Implement the function getAverageTransactionnAmountByAccount in AccountManager that returns
the average Transactionn amount for each account.

Requirements:
- The result should associate each accountId with the average amount of its Transactionns.
- Both CREDIT and DEBIT Transactionns should be considered.
- Transactionn amounts should be treated as absolute values when calculating averages.
- Accounts with no Transactionns should not appear in the result.
- Transactionns always refer to valid accounts.

To assist you in testing this new function, we have provided the
testGetAverageTransactionnAmountByAccount test.

3) Implement the function getPaymentFee for each acount ID
The method should return the total payment fee for each account.
first 3 Transactionns are free
For credit - 1$ per Transactionn
For debit - 2$ per Transactionn.
return total fee.
*/
/*
We are adding suspicious activity detection to our payment Transactionn monitoring system.

A suspicious account is defined as follows:

- Consider only DEBIT Transactionns.
- A DEBIT Transactionn is considered "large" if amount >= 50.
- An account is suspicious if it has 3 or more large DEBIT Transactionns within ANY 60-second window.

Notes:
- Transactionns are not guaranteed to be inserted in chronological order.
- You must process Transactionns in chronological order (by timestampSec) per account.
- The window is inclusive of endpoints: a Transactionn at t and another at t+60 are in the same 60-second window.


4) Implement getSuspiciousAccounts() in AccountManager. The function should
return a sorted list of accountIds that have 3 or more large DEBIT
Transactionns (amount >= 50) within any 60-second window.
*/

import java.util.*;

import org.junit.*;

enum TransactionnType {
    CREDIT,
    DEBIT
}

class Account {
    int accountId;
    String ownerName;

    Account(int accountId, String ownerName) {
        this.accountId = accountId;
        this.ownerName = ownerName;
    }
}

class Transactionn {
    int TransactionnId;
    int accountId;
    TransactionnType type;
    double amount;     // Always positive in inputs
    long timestampSec; // Unix-style seconds (monotonic for tests)

    Transactionn(int TransactionnId, int accountId, TransactionnType type, double amount, long timestampSec) {
        this.TransactionnId = TransactionnId;
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.timestampSec = timestampSec;
    }
}

class AccountManager {
    Map<Integer, Account> accounts = new HashMap<>();
    List<Transactionn> Transactionn = new ArrayList<>();

    void addAccount(Account account) {
        accounts.put(account.accountId, account);
    }

    void addTransactionn(Transactionn tx) {
        // Assume input Transactionns always refer to valid accounts for this question.
        Transactionn.add(tx);
    }

    // Returns the current balance for the given accountId.
    double getBalance(int accountId) {
        double balance = 0.0;
        for (Transactionn tx : Transactionn) {
            if (tx.accountId == accountId) {
                if (tx.type == TransactionnType.CREDIT) {
                    balance += tx.amount;
                }
                //added else condtion
                else if (tx.type == TransactionnType.DEBIT) {
                    balance -= tx.amount;
                }
            }
        }
        return balance;
    }


    public Map<Integer, Double> getAverageTransactionnAmountByAccount() {
        Map<Integer, Double> result = new HashMap<>();
        Map<Integer, Double> totals = new HashMap<>();
        Map<Integer, Integer> counts = new HashMap<>();
        for (Transactionn tx : Transactionn) {
            totals.put(tx.accountId, totals.getOrDefault(tx.accountId, 0.0) + Math.abs(tx.amount));
            counts.put(tx.accountId, counts.getOrDefault(tx.accountId, 0) + 1);
        }
        for (Integer accountId : totals.keySet()) {
            result.put(accountId, totals.get(accountId) / counts.get(accountId));
        }
        return result;
    }

    public Map<Integer, Double> getTransactionnFees() {
        Map<Integer, Double> fees = new HashMap<>();
        Map<Integer, List<Transactionn>> grouped = new HashMap<>();

        for (Transactionn tx : Transactionn) {
            grouped
                    .computeIfAbsent(tx.accountId, k -> new ArrayList<>())
                    .add(tx);
        }

        for (Map.Entry<Integer, List<Transactionn>> entry : grouped.entrySet()) {
            List<Transactionn> txs = entry.getValue();
            txs.sort(Comparator.comparingLong(t -> t.timestampSec));

            double fee = 0.0;

            for (int i = 3; i < txs.size(); i++) {
                if (txs.get(i).type == TransactionnType.CREDIT) {
                    fee += 1.0;
                } else {
                    fee += 2.0;
                }
            }

            fees.put(entry.getKey(), fee);
        }
        return fees;
    }

    public List<Integer> getSuspiciousAccounts() {
        Set<Integer> suspicious = new HashSet<>();
        Map<Integer, List<Transactionn>> grouped = new HashMap<>();
        // Keep only large debit transactions
        for (Transactionn tx : Transactionn) {
            if (tx.type == TransactionnType.DEBIT && tx.amount >= 50) {
                if (!grouped.containsKey(tx.accountId)) {
                    grouped.put(tx.accountId, new ArrayList<>());
                }
                grouped.get(tx.accountId).add(tx);
            }
        }
        for (Map.Entry<Integer, List<Transactionn>> entry : grouped.entrySet()) {
            List<Transactionn> txs = entry.getValue();
            // Sort by timestamp
//            txs.sort((a, b) -> Math.toIntExact(a.timestampSec - b.timestampSec));
//            Collections.sort(txs, new Comparator<Transactionn>() {
//                @Override
//                public int compare(Transactionn t1, Transactionn t2) {
//                    return Double.compare(t1.timestampSec, t2.timestampSec);
//                }
//            });
            txs.sort(Comparator.comparingLong(t -> t.timestampSec));
            int left = 0;
            for (int right = 0; right < txs.size(); right++) {
                while (txs.get(right).timestampSec -
                        txs.get(left).timestampSec > 60) {
                    left++;
                }
                if (right - left + 1 >= 3) {
                    suspicious.add(entry.getKey());
                    break;
                }
            }
        }
        List<Integer> result = new ArrayList<>(suspicious);
        Collections.sort(result);
        return result;
    }
}

public class Solution_Transaction {

    public static void main(String[] args) {
        testGetBalance_basic();
        testGetBalance_multipleAccounts();
        testGetAverageTransactionnAmountByAccount();
        testGetTransactionnFees();
        testGetSuspiciousAccounts();
        System.out.println("All tests passed.");
    }

    private static void assertAlmost(double expected, double actual, double eps) {
        Assert.assertTrue("Expected " + expected + " but got " + actual, Math.abs(expected - actual) <= eps);
    }

    public static void testGetBalance_basic() {
        System.out.println("Running testGetBalance_basic");
        AccountManager mgr = new AccountManager();
        mgr.addAccount(new Account(1, "Alice"));

        mgr.addTransactionn(new Transactionn(101, 1, TransactionnType.CREDIT, 100.0, 1000));
        mgr.addTransactionn(new Transactionn(102, 1, TransactionnType.DEBIT, 30.0, 1010));
        mgr.addTransactionn(new Transactionn(103, 1, TransactionnType.DEBIT, 20.0, 1020));
        mgr.addTransactionn(new Transactionn(104, 1, TransactionnType.CREDIT, 10.0, 1030));

        // Expected balance: 100 - 30 - 20 + 10 = 60
        assertAlmost(60.0, mgr.getBalance(1), 0.0001);
    }

    public static void testGetBalance_multipleAccounts() {
        System.out.println("Running testGetBalance_multipleAccounts");
        AccountManager mgr = new AccountManager();
        mgr.addAccount(new Account(1, "Alice"));
        mgr.addAccount(new Account(2, "Bob"));

        mgr.addTransactionn(new Transactionn(201, 1, TransactionnType.CREDIT, 50.0, 2000));
        mgr.addTransactionn(new Transactionn(202, 2, TransactionnType.CREDIT, 80.0, 2005));
        mgr.addTransactionn(new Transactionn(203, 1, TransactionnType.DEBIT, 10.0, 2010));
        mgr.addTransactionn(new Transactionn(204, 2, TransactionnType.DEBIT, 5.5, 2015));
        mgr.addTransactionn(new Transactionn(205, 2, TransactionnType.DEBIT, 14.5, 2020));

        // Account 1: 50 - 10 = 40
        assertAlmost(40.0, mgr.getBalance(1), 0.0001);
        // Account 2: 80 - 5.5 - 14.5 = 60
        assertAlmost(60.0, mgr.getBalance(2), 0.0001);
    }

    public static void testGetAverageTransactionnAmountByAccount() {
        System.out.println("Running testGetAverageTransactionnAmountByAccount");
        AccountManager mgr = new AccountManager();

        mgr.addAccount(new Account(1, "Alice"));
        mgr.addAccount(new Account(2, "Bob"));
        mgr.addAccount(new Account(3, "Charlie")); // no Transactionns

        // Account 1: 100, 30, 20, 10 => avg = 160/4 = 40
        mgr.addTransactionn(new Transactionn(101, 1, TransactionnType.CREDIT, 100.0, 1000));
        mgr.addTransactionn(new Transactionn(102, 1, TransactionnType.DEBIT, 30.0, 1010));
        mgr.addTransactionn(new Transactionn(103, 1, TransactionnType.DEBIT, 20.0, 1020));
        mgr.addTransactionn(new Transactionn(104, 1, TransactionnType.CREDIT, 10.0, 1030));

        // Account 2: 80, 5.5, 14.5 => avg = 100/3 = 33.333...
        mgr.addTransactionn(new Transactionn(201, 2, TransactionnType.CREDIT, 80.0, 2005));
        mgr.addTransactionn(new Transactionn(202, 2, TransactionnType.DEBIT, 5.5, 2015));
        mgr.addTransactionn(new Transactionn(203, 2, TransactionnType.DEBIT, 14.5, 2020));

        Map<Integer, Double> avg = mgr.getAverageTransactionnAmountByAccount();

        assertAlmost(40.0, avg.get(1), 0.0001);
        assertAlmost(33.3333, avg.get(2), 0.0001);

        // Account 3 has no Transactionns -> should not be present
        Assert.assertFalse(avg.containsKey(3));
    }

    public static void testGetTransactionnFees() {
        System.out.println("Running testGetTransactionnFees");
        AccountManager mgr = new AccountManager();

        mgr.addAccount(new Account(1, "Alice"));
        mgr.addAccount(new Account(2, "Bob"));
        mgr.addAccount(new Account(3, "Jane"));

        // Account 1: 5 Transactionns
        mgr.addTransactionn(new Transactionn(1, 1, TransactionnType.CREDIT, 100.0, 1000));
        mgr.addTransactionn(new Transactionn(2, 1, TransactionnType.DEBIT, 20.0, 1010));
        mgr.addTransactionn(new Transactionn(3, 1, TransactionnType.CREDIT, 10.0, 1020));
        mgr.addTransactionn(new Transactionn(4, 1, TransactionnType.DEBIT, 5.0, 1030));  // fee: $2
        mgr.addTransactionn(new Transactionn(5, 1, TransactionnType.CREDIT, 7.0, 1040)); // fee: $1

        // Account 2: 4 Transactionns
        mgr.addTransactionn(new Transactionn(6, 2, TransactionnType.DEBIT, 50.0, 2000));
        mgr.addTransactionn(new Transactionn(7, 2, TransactionnType.DEBIT, 10.0, 2010));
        mgr.addTransactionn(new Transactionn(8, 2, TransactionnType.CREDIT, 20.0, 2020));
        mgr.addTransactionn(new Transactionn(9, 2, TransactionnType.DEBIT, 5.0, 2030)); // fee: $2

        // Account 3: 4 Transactionns
        mgr.addTransactionn(new Transactionn(26, 3, TransactionnType.DEBIT, 50.0, 2000));
        mgr.addTransactionn(new Transactionn(27, 3, TransactionnType.DEBIT, 10.0, 2010));
        mgr.addTransactionn(new Transactionn(28, 3, TransactionnType.CREDIT, 20.0, 2020)); // should be 4th → $1
        mgr.addTransactionn(new Transactionn(29, 3, TransactionnType.DEBIT, 5.0, 2005));


        Map<Integer, Double> fees = mgr.getTransactionnFees();

        // Account 1: $2 + $1 = $3
        assertAlmost(3.0, fees.get(1), 0.0001);

        // Account 2: $2
        assertAlmost(2.0, fees.get(2), 0.0001);

        // Account 3: 4th Transactionn (chronologically) is CREDIT → $1
        assertAlmost(1.0, fees.get(3), 0.0001);
    }

    public static void testGetSuspiciousAccounts() {
        System.out.println("Running testGetSuspiciousAccounts");

        AccountManager mgr = new AccountManager();
        mgr.addAccount(new Account(1, "Alice"));
        mgr.addAccount(new Account(2, "Bob"));
        mgr.addAccount(new Account(3, "Charlie"));

        // Account 1: three large debits within 60 seconds -> suspicious
        mgr.addTransactionn(new Transactionn(1, 1, TransactionnType.DEBIT, 50.0, 1000));
        mgr.addTransactionn(new Transactionn(2, 1, TransactionnType.DEBIT, 70.0, 1030));
        mgr.addTransactionn(new Transactionn(3, 1, TransactionnType.DEBIT, 90.0, 1060)); // 1000..1060 inclusive => suspicious

        // Account 2: three large debits but spread out > 60 seconds -> NOT suspicious
        mgr.addTransactionn(new Transactionn(4, 2, TransactionnType.DEBIT, 60.0, 2000));
        mgr.addTransactionn(new Transactionn(5, 2, TransactionnType.DEBIT, 80.0, 2070));
        mgr.addTransactionn(new Transactionn(6, 2, TransactionnType.DEBIT, 55.0, 2141)); // no 60-sec window contains all 3

        // Account 3: has credits and small debits; should not be suspicious
        mgr.addTransactionn(new Transactionn(7, 3, TransactionnType.CREDIT, 1000.0, 3000));
        mgr.addTransactionn(new Transactionn(8, 3, TransactionnType.DEBIT, 49.99, 3010));
        mgr.addTransactionn(new Transactionn(9, 3, TransactionnType.DEBIT, 50.0, 3020));
        mgr.addTransactionn(new Transactionn(10, 3, TransactionnType.DEBIT, 50.0, 3100)); // only 2 large debits within any window

        List<Integer> suspicious = mgr.getSuspiciousAccounts();
        Assert.assertEquals(Arrays.asList(1), suspicious);

        // Second test case: input order is shuffled; should still detect
        mgr = new AccountManager();
        mgr.addAccount(new Account(10, "Daisy"));

        mgr.addTransactionn(new Transactionn(100, 10, TransactionnType.DEBIT, 50.0, 500));
        mgr.addTransactionn(new Transactionn(101, 10, TransactionnType.DEBIT, 50.0, 560));
        mgr.addTransactionn(new Transactionn(102, 10, TransactionnType.DEBIT, 50.0, 530)); // out of order
        // 500, 530, 560 => within 60 inclusive => suspicious

        suspicious = mgr.getSuspiciousAccounts();
        Assert.assertEquals(Arrays.asList(10), suspicious);
    }
}

