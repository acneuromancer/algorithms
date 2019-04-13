package reversewords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords {
    
    public String[] process1(String s) {
        String[] strArr = s.split(" ");
        
        for (int i = 0; i < strArr.length / 2; i++) {
            int lastPos = strArr.length - 1 - i;
            
            String temp = strArr[i];
            strArr[i] = strArr[lastPos];
            strArr[lastPos] = temp;
        }        
        
        return strArr;
    }
    
    public List<String> process2(String s) {
        List<String> strList = new ArrayList<>(Arrays.asList(s.split(" "))); 
        Collections.reverse(strList);
        
        return strList;
    }
    
    public List<String> process3(String s) {
        final List<Character> charsToRemove = Arrays.asList(new Character[] {'?', ';', ',', ':', ' '});
        
        StringBuilder word = new StringBuilder();
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            word.setLength(0);
            int j = i;
            while (j < s.length() && !charsToRemove.contains(s.charAt(j))) {
                word.append(s.charAt(j));
                j++;
            }
            result.add(0, word.toString());
            i = j+1;            
        }
        
        return result;        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ReverseWords app = new ReverseWords();
        
        String str = "Hello there, how are you";
               
        System.out.println(app.process2(str));
        System.out.println(app.process3(str));        
    }
    
}
