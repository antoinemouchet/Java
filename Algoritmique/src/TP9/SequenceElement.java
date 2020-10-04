package TP9;

/**
 * A class representing a T element as a couple (value, tail). This class is used by collections to represent
 * sequences of elements
 */
class SequenceElement<T> {

    /**
     * The value of the list element
     */
    private T value;

    /**
     * The rest of the list of null if there is none.
     */
    private SequenceElement<T> tail;

    /**
     * Builds a new list element using the given value and tail.
     *
     * @modifies this.
     * @ensures this = (value, tail)
     */
    public SequenceElement(T value, SequenceElement tail){
        this.value = value;
        this.tail = tail;
    }

    /**
     * Returns the value of this list element.
     *
     * @ensures return = value
     */
    public T getValue(){
        return value;
    }

    /**
     * Returns the value rest of the list or null if there is none.
     *
     * @ensures return = tail
     */
    public SequenceElement<T> getTail(){
        return tail;
    }

    /**
     * Sets the value of this list element.
     *
     * @modifies this
     * @ensures this = (val, tail)
     */
    public void setValue(T val){
        this.value = val;
    }

    /**
     * Sets the next element of the list or null if there is none
     *
     * @modifies this
     * @ensures this = (value, newTail)
     */
    public void setTail(SequenceElement<T> newTail){
        this.tail = newTail;
    }
}
