import java.util.*;

public class day3 {


    public static Set<Integer> findCommonElements(List<Integer> list1,
                                             List<Integer> list2)
    {
        
        Set<Integer> common = new HashSet<>();
        if(list1 == null || list2 == null){
            return common;
        }
        Set<Integer> list1_set = new HashSet<>(list1);


        list2.forEach(value -> {
            if(list1_set.contains(value))
            {
                common.add(value);
            }
        });

        return  common;
    }
    public static void main() {
        List<Integer> list1 = Arrays.asList(10,20,30,40,50);
        List<Integer> list2 = Arrays.asList(30,40,60,70);


        System.out.println( findCommonElements(list1,list2));
    }
}
