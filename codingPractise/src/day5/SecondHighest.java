package day5;

import java.util.List;

public class SecondHighest {


    public static Integer findSecondHighest(List<Integer> numbers)
    {
        if(numbers == null || numbers.isEmpty())
        {
            return null;
        }

        Integer highest = 0;
        Integer secondHighest = 0;

        for(Integer number : numbers)
        {
            if(number > highest)
            {
                secondHighest = highest;
                highest = number;
            } else if(number < highest && number > secondHighest)
            {
                secondHighest = number;
            }
        }

        return secondHighest;
    }

    public static void main(String[] args) {

        List<Integer> numbers = List.of(10, 20, 20, 10);
        System.out.println(findSecondHighest(numbers));


    }
}
