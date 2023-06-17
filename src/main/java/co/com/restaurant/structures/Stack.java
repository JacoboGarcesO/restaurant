package co.com.restaurant.structures;

public class Stack {
    private Integer maxSize;
    private Integer size;
    private Node top;

    public Stack() {
    }

    public Stack(Integer maxSize) {
        this.maxSize = maxSize;
        this.top = null;
        this.size = 0;
    }

    public void push(Object object) {
        if (this.isFull()) return;

        this.size ++;
        Node auxiliar = new Node(object);
        auxiliar.setNext(this.top);
        this.top = auxiliar;
    }

    public Object pop() {
        if (this.isEmpty()) return null;

        Object object = top.getObject();
        if (this.nextIsNull()) {
            this.top = null;
        } else {
            Node auxiliar = this.top;
            this.top = top.getNext();
            auxiliar.finalize();
        }

        this.size --;
        return object;
    }

    public Object peek() {
        if (this.isEmpty()) return null;
        return this.top.getObject();
    }

    public boolean isEmpty() { return this.size <= 0; }

    public boolean isFull() { return this.size == this.maxSize; }

    private boolean nextIsNull() { return this.top.getNext() == null; }
}
