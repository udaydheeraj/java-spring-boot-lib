package day5;

import java.util.*;

public class CountFrequencyNumbers {

    public static Map<Integer, Integer> countFrequency(List<Integer> numbers)
    {
        if(numbers == null || numbers.isEmpty())
        {
            return Collections.emptyMap();
        }

        Map<Integer,Integer> frequency = new LinkedHashMap<>();

        for(Integer number : numbers)
        {
            frequency.put(number, frequency.getOrDefault(number,0)+1);
        }


        return frequency;

    }

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 20, 10, 30, 20, 10, 40);
        System.out.println(countFrequency(numbers));
    }
}
