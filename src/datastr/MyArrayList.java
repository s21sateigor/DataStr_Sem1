package datastr;

public class MyArrayList<T> {
    private T[] elements;
    private final int DEFAULT_ARRAY_SIZE = 6;
    private int arraySize = DEFAULT_ARRAY_SIZE;
    private int elementCounter = 0;

    // no-args kontruktors
    public MyArrayList() {
        elements = (T[]) new Object[arraySize]; // will be with size 6 (DEFAULT_ARRAY_SIZE)
    }

    // args konstruktors
    public MyArrayList(int inputArraySize) {
        if (inputArraySize > 0) {
            arraySize = inputArraySize;
        }

        elements = (T[]) new Object[arraySize];
    }

    // TODO create isFull and isEmpty functions
    public boolean isEmpty() {
        // long if-else
        /*
         * if(elementCounter == 0) { return true; } else { return false; }
         */
        // for example
        /*
         * return (arraySize< elementCounter) ? "var ievietot" : "nevar ievietot"; if
         * (arraySize< elementCounter) { return "var ievietot" ; } else { return
         * "nevar ievietot"; }
         */

        // short if-else
        // kopējais (if izteiksme) ? ko darīt true : ko darīt false gadījumā;
        // return (elementCounter == 0)? true : false;

        return (elementCounter == 0);

    }

    public boolean isFull() {
        return (elementCounter == arraySize);
    }

    public int howManyElements() {
        return elementCounter;
    }

    // 1. create a definition of function increaseArray
    private void increaseArray() {
        // 2. calculate the new size of the new array
        int newArraySize = (arraySize > 100) ? (int) (arraySize * 1.5) : arraySize * 2;

        /*
         * int newArraySize = arraySize *2; if(arraySize>100) { newArraySize = (int)
         * (arraySize*1.5); }
         */
        /*
         * int newArraySize; if(arraySize > 100) { newArraySize = (int)(arraySize *1.5);
         * } else { newArraySize =arraySize * 2; }
         */
        // 3. create the new array
        T[] newElements = (T[]) new Object[newArraySize];
        // 4. copy all elements from the old array to the new array
        for (int i = 0; i < elementCounter; i++) {
            newElements[i] = elements[i];
        }
        // 5. change reference to the new array and it's size
        elements = newElements;
        arraySize = newArraySize;
    }

    // 1. create a definition of function add
    public void add(T newElement) {
        // 2. verify if the array is full
        if (isFull()) {
            // 2.1. call an increaseArray() func.
            increaseArray();
        }

        // 3. add the new element in the array
        // the non-optimize option
        elements[elementCounter] = newElement;
        elementCounter++;
        // the optimize option
        // elements[elementCounter++] = newElement;

        // 4. increase elementCounter
    }

    // TODO
    // 1. create a definition of function add
    public void add(T newElement, int index) throws Exception {
        // 2. verify the index - is it appropriate
        if (index >= 0 && index <= elementCounter) {
            // 3.5 verify if the index is equal with elementCounter
            if (index == elementCounter) {
                add(newElement);
            } else {
                // 3. verify isFull
                if (isFull()) {
                    increaseArray();
                }
                // 4. copy from the end to the right side (using the index)
                for (int i = elementCounter; i > index; i--) {
                    elements[i] = elements[i - 1];
                }
                // 5. add the new element in the specified index
                elements[index] = newElement;
                // 6. increase elementCounter
                elementCounter++;
            }

        } else {
            throw (new Exception("Wrong index"));
        }
    }

    // 1. create a definition of function add
    public void remove(int index) throws Exception {
        // 2. verify isEmpty
        if (isEmpty()) {
            throw (new Exception("Array is empty and it is not possible to remove elements"));
        } else {
            // 3. verify the index - is it not appropriate
            if (index < 0 || index >= elementCounter) {
                throw (new Exception("Wrong index"));
            } else {
                // 4. copy elements from index to end
                for (int i = index; i < elementCounter - 1; i++) {
                    elements[i] = elements[i + 1];
                }
                // 5. initialize the last element to null reference
                elements[elementCounter - 1] = null;

                // 6. decrease elementCounter
                elementCounter--;

                // for optimization
                // elements[--elementCounter] = 0;
            }
        }
    }

    public T retrieve(int index) throws Exception {
        if (isEmpty()) {
            throw (new Exception("Array is empty and it is not possible to retrieve elements"));
        } else {
            if (index < 0 || index >= elementCounter) {
                throw (new Exception("Wrong index"));
            } else {
                return elements[index];
            }
        }
    }

    public boolean search(T inputElement) {

        for (int i = 0; i < elementCounter; i++) {
            if (elements[i].equals(inputElement)) {
                return true;
            }
        }

        return false;

    }

    // TODO retrieveNextNeigbour
    public T[] retrieveNextNeigbours(T inputElement) throws Exception {
        // true case
        if (search(inputElement)) {
            int howManySearchedElements = 0;
            for (int i = 0; i < elementCounter; i++) {
                if (elements[i].equals(inputElement)) {
                    howManySearchedElements++;
                }
            }
            if (elements[elementCounter - 1].equals(inputElement)) {
                howManySearchedElements--;
            }

            T[] nextNeigbours = (T[]) new Object[howManySearchedElements];
            int indexForNeigbors = 0;
            for (int i = 0; i < elementCounter - 1; i++) {
                if (elements[i].equals(inputElement)) {
                    nextNeigbours[indexForNeigbors] = elements[i + 1];
                    indexForNeigbors++;
                }
            }
            return nextNeigbours;

        }
        // false case
        else {
            throw (new Exception("Input element is not found in the array"));
        }
    }

    public T[] sort(SortingType type) throws Exception {

        if (isEmpty()) {
            throw (new Exception("Array is empty and it is not possible to sort"));
        } else {
            T[] sortArray = (T[]) new Object[elementCounter];

            for (int i = 0; i < elementCounter; i++) {
                sortArray[i] = elements[i];
            }

            int sortVariable = 1; // DESC
            if (type == SortingType.ASC) {
                sortVariable = -1;
            }

            for (int i = 0; i < elementCounter; i++) {
                for (int j = 0; j < elementCounter; j++) {
                    // if(sortArray[i] < sortArray[j] )
                    //System.out.println(sortArray[i]);
                    //System.out.println(sortArray[j]);
                    //System.out.println(((Comparable)sortArray[i]).compareTo(sortArray[j]));
                    //TODO create this for descending
                    //ascending
                    if (((Comparable)sortArray[i]).compareTo(sortArray[j]) < 0) { // 0 6
                        T temp = sortArray[i];
                        sortArray[i] = sortArray[j];
                        sortArray[j] = temp;
                    }
                }
            }

            return sortArray;
        }

    }

    public void print() throws Exception {
        if (isEmpty()) {
            throw (new Exception("Array is empty and it is not possible to print elements"));
        } else {
            for (int i = 0; i < elementCounter; i++) {
                System.out.print(elements[i] + " ");
            }
            System.out.println();
        }
    }

    public void makeEmpty() {
        arraySize = DEFAULT_ARRAY_SIZE;
        elementCounter = 0;
        elements = (T[]) new Object[arraySize];
        System.gc();
    }

}