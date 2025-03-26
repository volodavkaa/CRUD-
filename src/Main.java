import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Клас, що описує Genre
    static class Genre {
        int id;
        String name;

        public Genre(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    // Список для зберігання жанрів та змінна для автоматичного інкременту id
    static List<Genre> genres = new ArrayList<>();
    static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Меню CRUD для таблиці Genres ===");
            System.out.println("1. Створити новий жанр");
            System.out.println("2. Переглянути всі жанри");
            System.out.println("3. Оновити жанр");
            System.out.println("4. Видалити жанр");
            System.out.println("5. Вихід");
            System.out.print("Виберіть дію: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // споживаємо символ нового рядка

            switch (choice) {
                case 1:
                    createGenre(scanner);
                    break;
                case 2:
                    readGenres();
                    break;
                case 3:
                    updateGenre(scanner);
                    break;
                case 4:
                    deleteGenre(scanner);
                    break;
                case 5:
                    System.out.println("Вихід з програми.");
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }

    // Метод для створення нового жанру
    static void createGenre(Scanner scanner) {
        System.out.print("Введіть назву жанру: ");
        String name = scanner.nextLine();
        Genre newGenre = new Genre(nextId++, name);
        genres.add(newGenre);
        System.out.println("Жанр створено: " + newGenre.id + " - " + newGenre.name);
    }

    // Метод для виведення всіх жанрів
    static void readGenres() {
        if (genres.isEmpty()) {
            System.out.println("Жанри відсутні.");
        } else {
            System.out.println("Список жанрів:");
            for (Genre g : genres) {
                System.out.println(g.id + ". " + g.name);
            }
        }
    }

    // Метод для оновлення жанру
    static void updateGenre(Scanner scanner) {
        System.out.print("Введіть id жанру для оновлення: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // споживаємо символ нового рядка
        Genre genreToUpdate = null;
        for (Genre g : genres) {
            if (g.id == id) {
                genreToUpdate = g;
                break;
            }
        }
        if (genreToUpdate == null) {
            System.out.println("Жанр з id " + id + " не знайдено.");
            return;
        }
        System.out.print("Введіть нову назву жанру: ");
        String newName = scanner.nextLine();
        genreToUpdate.name = newName;
        System.out.println("Жанр оновлено: " + genreToUpdate.id + " - " + genreToUpdate.name);
    }

    // Метод для видалення жанру
    static void deleteGenre(Scanner scanner) {
        System.out.print("Введіть id жанру для видалення: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // споживаємо символ нового рядка
        Genre genreToRemove = null;
        for (Genre g : genres) {
            if (g.id == id) {
                genreToRemove = g;
                break;
            }
        }
        if (genreToRemove == null) {
            System.out.println("Жанр з id " + id + " не знайдено.");
            return;
        }
        genres.remove(genreToRemove);
        System.out.println("Жанр видалено: " + id);
    }
}
