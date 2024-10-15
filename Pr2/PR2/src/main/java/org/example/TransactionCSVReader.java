package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransactionCSVReader {

    private static final Logger logger = Logger.getLogger(TransactionCSVReader.class.getName());

    public List<Transaction> readTransactions(String filePath) {
        List<Transaction> transactions = new ArrayList<>();
        try {
            // Завантажуємо файл через URL
            URL url = new URL(filePath);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    Transaction transaction = new Transaction(values[0], Double.parseDouble(values[1]), values[2]);
                    transactions.add(transaction);
                }
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error reading transactions from CSV", e);
        }
        return transactions;
    }
}



