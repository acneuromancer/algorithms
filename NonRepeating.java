
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NonRepeating {

    public Character nonRepeating(String s) {
        s = s.replace(" ", "").toLowerCase();
        
        HashMap<Character, Integer> count = new HashMap<>();
        
        for (char letter : s.toCharArray()) {
            int counter = count.containsKey(letter) ? count.get(letter) + 1 : 1;
            count.put(letter, counter);
        }
        
        for (char key : count.keySet()) {
            if (count.get(key) == 1) {
                return key;
            }
        }
        
        return null;
    }
    
    public List<Character> nonRepeatingChars(String s) {
        s = s.replace(" ", "").toLowerCase();
        
        HashMap<Character, Integer> count = new HashMap<>();
        
        for (char letter : s.toCharArray()) {
            int counter = count.containsKey(letter) ? count.get(letter) + 1 : 1;
            count.put(letter, counter);
        }
        
        List<Character> result = new ArrayList<>();
                
        for (char key : count.keySet()) {
            if (count.get(key) == 1) {
                result.add(key);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        NonRepeating app = new NonRepeating();
        
        System.out.println(app.nonRepeating("aabbbbeeiccc"));
        System.out.println(app.nonRepeating("xaabbbbeeiiccc"));
        System.out.println(app.nonRepeating("xaabbbbeeiicccx"));
    
        System.out.println(app.nonRepeatingChars("aabbbbeeiccc"));
        System.out.println(app.nonRepeatingChars("xaabbbbeeiicccyzhjk"));
        System.out.println(app.nonRepeatingChars("xaabbbbeeiicccx"));
    }
    
}
