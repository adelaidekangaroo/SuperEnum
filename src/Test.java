import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Colors.values())); // print all elements
        System.out.println(Colors.RED == Colors.RED); // comparing through ==
        System.out.println(Colors.RED.equals(Colors.RED)); // comparing through equals
        System.out.println(Colors.BLACK.ordinal()); // print ordinal
        System.out.println(Colors.findByOrdinal(1)); // by ordinal
        System.out.println(Colors.BLACK.getName()); // name
        System.out.println(Colors.findByName("BLACK")); // by name
    }
}
