package alqoritm;

import exception.ArrayIsFullException;
import exception.InvalidIndexException;
import exception.NullElementException;

public interface StringList {
    String add(String item);

    @Override
    String add(int index, String item);

    String set(int index, String item);

    String remove(String item);

    String remove(int index);

    boolean contains(String item);

    int indexOf(String item);

    int lastIndexOf(String item);

    String get(int index);

    boolean equals(StringList otherList);

    int size();

    boolean isEmpty();

    void clear();

    String[] toArray();

    default void validateElement(String element) {
        if (element == null) {
            throw new NullElementException();
        }
    }

    default void validateSize() {
        if (size == array.length) {
            throw new ArrayIsFullException();
        }
    }

    default void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }

    @Override
    String toString();
}
