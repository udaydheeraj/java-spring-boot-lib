package day4;

import java.util.LinkedHashMap;
import java.util.Map;

public class Practise1 {

    public static Character findFirstNonRepeatingCharacter(String input)
    {
        if(input == null || input.isEmpty())
        {
            System.out.println("input is null or empty");
            return null;
        }

        Map<Character, Integer> inputMap = new LinkedHashMap<>();
        for(char ch : input.toCharArray())
        {
            inputMap.put(ch, inputMap.getOrDefault(ch,0) + 1 );
        }
        for(Map.Entry<Character, Integer> entry : inputMap.entrySet())
        {
            if(entry.getValue() == 1)
            {
                return entry.getKey();
            }
        }
        return null;
    }
   public static void main(String[] args) {

       System.out.println(findFirstNonRepeatingCharacter("aabbcddffeegh"));
       System.out.println(findFirstNonRepeatingCharacter(""));
       System.out.println(findFirstNonRepeatingCharacter(null));


    }
}
