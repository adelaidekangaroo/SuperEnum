import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Colors.values())); // вывод всех элементов
        System.out.println(Colors.RED == Colors.RED); // сравнение
        System.out.println(Colors.BLACK.ordinal()); // порядковый номер
        System.out.println(Colors.findByIndex(1)); // по индексу
        System.out.println(Colors.BLACK.getName()); // имя
        System.out.println(Colors.findByName("BLACK")); // по имени
    }
}
