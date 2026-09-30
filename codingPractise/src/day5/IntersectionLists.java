package day5;

import java.util.*;

public class IntersectionLists {

    public static List<Integer> findIntersection(
            List<Integer> list1,
            List<Integer> list2)
    {
        if(list1 == null || list1.isEmpty()
        || list2 == null || list2.isEmpty())
        {
            return Collections.emptyList();
        }

        Set<Integer> list2Set = new HashSet<>(list2);
        Set<Integer> intersectionSet = new LinkedHashSet<>();

        for(Integer number : list1)
        {
            if(list2Set.contains(number))
            {
                intersectionSet.add(number);
            }
        }

        return new ArrayList<>(intersectionSet);
    }

    public static void main(String[] args) {

        List<Integer> list1 = List.of(10, 20, 30, 40, 20);
        List<Integer> list2 = List.of(20, 30, 50, 20);

        System.out.println(findIntersection(list1,list2));

    }
}
