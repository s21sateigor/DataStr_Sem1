package datastr;

public class MyArrayList {
    private char[] elements;
    private final int DEFAULT_ARRAY_SIZE = 6;
    private int arraySize = DEFAULT_ARRAY_SIZE;
    private int elementCounter = 0;


    public MyArrayList() {
        elements = new char[arraySize]; //array with 6 cells
    }

    public MyArrayList(int inputArraySize) {
        if (inputArraySize > 0) {
            arraySize = inputArraySize;
        }
        elements = new char[arraySize];
    }

    public boolean isFull() {
//        if(arraySize == elementCounter){
//            return true;
//        }
//        return isFull();
        return (elementCounter == arraySize);
    }

    public boolean isEmpty() {
        return elementCounter == 0;
//        if (elementCounter == 0) {
//            return true;
//        } else {
//            return isEmpty();
//        }
    } // short if-else
    //return (elementCounter == 0) ? true : false;

    //var vēl īsāk
    //return (elementCounter == 0);

    public int howManyElements() {
        return elementCounter;
    }

    private void increaseArray() {

        int newArraySize = (arraySize > 100) ? (int) (arraySize * 1.5) : arraySize * 2;

        char[] newElements = new char[newArraySize];

        for (int i = 0; i < elementCounter; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        arraySize = newArraySize;
    }

    public void add(char newElement) {
        if (isFull()) {
            increaseArray();
        }

        elements[elementCounter] = newElement;
        elementCounter++;
    }

    public void add(char newElement, int index) throws Exception {
        if (index >= 0 && index <= elementCounter) {
            if (index == elementCounter) {
                add(newElement);
            } else {
                if (isFull()) {
                    increaseArray();
                }
                for (int i = elementCounter; i > index; i--) {
                    elements[i] = elements[i - 1];
                }
                elements[index] = newElement;
                elementCounter++;
            }
        } else {
            throw (new Exception("Wrong index"));
        }
    }

    public void remove(int index) throws Exception {
        if (isEmpty()) {
            throw (new Exception("The array is empty!"));
        } else {
            if (index < 0 || index >= elementCounter) {
                throw (new Exception("Wrong index!"));
            } else {
                for (int i = index; i < elementCounter - 1; i++) {
                    elements[i] = elements[i + 1];
                }
                elements[elementCounter - 1] = 0;
                elementCounter--;
            }
        }
    }

    public char retrieve(int index) throws Exception {
        if (isEmpty()) {
            throw (new Exception("The array is empty!"));
        } else {
            if (index < 0 || index >= elementCounter) {
                throw (new Exception("Wrong index!"));
            } else {
                return elements[index];
            }
        }
    }

    public boolean search(char inputElement){
        for(int  i = 0; i < elementCounter; i++){
            if(elements[i] == inputElement){
                return true;
            }
        }
        return false;
    }

    //TODO sort

    //TODO makeEmpty;

    public void makeEmpty(){
        arraySize = DEFAULT_ARRAY_SIZE;
        elementCounter = 0;
        elements = new char[arraySize];
        System.gc();
    }

    public void print() throws Exception {
        if(isEmpty()){
            throw (new Exception("Array is empty!"));
        } else {
            for(int i = 0; i < elementCounter; i++){
                System.out.print(elements[i] + " ");
            }
            System.out.println();
        }
    }

    public char[] retrieveNextNeighbour(char inputElement) throws Exception {
        if(search(inputElement)){
            int howManySearchedElements = 0;
            for(int i = 0; i < elementCounter; i++){
                if(elements[i] == inputElement){
                    howManySearchedElements++;
                }
            }

            if(elements[elementCounter-1] == inputElement){
                howManySearchedElements--;
            }

            char[] nextNeighbour = new char[howManySearchedElements];
            int indexForNeighbour = 0;
            for(int i = 0; i < elementCounter - 1; i++){
                if(elements[i] == inputElement){
                    nextNeighbour[indexForNeighbour] = elements[i+1];
                    indexForNeighbour++;
                }
            }
            return nextNeighbour;
        } else {
            throw (new Exception("Input element was not found in the array list!"));
        }
    }

    public char[] sort(SortingType type) throws Exception {

        if(isEmpty()){
            throw(new Exception("Array is empty and is not possible to sort!"));
        } else {
            char[] sortArray = new char[elementCounter];
            for(int i = 0; i < elementCounter; i++){
                sortArray[i] = elements[i];
            }

            //ascending order
            if(type == SortingType.ASC){
                for(int i = 0; i < elementCounter; i++){
                    for(int j = 0; j < elementCounter; j++){
                        if(sortArray[i] < sortArray[j]){
                            char temp = sortArray[i];
                            sortArray[i] = sortArray[j];
                            sortArray[j] = temp;
                        }
                    }
                }
            }

            //descending order
            else if(type == SortingType.DESC) {
                for(int i = 0; i < elementCounter; i++){
                    for(int j = 0; j < elementCounter; j++){
                        if(sortArray[i] > sortArray[j]){
                            char temp = sortArray[i];
                            sortArray[i] = sortArray[j];
                            sortArray[j] = temp;
                        }
                    }
                }
            }
            else {
                throw(new Exception("Wrong sorting Type"));
            }
            return sortArray;
        }

    }

}

