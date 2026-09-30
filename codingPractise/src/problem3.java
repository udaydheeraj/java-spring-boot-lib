import java.util.*;

public class problem3 {

    public static Set<Integer> removeDuplicates(List<Integer> numbers)
    {
        if(numbers == null)
        {
            return null;
        }
        Set<Integer> noDuplicateSet = new LinkedHashSet<>(numbers);

        return noDuplicateSet;
    }

    public static Integer findFistDuplicate(List<Integer> list)
    {
        if(list == null || list.isEmpty()) return null;

        Set<Integer> seen = new HashSet<>(list);

        for(Integer number : list)
        {
            if(!seen.add(number))
            {
                return number;
            }

        }

        return null;
    }

    public static Map<Integer, Integer> groupByFrequency(List<Integer> list)
    {

        Map<Integer,Integer> frequency = new HashMap<>();
        if(list == null || list.isEmpty())
        {
            return frequency;
        }
        list.forEach(nummber -> {
            if(nummber != null){
            frequency.put(nummber, frequency.getOrDefault(nummber,0) + 1);
            }
        });

        return frequency;
    }

    public static Integer secondHighestNumber(List<Integer> list)
    {
        Integer highest = null;
        Integer secondHighest = null;
        if(list == null || list.size() < 2)
        {
            return null;
        }
        for(Integer number : list)
        {
            if(number == null){
                continue;
            }

            if(highest == null || number > highest)
            {
                secondHighest = highest;
                highest = number;
            }
        }

        return secondHighest;
    }

   public static void main() {

       List<Integer> numbers = Arrays.asList(10,30,20,10,30,20,40,30);

       System.out.println(findFistDuplicate(numbers));

    }
}
