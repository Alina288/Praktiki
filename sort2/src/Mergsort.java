import java.util.List;
public class Mergsort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        if (nums == null || nums.size() < 2) {
            return;
        }
        // Создаем один общий массив для сортировки
        Integer[] arr = new Integer[nums.size()];
        // Начинаем сортировку
        mergesort(nums, arr, 0, nums.size() - 1);
    }
    private void mergesort(List<Integer> lst, Integer[] arr, int start, int end) {
        // Если левая и правая граница встретились, остался 1 элемент, не режем
        if (start >= end) {
            return;
        }
        // Ищем середину
        int m = start + (end - start) / 2;
        mergesort(lst, arr, start, m);// Режем левую половину
        mergesort(lst, arr, m + 1, end); // Режем правую половину
        // Соединяем их по порядку
        mergeparts(lst, arr, start, m, end);
    }
    private void mergeparts(List<Integer> lst, Integer[] arr, int start, int m, int end) {
        int l = start;
        int r = m + 1;
        int k = start; // Индексы для записи
        // Сливаем элементы во временный массив arr
        while (l <= m && r <= end) {
            if (lst.get(l) <= lst.get(r)) {
                arr[k++] = lst.get(l++);
            } else {
                arr[k++] = lst.get(r++);
            }
        }
        // Дописываем остатки из левой
        while (l <= m) {
            arr[k++] = lst.get(l++);
        }
        // или правой части
        while (r <= end) {
            arr[k++] = lst.get(r++);
        }
        // Копируем обратно в исходный список
        for (int i = start; i <= end; i++) {
            lst.set(i, arr[i]);
        }
    }
}