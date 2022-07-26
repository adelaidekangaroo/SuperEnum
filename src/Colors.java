import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton.
 * Implements all api Enum.
 * Adds a name to each enum element using reflection.
 * Returns true when comparing through == of the same element.
 * Elements are immutable.
 * This is SuperEnum, mhahaha!
 */
public final class Colors {
    private static final List<Colors> values = new ArrayList<>();
    private static int ordinalCounter = 0;
    private final int ordinal = ordinalCounter++;
    private String name;

    private final String colorCode;

    public static final Colors RED = new Colors("#red");
    public static final Colors BLACK = new Colors("#black");
    public static final Colors GREEN = new Colors("#green");

    private Colors(String colorCode) {
        this.colorCode = colorCode;
        values.add(this);
    }

    public String getColorCode() {
        return colorCode;
    }

    public int ordinal() {
        return ordinal;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Color{name=" + name + "}";
    }

    public static Colors[] values() {
        return values.toArray(new Colors[]{});
    }

    public static Colors findByOrdinal(int ordinal) {
        if (ordinal >= 0 || ordinal < ordinalCounter) {
            return values.get(ordinal);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static Colors findByName(String name) {
        return values.stream()
                .filter(it -> it.getName().equals(name))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    static {
        Field[] valuesFields = Colors.class.getDeclaredFields();
        for (Field field : valuesFields) {
            field.setAccessible(true);
            if (field.getType() == Colors.class) {
                String name = field.getName();
                try {
                    Colors it = (Colors) field.get(Class.class);
                    it.name = name;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
