package day4;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Practise2 {
    public static Character findMostFrequentCharacter(String input)
    {
        if(input == null || input.isEmpty())
        {
            return null;
        }
        Map<Character, Integer> frequency = new LinkedHashMap<>();
        int maxCount = 0;
        char mostFreqChar = ' ';
        for(char ch : input.toCharArray())
        {
            int count = frequency.getOrDefault(ch, 0) + 1;
            frequency.put(ch, count);
            if(count > maxCount)
            {
                maxCount = count;
                mostFreqChar = ch;
            }
        }
        return mostFreqChar;

    }

    static void main(String[] args) {

        System.out.println(findMostFrequentCharacter("aabbccddee"));
        System.out.println(findMostFrequentCharacter("abbccddee"));
        System.out.println(findMostFrequentCharacter("abccddee"));
        System.out.println(findMostFrequentCharacter("abcddee"));
        System.out.println(findMostFrequentCharacter(""));


    }
}
