import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

public class LinkedList<T> implements Iterable<LinkedList<T>> {
    private T data;
    private Optional<LinkedList<T>> tail;

    LinkedList(T data) {
        this.data = data;
        this.tail = Optional.empty();
    }

    private LinkedList(T data, Optional<LinkedList<T>> tail) {
        this.data = data;
        this.tail = tail;
    }

    public T getData() {
        // clone
        return this.data;
    }

    public Optional<LinkedList<T>> getTail() {
        // clone
        return this.tail;
    }

    @Override
    public Iterator<LinkedList<T>> iterator() {
        return new LinkedListIterator<>(this);
    }

    public void addItem(T data) {
        if (this.tail.isEmpty()) {
            this.tail = Optional.of(new LinkedList<>(data));
        } else {
            this.tail = Optional.of(new LinkedList<>(data, this.tail));
        }
    }

    public void appendItem(T data) {
        LinkedList<T> linkedList = this;
        for (LinkedList<T> tail : linkedList) {
            linkedList = tail;
        }
        linkedList.addItem(data);
    }

    public LinkedList<T> prependItem(T data) {
        return new LinkedList<>(data, Optional.of(this));
    }

}

class LinkedListIterator<T> implements Iterator<LinkedList<T>> {

    private Optional<LinkedList<T>> linkedList;

    LinkedListIterator(LinkedList<T> linkedList) {
        this.linkedList = Optional.of(linkedList);
    }

    @Override
    public boolean hasNext() {
        return this.linkedList.isPresent();
    }

    @Override
    public LinkedList<T> next() {
        if (this.linkedList.isPresent()) {
            LinkedList<T> currentLinkedList = this.linkedList.get();
            this.linkedList = currentLinkedList.getTail();
            return currentLinkedList;
        } else {
            throw new NoSuchElementException();
        }
    }
}