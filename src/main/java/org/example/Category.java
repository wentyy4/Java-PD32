package org.example;

public class Category {
    private String name; // Назва категорії

    // Конструктор з параметром для назви
    public Category(String name) {
        this.name = name;
    }

    // Геттер для назви категорії
    public String getName() {
        return name;
    }

    // Метод для представлення категорії у вигляді рядка
    @Override
    public String toString() {
        return "Категорія: " + name;
    }
}
