package org.example;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    private List<Order> orderHistory = new ArrayList<>();

    // Додавання замовлення до історії
    public void addOrder(Order order) {
        orderHistory.add(order);
    }

    // Отримати історію замовлень
    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    // Вивести історію замовлень
    public void printOrderHistory() {
        if (orderHistory.isEmpty()) {
            System.out.println("Історія замовлень порожня.");
        } else {
            for (Order order : orderHistory) {
                System.out.println(order.toString());
                System.out.println("---------------------");
            }
        }
    }
}
