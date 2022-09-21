package lessons.lesson6.list;

public interface MyArrayList {
    int size();
    boolean contains(int value);
    void set(int index, int value);
    void add(int value);
    void add(int index, int value);
    void remove(int index);
    int get(int index);
}
