package hus.oop.statistics;

public class LinkedListDataSet extends AbstractDataSet {
    private Node head;

    /**
     * Constructor to initialize the linked list.
     */
    public LinkedListDataSet() {
        this.head = null;
    }

    @Override
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public double get(int index) {
        Node node = getNodeByIndex(index);
        if (node != null) {
            return node.data;
        }
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
    }

    @Override
    public void set(double data, int index) {
        Node node = getNodeByIndex(index);
        if (node != null) {
            node.data = data;
        } else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
    }

    @Override
    public void append(double value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    @Override
    public void insert(double value, int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        Node newNode = new Node(value);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node previous = getNodeByIndex(index - 1);
            newNode.next = previous.next;
            previous.next = newNode;
        }
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node previous = getNodeByIndex(index - 1);
            previous.next = previous.next.next;
        }
    }

    private Node getNodeByIndex(int index) {
        if (index < 0 || index >= size()) {
            return null;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public double[] toArray() {
        double[] array = new double[size()];
        Node current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }
}
