public class Stack implements MinStack<Integer> {

    private class Element {
        Integer data;
        Integer minVal;
        Element prev;
    }

    private Element topElement;
    @Override
    public void push(Integer value) {
        Element newEl = new Element();
        newEl.data = value;
        newEl.prev = topElement;

        if (topElement == null || value < topElement.minVal) {
            newEl.minVal = value;
        } else {
            newEl.minVal = topElement.minVal;
        }

        topElement = newEl;
    }
    @Override
    public Integer pop() {
        Integer result = topElement.data;
        topElement = topElement.prev;
        return result;
    }
    @Override
    public Integer top() {
        return topElement.data;
    }
    @Override
    public Integer min() {
        return topElement.minVal;
    }
}