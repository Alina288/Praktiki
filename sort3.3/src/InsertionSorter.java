import java.util.List;

public class InsertionSorter<T extends Comparable<T>> implements Sorting<T> {

    @Override
    public void sort(List<T> items) {
        if (items == null || items.size() < 2) {
            return;
        }

        for (int outer = 1; outer < items.size(); outer++) {

            for (int inner = outer; inner > 0; inner--) {
                T left = items.get(inner - 1);
                T right = items.get(inner);

                if (left.compareTo(right) > 0) {
                    items.set(inner - 1, right);
                    items.set(inner, left);
                } else {
                    // Как только нашли элемент <= текущему, левая часть уже отсортирована
                    break;
                }
            }
        }
    }
}
