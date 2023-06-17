package co.com.restaurant.structures;

import co.com.restaurant.entities.Client;

import javax.swing.*;

public class DoubleList {
    private Node start;
    private Node end;

    private Node auxiliary1;
    private Node auxiliary2;

    public DoubleList() {
        this.start = null;
        this.end = null;
    }

    public boolean isEmpty() {
        return this.getStart() == null;
    }

    public void insertFromStart(Object object) {
        if (this.isEmpty()) {
            this.setStart(new Node(object, null, null));
            this.setEnd(this.getStart());
        } else {
            this.getStart().setNext(new Node(object, null, this.getStart()));
            this.setStart(this.getStart().getNext());
        }
    }

    public void insertFromEnd(Object object) {
        if (this.isEmpty()) {
            this.setStart(new Node(object, null, null));
            this.setEnd(this.getStart());
        } else {
            this.getEnd().setNext(new Node(object, null, this.getEnd()));
            this.setEnd(this.getEnd().getNext());
        }
    }

    public void insertAtStart(DoubleList doubleList, Object object) {
        if (this.isEmpty())  {
            JOptionPane.showMessageDialog(null,"[ERROR]: En la lista no se puede insertar por el inicio sin tener al menos un dato.");
        } else {
            doubleList.insertFromStart(object);
        }
    }

    public void insertAtEnd(DoubleList doubleList, Object object) {
        if (this.isEmpty())  {
            JOptionPane.showMessageDialog(null,"[ERROR]: En la lista no se puede insertar por el final sin tener al menos un dato.");
        } else {
            doubleList.insertFromEnd(object);
        }
    }

    public boolean objectInList(DoubleList doubleList, String id) {
        this.auxiliary1 = doubleList.getStart();
        String auxiliaryId = ((Client) (this.auxiliary1.getObject())).getClientId();

        while (this.auxiliary1 != null && !auxiliaryId.equals(id)) {
            this.auxiliary1 = this.auxiliary1.getNext();
            if (this.auxiliary1 != null) {
                auxiliaryId = ((Client) (this.auxiliary1.getObject())).getClientId();
            }
        }

        return this.auxiliary1 == null;
    }

    public DoubleList insertBefore(DoubleList doubleList, Object object, String id) {
        if (this.isEmpty()) {
            JOptionPane.showMessageDialog(null,"[ERROR]: La lista está vacía.");
            return doubleList;
        }

        if (this.objectInList(doubleList, id)) {
            JOptionPane.showMessageDialog(null,"[ERROR]: El objeto no se encuentra en la lista.");
            return doubleList;
        }

        if (doubleList.getAuxiliary1() == this.getStart()) {
            doubleList.insertAtStart(doubleList, object);
        } else {
            this.auxiliary1.setBefore(new Node(object, this.auxiliary1, this.auxiliary1.getBefore()));
            this.auxiliary1.getBefore().getBefore().setNext(this.auxiliary1.getBefore());
        }

        return doubleList;
    }

    public DoubleList insertAfter(DoubleList doubleList, Object object, String id) {
        if (this.isEmpty()) {
            JOptionPane.showMessageDialog(null,"[ERROR]: La lista está vacía.");
            return doubleList;
        }

        if (this.objectInList(doubleList, id)) {
            JOptionPane.showMessageDialog(null,"[ERROR]: El objeto no se encuentra en la lista.");
            return doubleList;
        }

        if (doubleList.getAuxiliary1() == this.getEnd()) {
            doubleList.insertAtEnd(doubleList, object);
        } else {
            this.auxiliary1.setBefore(new Node(object, this.auxiliary1.getNext(), this.auxiliary1));
            this.auxiliary1.getNext().getNext().setBefore(this.auxiliary1.getNext());
        }

        return doubleList;
    }

    public String showStart(DoubleList doubleList) {
        String text = "";
        if (this.isEmpty()) {
            JOptionPane.showMessageDialog(null,"[ERROR]: La lista está vacía.");
            return text;
        }

        this.auxiliary1 = this.getStart();
        while (this.auxiliary1 != null) {
            text += this.auxiliary1.getObject().toString() + "\n";
            this.auxiliary1 = this.auxiliary1.getNext();
        }

        return text;
    }

    public String showEnd(DoubleList doubleList) {
        String text = "";
        if (this.isEmpty()) {
            JOptionPane.showMessageDialog(null,"[ERROR]: La lista está vacía.");
            return text;
        }

        this.auxiliary1 = this.getEnd();
        while (this.auxiliary1 != null) {
            text += this.auxiliary1.getObject().toString() + "\n";
            this.auxiliary1 = this.auxiliary1.getBefore();
        }

        return text;
    }

    public Object unlockStart() {
        if (this.isEmpty()) {
            JOptionPane.showMessageDialog(null,"[ERROR]: La lista vacía no se puede liberar.");
            return null;
        }

        Object auxiliary = this.getStart().getObject();

        if (this.getStart() == this.getEnd()) {
            getStart().finalize();
            setStart(null);
            setEnd(null);
        } else {
            setStart(getStart().getNext());
            getStart().getBefore().finalize();
            getStart().setBefore(null);
        }

        return auxiliary;
    }

    public Object unlockEnd() {
        if (this.isEmpty()) {
            JOptionPane.showMessageDialog(null,"[ERROR]: La lista vacía no se puede liberar.");
            return null;
        }

        Object auxiliary = this.getEnd().getObject();

        if (this.getStart() == this.getEnd()) {
            getEnd().finalize();
            setStart(null);
            setEnd(null);
        } else {
            setEnd(getEnd().getBefore());
            getEnd().getNext().finalize();
            getEnd().setNext(null);
        }

        return auxiliary;
    }

    public Object unlockElement(DoubleList doubleList, String id) {
        if (this.isEmpty()) {
            JOptionPane.showMessageDialog(null,"[ERROR]: La lista está vacía.");
            return doubleList;
        }

        if (this.objectInList(doubleList, id)) {
            JOptionPane.showMessageDialog(null,"[ERROR]: El objeto no se encuentra en la lista.");
            return doubleList;
        }

        if (this.auxiliary1 == doubleList.getStart()) {
            this.unlockStart();
        } else {
            if (this.auxiliary1 == doubleList.getEnd()) {
                this.unlockEnd();
            } else {
                this.auxiliary1.getBefore().setNext(this.auxiliary1.getNext());
                this.auxiliary1.getNext().setBefore(this.auxiliary1.getBefore());
                this.auxiliary1.finalize();
            }
        }

        return doubleList;
    }

    public Node getStart() {
        return start;
    }

    public void setStart(Node start) {
        this.start = start;
    }

    public Node getEnd() {
        return end;
    }

    public void setEnd(Node end) {
        this.end = end;
    }

    public Node getAuxiliary1() {
        return auxiliary1;
    }

    public void setAuxiliary1(Node auxiliary1) {
        this.auxiliary1 = auxiliary1;
    }

    public Node getAuxiliary2() {
        return auxiliary2;
    }

    public void setAuxiliary2(Node auxiliary2) {
        this.auxiliary2 = auxiliary2;
    }
}
