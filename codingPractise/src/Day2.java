import java.util.*;

public class Day2 {

   public static void main() {

       List<Integer> numbers = Arrays.asList(10,20,30,40,10,50,40,30);

       System.out.println(findDuplicates(numbers));

    }

    private static List<Integer> findDuplicates(List<Integer> numbers) {

        Set<Integer> uniqueNumbers = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();

        if(numbers == null || numbers.isEmpty())
        {
            return new ArrayList<>();
        }

        for(Integer number : numbers)
        {
            if(uniqueNumbers.contains(number))
            {
                duplicates.add(number);
            }

            uniqueNumbers.add(number);


        }


       return duplicates;
    }
}
