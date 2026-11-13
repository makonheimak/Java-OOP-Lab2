import java.util.Scanner;

/**
 * Главный запускаемый класс для Лабораторной работы № 2 (Вариант 5).
 * Выполнил студент 4 курса ИВТ-А Юраш Максим
 */
public class Lab2_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        University donnu = new University("Донецкий национальный университет (ДонНУ)");

        // Предварительное наполнение для наглядности
        donnu.addStudent(new Student("Юраш Максим", 4, "ИВТ-А", 4.90));
        donnu.addStudent(new Student("Иванов Иван Сергеевич", 4, "ИВТ-А", 4.35));
        donnu.addStudent(new Student("Петрова Анна Дмитриевна", 3, "ПИ-А", 4.75));

        while (true) {
            System.out.println("\n==========================================================");
            System.out.println("   ЛАБОРАТОРНАЯ РАБОТА № 2: Создание классов ООП          ");
            System.out.println("   Выполнил студент 4 курса ИВТ-А Юраш Максим     ");
            System.out.println("   Вариант 5                                             ");
            System.out.println("==========================================================");
            System.out.println("1 - Задание 1 (Простое): Тестирование класса Car");
            System.out.println("2 - Задание 2 (Сложное): Вывод всех студентов University");
            System.out.println("3 - Задание 2: Добавить нового студента в University");
            System.out.println("4 - Задание 2: Поиск студентов по названию группы");
            System.out.println("5 - Задание 2: Показать средний балл по университету");
            System.out.println("0 - Выход");
            System.out.print("Выберите действие: ");

            String choice = scanner.nextLine().trim();

            if (choice.equals("0")) {
                System.out.println("Завершение работы Лабораторной № 2.");
                break;
            } else if (choice.equals("1")) {
                System.out.println("\n--- Создание и вывод объектов класса Car ---");
                Car userCar = new Car("Toyota", "Camry", 2021);
                userCar.displayInfo();

                System.out.print("Хотите создать свой автомобиль? (y/n): ");
                if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
                    System.out.print("Марка: ");
                    String b = scanner.nextLine().trim();
                    System.out.print("Модель: ");
                    String m = scanner.nextLine().trim();
                    System.out.print("Год выпуска: ");
                    try {
                        int y = Integer.parseInt(scanner.nextLine().trim());
                        Car custom = new Car(b, m, y);
                        custom.displayInfo();
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка ввода года!");
                    }
                }
            } else if (choice.equals("2")) {
                donnu.printAllStudents();
            } else if (choice.equals("3")) {
                System.out.println("\n--- Зачисление нового студента ---");
                System.out.print("ФИО студента: ");
                String name = scanner.nextLine().trim();
                System.out.print("Курс (1-5): ");
                int course = 1;
                try {
                    course = Integer.parseInt(scanner.nextLine().trim());
                } catch (Exception ignored) {}

                System.out.print("Группа: ");
                String group = scanner.nextLine().trim();

                System.out.print("Средний балл (например, 4.75): ");
                double gpa = 4.0;
                try {
                    gpa = Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
                } catch (Exception ignored) {}

                donnu.addStudent(new Student(name, course, group, gpa));
            } else if (choice.equals("4")) {
                System.out.print("\nВведите группу для поиска (например, ИВТ-А): ");
                String g = scanner.nextLine().trim();
                donnu.findByGroup(g);
            } else if (choice.equals("5")) {
                System.out.printf("%nСредний балл по всем студентам %s: %.2f%n",
                        donnu.getName(), donnu.calculateAverageGpa());
            } else {
                System.out.println("Неверный пункт меню!");
            }
        }
    }
}
