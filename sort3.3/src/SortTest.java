import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SortTest {
    public static void main(String[] args) {

        // 1. Проверка на Integer
        Sorting<Integer> numberSort = new InsertionSorter<>();
        List<Integer> numbers = new ArrayList<>(List.of(91, 12, 54, 3, 27, 12));
        numberSort.sort(numbers);
        System.out.println("Числа:     " + numbers);

        // 2. Проверка на String
        Sorting<String> wordSort = new InsertionSorter<>();
        List<String> words = new ArrayList<>(List.of("Дельта", "Альфа", "Гамма", "Бета"));
        wordSort.sort(words);
        System.out.println("Строки:    " + words);

        // 3. Проверка на Instant (время)
        Sorting<Instant> timeSort = new InsertionSorter<>();
        List<Instant> timestamps = new ArrayList<>(List.of(
                Instant.parse("2026-11-12T18:00:00Z"),
                Instant.parse("2026-03-08T09:15:00Z"),
                Instant.parse("2026-07-21T12:45:00Z")
        ));
        timeSort.sort(timestamps);
        System.out.println("Время:     " + timestamps);

        // 4. Проверка на Student
        Sorting<Student> studentSort = new InsertionSorter<>();
        List<Student> group = new ArrayList<>(List.of(
                new Student("Мария", 20),
                new Student("Дмитрий", 19),
                new Student("Елена", 21),
                new Student("Дмитрий", 18)
        ));
        studentSort.sort(group);
        System.out.println("Студенты:  " + group);

        // 5. Проверка на UUID
        Sorting<UUID> idSort = new InsertionSorter<>();
        List<UUID> ids = new ArrayList<>(List.of(
                UUID.fromString("d9b2d63d-a233-4123-847a-7c35d9b2d63d"),
                UUID.fromString("123e4567-e89b-12d3-a456-426614174000"),
                UUID.fromString("7c9e6679-7425-40de-944b-e07fc1f90ae7")
        ));
        idSort.sort(ids);
        System.out.println("UUID:      " + ids);
    }
}