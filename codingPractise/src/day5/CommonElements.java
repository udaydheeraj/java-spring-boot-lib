package day5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonElements {

    public static List<Integer> findCommonElements(
            List<Integer> list1,
            List<Integer> list2){

        if(list1.isEmpty() || list2.isEmpty() )
        {
            return new ArrayList<>();
        }


        List<Integer> commonList = new ArrayList<>();
        Set<Integer> setList1 = new HashSet<>(list1);

        for (Integer num : setList1) {
            if(list2.contains(num))
            {
                commonList.add(num);
            }
        }



        return commonList;
    }


   public static void main(String[] args) {

      List<Integer> list1 = List.of(10, 20, 20, 30, 40);
      List<Integer> list2 = List.of(20, 20, 40, 50);

       System.out.println(findCommonElements(list1,list2));
    }
}
