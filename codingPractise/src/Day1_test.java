import java.security.Key;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Day1_test {

    static Character firstNonRepeatingCharacter(String input)
    {
        if(input == null || input.isEmpty())
        {
            return null;
        }

        Map<Character, Integer> frequency = new LinkedHashMap<>();

        for(char ch : input.toCharArray())
        {
            frequency.put(ch, frequency.getOrDefault(ch,0 ) + 1);
        }

        for(Map.Entry<Character, Integer> entry : frequency.entrySet())
        {
            if(entry.getValue() == 1)
            {
                return entry.getKey();
            }
        }

        return null;
    }

   public  static void main() {

       System.out.println(  firstNonRepeatingCharacter("swiss"));
       System.out.println( firstNonRepeatingCharacter("aabbcddeef"));

    }
}
