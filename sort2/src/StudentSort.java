import java.util.List;

public class StudentSort implements Sorting<Student> {

    @Override
    public void sort(List<Student> students) {
        if (students == null || students.size() <= 1) {
            return;
        }
        // 1. Нестабильная сортировка (QuickSort) по возрасту
        quickSortByAge(students, 0, students.size() - 1);

        // 2. Стабильная сортировка (InsertionSort) по имени
        insertionSortByName(students);
    }

    // --- 1. НЕСТАБИЛЬНАЯ: QuickSort по возрасту ---
    private void quickSortByAge(List<Student> list, int low, int high) {
        if (low < high) {
            int pivotAge = list.get(low + (high - low) / 2).getAge();
            int i = low;
            int j = high;

            while (i <= j) {
                while (list.get(i).getAge() < pivotAge) {
                    i++;
                }
                while (list.get(j).getAge() > pivotAge) {
                    j--;
                }
                if (i <= j) {
                    Student swap = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, swap);
                    i++;
                    j--;
                }
            }
            if (low < j) quickSortByAge(list, low, j);
            if (high > i) quickSortByAge(list, i, high);
        }
    }

    // --- 2. СТАБИЛЬНАЯ: InsertionSort по имени ---
    private void insertionSortByName(List<Student> list) {
        for (int i = 1; i < list.size(); i++) {
            Student key = list.get(i);
            int j = i - 1;

            // ВАЖНО: строго > 0 для сохранения стабильности!
            // Если имена равны (compareTo == 0), сдвиг останавливается,
            // и более ранний студент (с меньшим возрастом) остаётся слева.
            while (j >= 0 && list.get(j).getName().compareTo(key.getName()) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }
}