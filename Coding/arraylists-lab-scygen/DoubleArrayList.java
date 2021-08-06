//
// Objects of this class type store a list of double values,
// each having a position in the list. 
//
/**
 * @author Nick Giordano, Yuwei Chen
 * 
 */
public class DoubleArrayList {

    // array storing the elements in positions 0...currentSize-1
    private double[] elements; 
    // number of elements in the list
    private int currentSize;  

    /**
     * Initializes an empty list with a capacity of 10.
     */
    public DoubleArrayList() {
        final int INITIAL_SIZE = 10;
        elements = new double[INITIAL_SIZE];
        currentSize = 0;
    }

    /**
     * Initializes an empty list with the specified initial
     * capacity. initialCapacity must be > 0. If initialCapacity
     * is <= 0, then it initializes an empty list with
     * capacity 10.
     * @param initialCapacity initial capacity of list
     */
    public DoubleArrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            elements = new double[10];
        }
        else {
            elements = new double[initialCapacity];
        }
        currentSize = 0;
    }

    /** 
     * Valid positions for elements in the list range
     * from 0 to currentSize-1. This method checks
     * that pos is valid. If pos is not in this
     * range, then it throws the IndexOutOfBounds 
     * exception. Otherwise, it does nothing.
     * @param pos a position in the list
     * @throws IndexOutOfBoundsException 
     *         if pos < 0 or pos >= currentSize
     */
    private void checkBounds(int pos) {
        if ((pos < 0) || (pos >= currentSize)) {
            throw new IndexOutOfBoundsException();
        }
    }

    /** 
     * Returns the element at position pos in the list.
     * pos must be in the range [0...currentSize-1]. 
     * If it is not, then the IndexOutOfBounds exception
     * is thrown.
     * @param pos the position of the desired element
     * @return the indicated element.
     * @throws IndexOutOfBoundsException if pos < 0 or pos >= currentSize. 
     */
    public double get(int pos) {
        checkBounds(pos);
        return elements[pos];
    }

    /** 
     * A simplistic add method that adds the 
     * element to the end of the list, if there is room for it.
     * However, if the list is at its maximum capacity, then this
     * method does not add the element. It just returns false.
     * @param element the element to be added
     * @return true if the element is sucessfully added, false otherwise
     */
    public boolean addSimple(double element) {
        if (elements == null) return false; // helps with test program
        if (currentSize >= elements.length) {
            return false; // no room
        }

        elements[ currentSize ] = element;
        currentSize++;
        return true;
    }

    /**
     * Returns the number of elements in the list
     * @return the number of list elements
     */
    public int size() {
        return currentSize;
    }

    /**
     * Sets the element at position pos to element. 
     * @param pos the position of the element to be replaced
     * @param element the element that will replace the 
     *    one at the indicated position        
     * @throws IndexOutOfBoundsException if pos < 0 or pos >= currentSize. 
     */
    public void set(int pos, double element) {
        elements[pos] = element;
    }

    /** 
     * Removes the element at position pos from the list
     * and returns it. Entries originally at positions 
     * higher than the given position are at the next 
     * lower position within the list, and the list size 
     * is decreased by 1.
     * @param pos position of the element to be removed
     * @return the removed element
     * @throws IndexOutOfBoundsException 
     *         if pos < 0 or pos >= currentSize
     */
    public double remove(int pos) {
        double temp = elements[pos];
        for(int i=pos; i<currentSize-1;i++){
            elements[i] = elements[i+1];
        }
        currentSize--;
        return temp;
    }

    /** 
     * Clears all elements from the list, resulting in a empty list.
     * You may NOT call any other method in your implementation
     * of this!
     */
    public void clear() {
        currentSize = 0;
    }

    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //
    // STOP HERE! REFER TO THE LAB INSTRUCTIONS BEFORE CONTINUING
    //
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    /**
     * This goes through the array and searches for the number(num), if 
     * it is in the array, it returns true. Otherwise returns false.
     * 
     * @param num  This is the number being searched for
     * 
     * @return  true if num is in array
     */
    public boolean contains(double num){
        boolean flag = false;
        for(int i=0; i<currentSize;i++){
            if(num==elements[i]){
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Returns a reference to a new DoubleArrayList object that is a copy
     * of this DoubleArrayList. The copy contains the same
     * ordered list of elements as the list and has the same capacity. 
     * Make sure the elements array of the copy is distinct from 
     * that of this list. In other words, this list and the copy 
     * must each have their own, separate elements arrays. 
     * @return a copy of the list
     */
    public DoubleArrayList getCopy() {
        DoubleArrayList temp = new DoubleArrayList(elements.length);
        for(int i = 0; i < currentSize; i++)
        {
            temp.elements[i] = elements[i];
        }
        temp.currentSize = currentSize;
        return temp;
    }

    /**
     * Returns the capacity of the list, which is the largest number
     * of elements the array elements[] is capable of holding.
     * In other words, it is the size of array elements[].
     * @return the capacity of the list
     */
    public int getCapacity() {
        return elements.length;
    }

    /**
     * Ensures that the capacity of the list is at least
     * the specified amount minCapacity. If the list 
     * capacity is already >= minCapacity, then no 
     * action is taken.
     * @param minCapacity the desired minimum capacity
     */
    public void ensureCapacity(int minCapacity) {
        if(elements.length < minCapacity)
        {
            double[] temp = new double[minCapacity];
            for(int i = 0; i < currentSize; i++)
            {
                temp[i] = elements[i];
            }
            elements = temp;
        }

    }

    /** 
     * This is a smart add method (unlike the previous
     * addSimple method that was provided for you.)
     * This method adds the element to the end of the list.
     * If the list is at its maximum capacity, its
     * capacity is doubled to make room for the element.
     * @param element the new element to be added
     * 
     * You may call ensureCapacity in this method, but you
     * may NOT CALL ANY OTHER METHODS HERE.
     */
    public void add(double element) {
        if(currentSize == elements.length)
        {
            ensureCapacity(2*elements.length);
            elements[currentSize] = element;
            currentSize++;
        }
        else{
            elements[currentSize] = element;
            currentSize++;
        }
    }

    /** 
     * Adds a new element at a specified position within the list.
     * If the list is at its maximum capacity, its
     * capacity is first doubled to make room for the new element.
     * Entries originally at and above the specified position
     * are moved to the next higher position within the list.
     * The list size is increased by 1. Note that pos must
     * be in the range [0...currentSize]. It is ok if pos is
     * equal to currentSize -- in this case it merely adds 
     * the new element as the last item in the list.
     * @param pos the desired position of the new element
     * @param element the element to be added 
     * @throws IndexOutOfBoundsException 
     *               if pos < 0 or pos > currentSize. 
     *               
     * You may call ensureCapacity in this method, but you
     * may NOT CALL ANY OTHER METHODS HERE.     *
     */
    public void add(int pos, double element) {
        if(currentSize == elements.length)
        {
            ensureCapacity(2*currentSize);
            for(int i = pos; i<currentSize;i++){
                elements[i+1] = elements[i]; 
            }
            elements[pos] = element;
            currentSize++;
        }
        else{
            double temp2 = elements[pos];
            for(int i = pos; i<currentSize;i++){
                double temp = elements[i+1];
                elements[i+1] = temp2; 
                temp2 = temp;
            }
            elements[pos] = element;
            currentSize++;
        }
    }

    /** 
     * Adds all elements in addend to the end of this list, in
     * the order in which they occur in addend.
     * If this list's capacity is insufficient to hold all the new
     * elements, its capacity is first increased to 
     * this.size() + addend.size(). 
     * @param addend list containing elements to add
     * 
     * You may call ensureCapacity in this method, but you
     * may NOT CALL ANY OTHER METHODS HERE.
     */
    public void addAll(DoubleArrayList addend) {
        if(currentSize == elements.length){
            ensureCapacity(currentSize + addend.size());
            for(int i = 0; i < addend.size(); i++){
                elements[currentSize] = addend.get(i);
                currentSize++;
            }
        }
        else{
             ensureCapacity(currentSize + addend.size());
            for(int i = 0; i < addend.size(); i++){
                elements[currentSize] = addend.get(i);
                currentSize++;
            }
        }
    }

    /** 
     * Adds all elements in addpos into this list at the specified
     * position, in the order in which they occur in addend.
     * If this list's capacity is insufficient to hold all the new
     * elements, its capacity is first increased to 
     * this.size() + addpos.size(). 
     * 
     * For example, if list A contains {0, 10, 20, 30} and
     * list B contains {5, 15, 25} and A.addAll(2, B)
     * is called, then after the call A would contain
     * {0, 10, 5, 15, 25, 20, 30}.
     * @param addpos list containing elements to add
     * 
     * You may call ensureCapacity in this method, but you
     * may NOT CALL ANY OTHER METHODS HERE.
     */
    public void addAll(int pos, DoubleArrayList addpos) {
        if(currentSize == elements.length){
            ensureCapacity(currentSize + addpos.size());
            for(int i = 0; i < addpos.size(); i++){
                currentSize++;
                double temp2 = elements[pos];
                for(int r = pos; r < currentSize; r++){
                    double temp = elements[r+1];
                    elements[r+1] = temp2; 
                    temp2 = temp;
                }
                elements[pos] = addpos.get((addpos.size()-1)-i);
            }
        }
        else{
            for(int i = 0; i < addpos.size(); i++){
                currentSize++;
                double temp2 = elements[pos];
                for(int r = pos; r < currentSize; r++){
                    double temp = elements[r+1];
                    elements[r+1] = temp2; 
                    temp2 = temp;
                }
                elements[pos] = addpos.get((addpos.size()-1)-i);
            }
            //currentSize += addpos.size();
        }
    }

}
