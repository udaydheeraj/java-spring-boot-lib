import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Day1 {

    public static Character firstNonRepeating(String input)
    {
        if (input == null || input.isEmpty())
        {
            return null;
        }

        Map<Character,Integer> frequency = new LinkedHashMap<Character,Integer>();

        for(char ch: input.toCharArray())
        {
            frequency.put(ch, frequency.getOrDefault(ch,0) + 1);
        }

        /*for(char c : input.toCharArray())
        {
            if(frequency.get(c) == 1)
            {
                return c;
            }
        }*/

        for(Map.Entry<Character,Integer> entry : frequency.entrySet())
        {
            if(entry.getValue() == 1)
            {
                return entry.getKey();
            }
        }

        return null;

    }


    public static void main(String[] args) {

        System.out.println(firstNonRepeating("swiss"));
    }
}
