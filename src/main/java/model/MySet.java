package model;

import java.util.Random;

class MySet<E> implements SimpleSet<E> {
    private E[] backingArray;
    private int numElements;
    private Random rand = new Random();

    public MySet(int length) {
        backingArray = (E[]) new Object[length];
        numElements = 0;
    }

    public MySet() {
        this(5);
    }

    /**
    * Adds the passed in element to the set.
    * @param e the element to be added to the set
    */
    @Override
    public boolean add(E e) {
        if (!contains(e)) {
            if (isFull()) {
                expand();
            }
            backingArray[findNull()] = e;
            numElements++;
            return true;
        } else {
            return false;
        }
    }

    public int findNull() {
        int index = 0;
        for (int i = 0; i < backingArray.length; i++) {
            if (null == backingArray[i]) {
                index = i;
            }
        }

        return index;
    }

    public int find(E e) {
        int index = 0;
        for (int i = 0; i < backingArray.length; i++) {
            if (e.equals(backingArray[i])) {
                index = i;
            }
        }

        return index;
    }

    /**
    * Removes the passed in element from the set if it is
    * contained in the set, then returns the removed element
    * otherwise throws as ElementDoesNotExistException
    * @param e the element to be removed
    * @return E the element that was removed
    */
    @Override
    public E remove(E e) throws ElementDoesNotExistException {
        if (contains(e)) {
            backingArray[find(e)] = null;
            numElements--;
            return e;
        } else {
            throw new ElementDoesNotExistException("Can't remove, not in set");
        }
    }

    /**
    * Returns true if the passed in element is contained in
    * the set.
    * Returns false if the passed in element is not contained
    * in the set.
    * @param e the element to be checked
    * @return whether the passed in element is contained
    * in the set
    */
    @Override
    public boolean contains(E e) {
        boolean contain = false;

        for (E thing : backingArray) {
            if (thing != null && thing.equals(e)) {
                contain = true;
            }
        }

        return contain;
    }

    /**
    * removes all the passed in elements from the set then returns them
    * throws a ElementDoesNotExistException if one of the passed in elements
    * is not in the set.
    * NOTE: this method should not remove ANY elements from the set
    * if it throws a ElementDoesNotExistException
    * @param e the elements to be removed from the set
    * @return E[] the elements that were removed from the set
    */
    @Override
    public E[] removeAll(E[] e) throws ElementDoesNotExistException {
        boolean canRemove = true;
        E[] returnArray = (E[]) new Object[e.length];

        for (E thing : e) {
            if (!contains(thing)) {
                canRemove = false;
            }
        }

        if (canRemove) {
            for (int i = 0; i < e.length; i++) {
                remove(e[i]);
                numElements--;
                returnArray[i] = e[i];
            }

            return returnArray;
        } else {
            throw new ElementDoesNotExistException("removeAll: Not in set");
        }
    }

    /**
    * Removes all elements from the set.
    */
    @Override
    public void clear() {
        backingArray = (E[]) new Object[5];
        numElements = 0;
    }

    /**
    * Returns the number of elements contained in the set.
    * @return int the number of elements in the set
    */
    @Override
    public int size() {
        return numElements;
    }

    /**
    * Returns false if the set contains 1 or more elements and
    * returns true if the set contains no elements.
    * @return boolean whether the set contains any elements
    */
    @Override
    public boolean isEmpty() {
        boolean empty = true;

        for (E thing : backingArray) {
            if (null != thing) {
                empty = false;
            }
        }

        return empty;
    }

    public boolean isFull() {
        boolean full = true;

        for (E thing : backingArray) {
            if (null == thing) {
                full = false;
            }
        }

        return full;
    }

    public void expand() {
        E[] copyArray = (E[]) new Object[backingArray.length * 2];
        for (int i = 0; i < backingArray.length; i++) {
            copyArray[i] = backingArray[i];
        }

        backingArray = copyArray;
    }

    /**
    * Returns a random element from the set.
    * NOTE: because the set has no ordering returning any element in the
    * set is effectively returning a "random" element
    * throws a ElementDoesNotExistException if there are no elements
    * in the set
    * HINT: you may import java.util.Random to help with this if
    * you want
    * @return E a random element from the set
    */
    @Override
    public E getRandomElement() throws ElementDoesNotExistException {
        if (isEmpty()) {
            throw new ElementDoesNotExistException("Random: empty");
        }

        E[] elements = toArray();
        return elements[rand.nextInt(elements.length)];
    }

    /**
    * Returns an array of all the elements contained within the SimpleSet.
    * There should be no nulls in the array.
    * @return an array containing all the elements contained
    * within the set
    */
    @Override
    public E[] toArray() {
        E[] notNull = (E[]) new Object[numElements];
        int index = 0;
        for (int i = 0; i < backingArray.length; i++) {
            if (backingArray[i] != null) {
                notNull[index] = backingArray[i];
                index++;
            }
        }

        return notNull;
    }

    /**
    * Calculates and returns a String representation of this object.
    * Any String that shows each individual element's toString
    * is acceptable.
    * @return String the String representation of this object
    */
    @Override
    public String toString() {
        String returnString = "";
        E[] elements = toArray();
        for (E thing : elements) {
            returnString += thing.toString() + " ";
        }
        returnString.trim();

        return returnString;
    }
}
