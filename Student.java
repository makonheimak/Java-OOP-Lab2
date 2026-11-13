/**
 * Вспомогательный класс Student для сложного задания Лабораторной № 2.
 * Выполнил студент 4 курса ИВТ-А Юраш Максим
 */
public class Student {
    private String fullName;
    private int course;
    private String group;
    private double gpa; // средний балл

    public Student(String fullName, int course, String group, double gpa) {
        this.fullName = fullName;
        this.course = course;
        this.group = group;
        this.gpa = gpa;
    }

    public String getFullName() {
        return fullName;
    }

    public int getCourse() {
        return course;
    }

    public String getGroup() {
        return group;
    }

    public double getGpa() {
        return gpa;
    }

    public void display() {
        System.out.printf("  Студент: %-25s | Курс: %d | Группа: %-8s | Ср. балл: %.2f%n",
                fullName, course, group, gpa);
    }

    @Override
    public String toString() {
        return String.format("%s (%d курс, %s, балл: %.2f)", fullName, course, group, gpa);
    }
}
