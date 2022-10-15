package lessons.lesson6.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomArrayList implements MyList, Iterable<Integer> { //Ours array list
    public Iterator<Integer> smallToBigIterator() {
        return new SmallToBigIterator();
    }

    public class SmallToBigIterator implements Iterator<Integer> {
        private int[] source = new int[size];
        private int position = -1;

        public SmallToBigIterator() {
            System.arraycopy(data, 0, source, 0, size);
            Arrays.sort(source);
        }

        @Override
        public boolean hasNext() {
            return ++position < size;
        }

        @Override
        public Integer next() {
            if (position < 0 | position >= size)
                throw new NoSuchElementException();
            return source[position];
        }
    }

    private int size = 0; // visible size of the array list for user

    private int[] data; // here the elements will take place

    private static final int INITIAL_CAPACITY = 4; // initial size of the array

    public CustomArrayList() {
        data = new int[INITIAL_CAPACITY]; // initiating array
    }



    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int position = -1; // order number of element

            @Override
            public boolean hasNext() {
                return ++position < size;
            }

            @Override
            public Integer next() {
                if (position < 0 | position >= size)
                    throw new NoSuchElementException();
                return data[position];
            }
        };
    }

    public Iterator<Integer> backwardIterator() {
        return new Iterator<Integer>() {
            private int position = size;

            @Override
            public boolean hasNext() {
                return --position >= 0;
            }

            @Override
            public Integer next() {
                if (position < 0 | position >= size)
                    throw new NoSuchElementException();
                return data[position];
            }

            @Override
            public void remove() {
                if (position < 0 | position >= size)
                    throw new NoSuchElementException();
                CustomArrayList.this.remove(position);
                position--;
            }
        };
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

