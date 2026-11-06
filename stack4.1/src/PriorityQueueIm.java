import java.util.ArrayList;

public class PriorityQueueIm implements PriorityQueue<Integer> {

    private static class Node {
        int value;
        long operationNumber;

        Node(int value, long operationNumber) {
            this.value = value;
            this.operationNumber = operationNumber;
        }
    }

    private final ArrayList<Node> queue = new ArrayList<>();

    private final ArrayList<Integer> opToIndex = new ArrayList<>();
    private long operationCounter = 0;

    public PriorityQueueIm() {
        opToIndex.add(-1);
    }

    @Override
    public void enqueue(Integer value) {
        operationCounter++;
        int currentIndex = queue.size();

        queue.add(new Node(value, operationCounter));

        opToIndex.add(currentIndex);

        siftUp(currentIndex);
    }

    @Override
    public Integer dequeueMax() {
        if (queue.isEmpty()) {
            System.out.println("*");
            return null;
        }

        Node maxElement = queue.get(0);
        System.out.println(maxElement.operationNumber + " " + maxElement.value);

        opToIndex.set((int) maxElement.operationNumber, -1);

        Node lastElement = queue.remove(queue.size() - 1);

        if (!queue.isEmpty()) {
            queue.set(0, lastElement);

            opToIndex.set((int) lastElement.operationNumber, 0);
            siftDown(0);
        }

        return maxElement.value;
    }

    @Override
    public void increment(long operation, Integer addition) {

        if (operation >= opToIndex.size() || opToIndex.get((int) operation) == -1) {
            return;
        }

        int indexInQueue = opToIndex.get((int) operation);

        Node current = queue.get(indexInQueue);
        current.value += addition;

        siftUp(indexInQueue);
    }

    private void swap(int i, int j) {
        Node nodeI = queue.get(i);
        Node nodeJ = queue.get(j);

        queue.set(i, nodeJ);
        queue.set(j, nodeI);

        opToIndex.set((int) nodeI.operationNumber, j);
        opToIndex.set((int) nodeJ.operationNumber, i);
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;

            if (queue.get(index).value <= queue.get(parentIndex).value) {
                break;
            }

            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void siftDown(int index) {
        while (2 * index + 1 < queue.size()) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int largestChild = leftChild;

            if (rightChild < queue.size() && queue.get(rightChild).value > queue.get(leftChild).value) {
                largestChild = rightChild;
            }

            if (queue.get(index).value >= queue.get(largestChild).value) {
                break;
            }

            swap(index, largestChild);
            index = largestChild;
        }
    }
}