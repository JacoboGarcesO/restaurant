package co.com.restaurant.structures;

public class Queue {
    private Integer maxSize;
    private Integer size;
    private Node front;
    private Node rear;

    public Queue() {
    }

    public Queue(Integer maxSize) {
        this.maxSize = maxSize;
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void push(Object object) {
        if (this.isFull()) return;

        this.size ++;
        Node auxiliar = new Node(object);

        if (this.frontIsNull()) {
            this.front = auxiliar;
        } else {
            this.rear.setNext(auxiliar);
        }

        this.rear = auxiliar;
    }

    public Object pop() {
        if (this.isEmpty()) return null;
        this.size --;
        Object object = this.front.getObject();

        if (this.frontEqualsToRear()) {
            this.front = null;
            this.rear = null;
        } else {
            Node auxiliar = this.front;
            this.front = front.getNext();
            auxiliar.finalize();
        }

        return object;
    }

    public Object peek() {
        if (this.isEmpty()) return null;
        return this.front.getObject();
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }

    public boolean isFull() {
        return this.size >= this.maxSize;
    }

    private boolean frontEqualsToRear() {
        return this.front == this.rear;
    }

    private boolean frontIsNull() {
        return this.front == null;
    }
}
