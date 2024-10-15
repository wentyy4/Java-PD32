package org.example;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";

        TransactionCSVReader csvReader = new TransactionCSVReader();
        List<Transaction> transactions = csvReader.readTransactions(filePath);

        TransactionAnalyzer analyzer = new TransactionAnalyzer(transactions);
        TransactionReportGenerator reportGenerator = new TransactionReportGenerator();

        // Обчислюємо загальний баланс
        double totalBalance = analyzer.calculateTotalBalance();
        reportGenerator.printBalanceReport(totalBalance);

        // Рахуємо кількість транзакцій за місяць
        String monthYear = "01-2024";
        int transactionsCount = analyzer.countTransactionsByMonth(monthYear);
        reportGenerator.printTransactionsCountByMonth(monthYear, transactionsCount);

        // Визначаємо 10 найбільших витрат
        List<Transaction> topExpenses = analyzer.findTopExpenses();
        reportGenerator.printTopExpensesReport(topExpenses);

        // Визначаємо найменші витрати
        List<Transaction> lowestExpenses = analyzer.findLowestExpenses(5);
        reportGenerator.printLowestExpensesReport(lowestExpenses);

        // Виводимо звіт за категоріями і місяцями
        analyzer.printCategoryExpenseReport();
    }
}



