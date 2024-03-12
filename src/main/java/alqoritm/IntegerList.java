package alqoritm;

import exception.InvalidIndexException;
import exception.NullElementException;

//import static jdk.internal.jrtfs.JrtFileAttributeView.AttrID.size;


public interface IntegerList {
    Integer add(Integer item);


    Integer add(int index, Integer item);

    Integer set(int index, Integer item);

    Integer remove(Integer item);

    Integer remove(int index);

    boolean contains(Integer item);

    int indexOf(Integer item);

    int lastIndexOf(Integer item);

    Integer get(int index);

    boolean equals(IntegerList otherList);

    int size();

    boolean isEmpty();

    void clear();

    Integer[] toArray();

    default void validateElement(Integer element) {
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
