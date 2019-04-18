import java.util.HashMap;
import java.util.HashSet;

public class UniqueString {

    public boolean isUnique(String s) {
        s = s.replace(" ", "").toLowerCase();       
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            int counter = map.containsKey(letter) ? map.get(letter)+1 : 1;
            map.put(letter, counter);            
        }
        
        for (int i : map.values()) {
            if (i != 1) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isUnique2(String s) {
        s = s.replace(" ", "").toLowerCase();
        
        HashSet<Character> charSet = new HashSet<>();
        
        for (char letter : s.toCharArray()) {
            charSet.add(letter);
        }
        
        return charSet.size() == s.length();
    }
    
    public static void main(String[] args) {
        UniqueString app = new UniqueString();
        System.out.println(app.isUnique("Dog"));
        System.out.println(app.isUnique2("Hello there!"));
        System.out.println(app.isUnique2("Hi  !"));
    }
    
}
