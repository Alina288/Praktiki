import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class radixsort implements Sorting<BigInteger> {

    @Override
    public void sort(List<BigInteger> nums) {
        // Создаем 10 корзин для цифр от 0 до 9
        List<List<BigInteger>> buckets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }

        BigInteger divider = BigInteger.ONE; // 1, 10, 100, 1000...

        // Проходим по всем 20 разрядам
        for (int step = 0; step < 20; step++) {
            // Раскладываем числа по корзинам в зависимости от текущей цифры
            for (BigInteger num : nums) {
                int digit = num.divide(divider).mod(BigInteger.TEN).intValue();
                buckets.get(digit).add(num);
            }

            // Собираем числа обратно в исходный список по порядку корзин
            nums.clear();
            for (List<BigInteger> bucket : buckets) {
                nums.addAll(bucket);
                bucket.clear(); // Очищаем корзину для следующего шага
            }

            // Переходим к следующему разряду (умножаем делитель на 10)
            divider = divider.multiply(BigInteger.TEN);
        }
    }
}