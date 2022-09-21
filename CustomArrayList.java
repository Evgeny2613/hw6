package lessons.lesson6.list;

public class CustomArrayList implements MyArrayList { //Ours array list
    
    private int size = 0; // visible size of the array list for user

    private int[] data; // here the elements will take place

    private static final int INITIAL_CAPACITY = 4; // initial size of the array

    public CustomArrayList() {
        data = new int[INITIAL_CAPACITY]; // initiating array
    }

    @Override
    public int size() { // return size
        return size;
    }

    @Override
    public boolean contains(int value) {
        boolean check = false;
        for (int i = 0; i < size; i++) {
            if (data[i] == value)
                check = true;
        }
        return check;
    }

    //changing the value of the element by its index
    @Override
    public void set(int index, int value) {
        if (index < 0 | index >= size)
            throw new IndexOutOfBoundsException(); //throwing the exception
        data[index] = value;
        size++;
    }

    // method for creating array twice bigger
    private void increaseCapacity() {
        int[] newData = new int[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public void add(int value) {
        if (size == data.length)
            increaseCapacity(); // method for creating array twice bigger
        data[size] = value;
        size++;
    }

    @Override
    public void add(int index, int value) {
        if (index < 0 | index >= size)
            throw new IndexOutOfBoundsException();
        if (size == data.length)
            increaseCapacity();
        for (int i = size - 1; i >= index; i--) { // copying the elements from end
            data[i + 1] = data[i];
        }
        data[index] = value;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 | index >= size)
            throw new IndexOutOfBoundsException();
        for (int i = index; i < size; i++) {
                data[i] = data[i + 1];
        }
        size--;


    }

    @Override
    public int get(int index) {
        if (index < 0 | index >= size)
            throw new IndexOutOfBoundsException();
        return data[index];
    }

    @Override
    public String toString() {
        String r = "[";
        for (int i = 0; i < size; i++) {
            r += data[i];
            if (i < size - 1)
                r += ", ";
        }
        r += "]";
        return r;
    }
}

