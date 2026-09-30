package day4;

import java.util.*;

public class DuplicateCharList {


    public static List<Character> findDuplicateCharacters(String input)
    {

        if(input == null || input.isEmpty())
        {
            return new ArrayList<>();
        }

        Map<Character, Integer> frequency = new LinkedHashMap<>();
        List<Character> duplicateChars = new ArrayList<>();

        for(char ch : input.toCharArray())
        {
            frequency.put(ch, frequency.getOrDefault(ch,0)+1);
        }
        for(Map.Entry<Character, Integer> entry : frequency.entrySet())
        {
            if(entry.getValue() > 1)
            {
                duplicateChars.add(entry.getKey());
            }
        }
        return duplicateChars;
    }

    public static Character findFirstDuplicateCharacter(String input)
    {
        if(input == null || input.isEmpty())
        {
            return null;
        }

        Set<Character> seen = new HashSet<>();

        for(char ch : input.toCharArray())
        {
            if(seen.contains(ch))
            {
                return ch;
            }
                seen.add(ch);

        }

        return null;
    }

    public static void main(String[] args) {

        System.out.println(findFirstDuplicateCharacter("aabbccdddeee"));
        System.out.println(findFirstDuplicateCharacter("abbccddee"));
        System.out.println(findFirstDuplicateCharacter("abccddee"));
        System.out.println(findFirstDuplicateCharacter("abcddee"));
        System.out.println(findFirstDuplicateCharacter(""));
    }
}
