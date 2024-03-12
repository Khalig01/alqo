package test;

import alqoritm.IntegerListIml;
import alqoritm.IntegerList;
import alqoritm.IntegerListIml;
import exception.ArrayIsFullException;
import exception.ElementNotFoundException;
import exception.InvalidIndexException;
import exception.NullElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;
import static org.junit.jupiter.api.Assertions.*;
import org.assertj.core.api.Assertions;
    class IntegerTest {
       IntegerList integerList = new IntegerListIml();

        @BeforeEach
        void setUp() {
            integerList.add(1);
            integerList.add(2);
            integerList.add(3);
            integerList.add(4);
            integerList.add(5);
            integerList.add(6);
            integerList.add(7);
            integerList.add(8);
        }

        @Test
        void addTestOne() {
            assertThrows(NullElementException.class, () -> integerList.add(null));
            integerList.add(9);
            assertEquals(9, integerList.size());
            assertEquals(9, integerList.get(8));
            integerList.add(10);
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> integerList.add(11));

        }

        @Test
        void addTestTwo() {
            assertThrows(InvalidIndexException.class, () -> integerList.add(100, 8));
            integerList.add(8, 9);
            assertEquals(9, integerList.get(8));
            integerList.add(5, 12);
            assertEquals(12, integerList.get(5));
        }

        @Test
        void setTest() {
            assertEquals(5, integerList.set(4, 5));
        }

        @Test
        void removeTest(){
            assertThrows(ElementNotFoundException.class, () -> integerList.remove(777));
            integerList.remove(2);
            //    assertThat(integerList.toArray()).contains(new Integer(){2,4,5,8});


        };

        @Test
        void isEmptyTest() {
            integerList.add(1);
            assertFalse(integerList.isEmpty());
        }

        @Test
        void clearTest() {
            integerList.clear();
            assertEquals(0, integerList.size());
        }

        @Test
        void containsTest() {
            assertTrue(integerList.contains(7));
            assertFalse(integerList.contains(777));
        }

        @Test
        void indexOfTest() {
            assertEquals(2, integerList.indexOf(333));
            assertEquals(-1, integerList.indexOf(777));
            assertEquals(7, integerList.lastIndexOf(888));
            assertEquals(-1, integerList.lastIndexOf(777));
        }

        @Test
        void equalsTest() {
            IntegerList expected = new IntegerListIml(10);
            expected.add(1);
            expected.add(2);
            expected.add(3);
            expected.add(4);
            expected.add(5);
            expected.add(6);
            expected.add(7);
            expected.add(8);
            assertThat(integerList.equals(expected)).isTrue();
            assertArrayEquals(expected.toArray(), integerList.toArray());
            assertEquals(expected.toString(), integerList.toString());
        }

    }

