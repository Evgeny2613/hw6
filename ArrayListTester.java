package lessons.lesson6.list;

import java.util.Iterator;

public class ArrayListTester {
    public static void main(String[] args) {
       /*  CustomArrayList list = new CustomArrayList();
        System.out.println(list.size());

        list.add(8);
        System.out.println(list.size());
        System.out.println(list.get(0));

        list.add(17);
        System.out.println(list);
        list.add(27);
        list.add(37);
        list.add(47);
        System.out.println(list);

        list.add(1, 12);
        System.out.println(list);

        */

        CustomArrayList list = new CustomArrayList();
        list.add(10);
        list.add(20);
        list.add(-30);
        list.add(50);
        list.add(60);
        list.remove(4);
        System.out.println(list);


       /* Iterator<Integer> iterator = list.iterator();
        if (iterator.hasNext() & iterator.hasNext())
            iterator.remove();
        System.out.println(iterator.next());

        */

        CustomArrayList newList = new CustomArrayList();
        newList.add(11);
        newList.add(100);
        newList.add(-4);
        newList.add(12);
        System.out.println(newList);

        // Iterator<Integer> smallToBig = newList.smallToBigIterator();
        Iterator<Integer> smallToBig = newList.new SmallToBigIterator();
        while (smallToBig.hasNext())
            System.out.println(smallToBig.next());
    }
}
