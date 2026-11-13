import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class radixsort implements Sorting<BigInteger> {

    @Override
    public void sort(List<BigInteger> nums) {

        List<List<BigInteger>> buckets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }

        BigInteger divider = BigInteger.ONE;

        for (int step = 0; step < 20; step++) {

            for (BigInteger num : nums) {
                int digit = num.divide(divider).mod(BigInteger.TEN).intValue();
                buckets.get(digit).add(num);
            }

            nums.clear();
            for (List<BigInteger> bucket : buckets) {
                nums.addAll(bucket);
                bucket.clear();
            }

            divider = divider.multiply(BigInteger.TEN);
        }
    }
}