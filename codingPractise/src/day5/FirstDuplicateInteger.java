package day5;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstDuplicateInteger {

    public static Integer findFirstDuplicate(List<Integer> numbers)
    {
        if( numbers == null || numbers.isEmpty())
        {
         return null;
        }

        Set<Integer> numberSet = new HashSet<>();

        for(Integer number : numbers)
        {
            if(!numberSet.add(number))
            {
                return number;
            }
        }

        return null;
    }


   public static void main(String[] args) {

        List<Integer> numbers = List.of();
       System.out.println( findFirstDuplicate(numbers));
    }
}
