import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class HashMapImpl<V> implements HashMap<String, V> {
    private static final int TABLE_SIZE = 300007;
    private static final int A = 31;

    private final ArrayList<LinkedList<Entry<V>>> table;

    private static class Entry<V> {
        String key;
        V value;

        Entry(String key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashMapImpl() {
        table = new ArrayList<>(TABLE_SIZE);
        for (int i = 0; i < TABLE_SIZE; i++) {
            table.add(null);
        }
    }

    private long hashByString(String value) {
        long hash = 0;
        for (Character ch : value.toCharArray()) {
            hash = (hash * A + ch) % TABLE_SIZE;
        }
        return hash;
    }

    @Override
    public void put(String key, V value) {
        int index = (int) hashByString(key);
        LinkedList<Entry<V>> bucket = table.get(index);

        if (bucket == null) {
            bucket = new LinkedList<>();
            table.set(index, bucket);
        }

        for (Entry<V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        bucket.add(new Entry<>(key, value));
    }

    @Override
    public V getValue(String key) {
        int index = (int) hashByString(key);
        LinkedList<Entry<V>> bucket = table.get(index);

        if (bucket == null) {
            return null;
        }

        for (Entry<V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }

    @Override
    public V delete(String key) {
        int index = (int) hashByString(key);
        LinkedList<Entry<V>> bucket = table.get(index);

        if (bucket == null) {
            return null;
        }

        Iterator<Entry<V>> iterator = bucket.iterator();
        while (iterator.hasNext()) {
            Entry<V> entry = iterator.next();
            if (entry.key.equals(key)) {
                V deletedValue = entry.value;
                iterator.remove();
                return deletedValue;
            }
        }

        return null;
    }
}
