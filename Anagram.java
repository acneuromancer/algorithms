import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagram {
    
    public boolean areAnagrams1(String s1, String s2) {
        s1 = s1.replace(" ", "").toLowerCase();
        s2 = s2.replace(" ", "").toLowerCase();
        
        if (s1.length() != s2.length()) {
            return false;
        }
        
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
       
        return Arrays.equals(ch1, ch2);
    }
    
    public boolean areAnagrams2(String s1, String s2) {
        s1 = s1.replace(" ", "").toLowerCase();
        s2 = s2.replace(" ", "").toLowerCase();
        
        if (s1.length() != s2.length()) {
            return false;
        }
        
        List<Character> charList = new ArrayList<>();
        for (int i = 0; i < s2.length(); i++) {
            charList.add(s2.charAt(i));
        }
        
        for (int i = 0; i < s1.length(); i++) {
            if (charList.contains(s1.charAt(i))) {
                charList.remove(Character.valueOf(s1.charAt(i)));             
            }
        }
           
        return charList.isEmpty();                
    }
    
    public boolean areAnagrams3(String s1, String s2) {
        s1 = s1.replace(" ", "").toLowerCase();
        s2 = s2.replace(" ", "").toLowerCase();
        
        if (s1.length() != s2.length()) {
            return false;
        }
        
        HashMap<Character, Integer> dictionary = new HashMap<>();
        
        for (int i = 0; i < s1.length(); i++) {
            char letter = s1.charAt(i);
            int counter = dictionary.containsKey(letter) ? dictionary.get(letter)+1 : 1;
            dictionary.put(letter, counter);
        }
        
        System.out.println(dictionary);
        
        for (int i = 0; i < s2.length(); i++) {
            char letter = s2.charAt(i);
            
            if (!dictionary.containsKey(letter)) {
                return false;
            }
            
            dictionary.put(letter, dictionary.get(letter)-1);
        }
        
        System.out.println(dictionary);
     
        for (char letter : dictionary.keySet()) {
            if (dictionary.get(letter) != 0) {
                return false;
            }
        }
                
        return true;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Anagram app = new Anagram();
        
        String s1 = "Clint Eastwood";
        String s2 = "old West Action";
        
        System.out.println(app.areAnagrams3(s1, s2));
        
        s1 = "Dodge";
        s2 = "Dog";
        
        System.out.println(app.areAnagrams3(s1, s2));
    }
    
}
