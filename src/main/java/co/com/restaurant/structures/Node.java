package co.com.restaurant.structures;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Node {
    private Object object;
    private Node next;
    private Node before;

    public Node() {
    }

    public Node(Object data) {
        this.object = data;
        this.next = null;
    }

    public Node(Object data, Node next, Node before) {
        this.object = data;
        this.next = next;
        this.before = before;
    }

    public void finalize() {
        try {
            super.finalize();
        } catch (Throwable throwable) {
            Logger.getLogger(Node.class.getName()).log(Level.SEVERE, null, throwable);
        }
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getBefore() {
        return before;
    }

    public void setBefore(Node before) {
        this.before = before;
    }

    @Override
    public String toString() {
        return this.getObject().toString();
    }
}
