/* Написать функцию, которая принимает на вход два списка с числами одинаковой длины.
List<String> compare(List<Integer> f, List<Integer> s) Если числа с одинаковыми индексами одинаковы.
возвращать "Yes", если разные то "No"  . Пример: [1,2,3], [10,2,3] -> ["No", "Yes", "Yes]

Напишите функцию которая принимает два списка строк и возвращает
список содержащий строки и обоих входных списоков.
Пример: ["dima", "max"], ["masha] -> ["dima", "max", "masha"]
 */


package lessons.lesson6.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListHomework {
    public static void main(String[] args) {
        List<Integer> f = new ArrayList(Arrays.asList(1, 2, 3));
        List<Integer> s = new ArrayList(Arrays.asList(10, 2, 3));
        System.out.println(compare(f, s));

        List<String> a = new ArrayList(Arrays.asList("dima", "max"));
        List<String> b = new ArrayList(Arrays.asList("masha", "dima"));

        System.out.println(unitingLists(a, b));
    }


    public static List<String> compare(List<Integer> f, List<Integer> s) {
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < f.size(); i++) {
            if (f.get(i) == s.get(i))
                newList.add("Yes");
            else
                newList.add("No");
        }
        return newList;
    }

    public static List<String> unitingLists(List<String> a, List<String> b) {
        for (int i = 0; i < b.size(); i++) {
            int check = 0;
            for (int j = 0; j < a.size(); j++) {
                if (a.get(j) != b.get(i))
                    check++;
            }
            if (check == a.size())
                a.add(b.get(i));
        }
        return a;
    }
}
