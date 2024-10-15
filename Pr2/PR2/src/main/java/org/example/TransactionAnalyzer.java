package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionAnalyzer {
    private final List<Transaction> transactions;
    private DateTimeFormatter dateFormatter;

    public TransactionAnalyzer(List<Transaction> transactions) {
        this.transactions = transactions;
        this.dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public double calculateTotalBalance() {
        double balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
        }
        return balance;
    }

    public int countTransactionsByMonth(String monthYear) {
        int count = 0;
        for (Transaction transaction : transactions) {
            LocalDate date = LocalDate.parse(transaction.getDate(), dateFormatter);
            String transactionMonthYear = date.format(DateTimeFormatter.ofPattern("MM-yyyy"));
            if (transactionMonthYear.equals(monthYear)) {
                count++;
            }
        }
        return count;
    }

    public List<Transaction> findTopExpenses() {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)  // Витрати мають від'ємне значення
                .sorted((t1, t2) -> Double.compare(t1.getAmount(), t2.getAmount()))  // Сортування за витратами
                .limit(10)  // Топ 10
                .toList();
    }

    public List<Transaction> findLowestExpenses(int limit) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)  // Витрати мають від'ємне значення
                .sorted((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()))  // Сортування в зворотному порядку
                .limit(limit)  // Ліміт найменших витрат
                .collect(Collectors.toList());
    }

    // Групування витрат по категоріям і місяцям
    public void printCategoryExpenseReport() {
        // Групування транзакцій по місяцях і категоріях та візуалізація за допомогою символів
        transactions.stream()
                .filter(t -> t.getAmount() < 0)  // Витрати
                .collect(Collectors.groupingBy(
                        t -> t.getDate().substring(3, 10),  // Групування за місяцем
                        Collectors.groupingBy(
                                Transaction::getDescription,  // Групування за категорією (опис)
                                Collectors.summingDouble(Transaction::getAmount)  // Підсумовування витрат
                        )
                )).forEach((month, categoryMap) -> {
                    System.out.println("Місяць: " + month);
                    categoryMap.forEach((category, amount) -> {
                        int symbols = (int) Math.abs(amount) / 1000;
                        System.out.println(category + ": " + "*".repeat(symbols) + " (" + amount + " грн)");
                    });
                });
    }
}





