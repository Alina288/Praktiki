import java.util.List;

public class countingsort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        int[] counts = new int[128];

        for (int num : nums) {
            counts[num]++;
        }
        int index = 0;
        for (int val = 0; val < counts.length; val++) {
            while (counts[val] > 0) {
                nums.set(index, val);
                index++;
                counts[val]--;
            }
        }
    }
}