package alqoritm;

import exception.ArrayIsFullException;
import exception.InvalidIndexException;
import exception.NullElementException;

import java.io.OptionalDataException;

//import static jdk.internal.jrtfs.JrtFileAttributeView.AttrID.size;


public interface StringList {
    String add(String item);


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
    //    if (size == size.lenght);
    }

    default void validateIndex(int index) {
        if ((index < 0) || (index > size())) {
            throw new InvalidIndexException();
        }
    }

    @Override
    String toString();
}
