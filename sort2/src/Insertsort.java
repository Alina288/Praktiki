import java.util.List;

public class Insertsort implements Sorting<Integer> {

    @Override
    public void sort(List<Integer> nums) {
        if (nums == null || nums.size() <= 1) {
            return;
        }

        int n = nums.size();

        for (int i = 0; i < n; i++) {
            Integer element = nums.get(i);
            int j = i;

            // Цикл смещения элементов влево
            while (j > 0 && nums.get(j - 1).compareTo(element) > 0) {
                nums.set(j, nums.get(j - 1));
                j = j - 1;
            }

            // Вставляем элемент на его финальное место
            nums.set(j, element);
        }
    }
}
