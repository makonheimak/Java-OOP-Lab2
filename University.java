import java.util.Arrays;

/**
 * Лабораторная работа № 2 (Вариант 5)
 * Сложное задание: Создать класс University с массивом студентов.
 * Реализовать методы добавления студента и вывода списка.
 * Выполнил студент 4 курса ИВТ-А Юраш Максим
 */
public class University {
    private String name;
    private Student[] students;
    private int count; // текущее количество студентов

    public University(String name, int initialCapacity) {
        this.name = name;
        this.students = new Student[Math.max(initialCapacity, 5)];
        this.count = 0;
    }

    public University(String name) {
        this(name, 10);
    }

    // Метод добавления студента с автоматическим расширением массива при необходимости
    public void addStudent(Student student) {
        if (student == null) {
            System.out.println("Ошибка: попытка добавить пустого студента (null)!");
            return;
        }

        // Если массив переполнен, увеличиваем его емкость в 1.5 раза
        if (count >= students.length) {
            int newCapacity = (int) (students.length * 1.5) + 1;
            students = Arrays.copyOf(students, newCapacity);
        }

        students[count++] = student;
        System.out.println("-> Студент успешно зачислен: " + student.getFullName());
    }

    // Метод вывода полного списка студентов
    public void printAllStudents() {
        System.out.println("\n==========================================================================");
        System.out.printf("   СПИСОК СТУДЕНТОВ УНИВЕРСИТЕТА: %s (Всего: %d)%n", name, count);
        System.out.println("==========================================================================");

        if (count == 0) {
            System.out.println("  Список студентов пуст.");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.printf("%2d. ", i + 1);
            students[i].display();
        }
        System.out.println("==========================================================================\n");
    }

    // Метод поиска студентов по группе
    public void findByGroup(String targetGroup) {
        System.out.printf("\nПоиск студентов группы '%s':%n", targetGroup);
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (students[i].getGroup().equalsIgnoreCase(targetGroup.trim())) {
                students[i].display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("  Студентов в данной группе не найдено.");
        }
    }

    // Метод подсчета среднего балла по университету
    public double calculateAverageGpa() {
        if (count == 0) return 0.0;
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += students[i].getGpa();
        }
        return sum / count;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }
}
