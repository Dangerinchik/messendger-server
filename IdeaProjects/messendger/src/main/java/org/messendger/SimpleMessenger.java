package org.messendger;

import java.util.HashMap;
import java.util.Scanner;


enum Colors{
    RED, PINK, WHITE;
}


public class SimpleMessenger {
    private static HashMap<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        Colors color = Colors.RED;

        while (running) {
            System.out.println("Добро пожаловать в мессенджер!");
            System.out.println("1. Регистрация");
            System.out.println("2. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Очистка буфера

            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    running = false;
                    System.out.println("Выход из мессенджера.");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }

        scanner.close();
    }

    private static void registerUser(Scanner scanner) {
        System.out.print("Введите имя пользователя: ");
        String username = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Пользователь с таким именем уже существует. Попробуйте другое имя.");
            return;
        }

        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        users.put(username, password);
        System.out.println("Регистрация прошла успешно! Добро пожаловать, " + username + "!");
    }
}

