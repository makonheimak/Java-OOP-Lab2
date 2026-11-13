import java.time.Year;

/**
 * Лабораторная работа № 2 (Вариант 5)
 * Простое задание: Создать класс Car с полями: марка, модель, год выпуска.
 * Выполнил студент 4 курса ИВТ-А Юраш Максим
 */
public class Car {
    private String brand;
    private String model;
    private int year;

    // Конструктор по умолчанию
    public Car() {
        this("Неизвестно", "Базовая", Year.now().getValue());
    }

    // Параметризованный конструктор
    public Car(String brand, String model, int year) {
        setBrand(brand);
        setModel(model);
        setYear(year);
    }

    // Геттеры и сеттеры с инкапсуляцией и проверкой
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            this.brand = "Не указана";
        } else {
            this.brand = brand.trim();
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            this.model = "Не указана";
        } else {
            this.model = model.trim();
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        int currentYear = Year.now().getValue();
        if (year < 1886 || year > currentYear + 1) {
            System.out.printf("Предупреждение: год %d некорректен, установлен текущий (%d)%n", year, currentYear);
            this.year = currentYear;
        } else {
            this.year = year;
        }
    }

    // Метод расчета возраста автомобиля
    public int getAge() {
        return Year.now().getValue() - this.year;
    }

    // Метод вывода информации об автомобиле
    public void displayInfo() {
        System.out.println("----------------------------------------------");
        System.out.printf("Автомобиль: %s %s%n", brand, model);
        System.out.printf("Год выпуска: %d г. (Возраст: %d лет)%n", year, getAge());
        System.out.println("----------------------------------------------");
    }

    @Override
    public String toString() {
        return String.format("Car{brand='%s', model='%s', year=%d}", brand, model, year);
    }

    // Демонстрационный запуск
    public static void main(String[] args) {
        System.out.println("=== Тестирование класса Car (Лабораторная работа № 2, Вариант 5) ===");
        System.out.println("Выполнил студент 4 курса ИВТ-А Юраш Максим");
        Car car1 = new Car("Toyota", "Camry", 2021);
        Car car2 = new Car("BMW", "M5", 2019);
        Car car3 = new Car();

        car1.displayInfo();
        car2.displayInfo();
        car3.displayInfo();
    }
}
