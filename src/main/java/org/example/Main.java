package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Example setup of products and categories
        Category electronics = new Category("Електроніка");
        Category clothing = new Category("Одяг");

        Product product1 = new Product(1, "Телефон", 699.99, "Остання модель", electronics);
        Product product2 = new Product(2, "Футболка", 19.99, "Бавовна, синій", clothing);
        Product product3 = new Product(3, "Ноутбук", 1199.99, "Висока продуктивність", electronics);

        // Create a list of products
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        Cart cart = new Cart();
        OrderHistory orderHistory = new OrderHistory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Переглянути товари");
            System.out.println("2 - Додати товар до кошика");
            System.out.println("3 - Переглянути кошик");
            System.out.println("4 - Зробити замовлення");
            System.out.println("5 - Видалити товар з кошика");
            System.out.println("6 - Історія замовлень");
            System.out.println("7 - Пошук товарів");
            System.out.println("0 - Вийти");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    productList.forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Введіть ID товару для додавання до кошика:");
                    int idToAdd = scanner.nextInt();
                    productList.stream()
                            .filter(p -> p.getId() == idToAdd)
                            .findFirst()
                            .ifPresentOrElse(cart::addProduct, () -> System.out.println("Товар не знайдено"));
                    break;
                case 3:
                    System.out.println(cart);
                    break;
                case 4:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Кошик порожній.");
                    } else {
                        Order order = new Order(cart);
                        orderHistory.addOrder(order);
                        System.out.println("Замовлення оформлено:");
                        System.out.println(order);
                        cart.clear();
                    }
                    break;
                case 5:
                    System.out.println("Введіть ID товару для видалення:");
                    int idToRemove = scanner.nextInt();
                    cart.removeProduct(idToRemove);
                    System.out.println("Товар видалено.");
                    break;
                case 6:
                    orderHistory.printOrderHistory();
                    break;
                case 7:
                    System.out.println("Введіть назву або категорію для пошуку:");
                    scanner.nextLine(); // clear buffer
                    String searchTerm = scanner.nextLine();
                    productList.stream()
                            .filter(p -> p.getName().equalsIgnoreCase(searchTerm) || p.getCategory().getName().equalsIgnoreCase(searchTerm))
                            .forEach(System.out::println);
                    break;
                case 0:
                    System.out.println("Дякуємо, що використовували наш магазин!");
                    return;
                default:
                    System.out.println("Невідома опція.");
            }
        }
    }
}
