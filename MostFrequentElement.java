
import java.util.HashMap;

public class MostFrequentElement {
    
    
    public static void main(String[] args) {
        Character[] strArray = {'a', 'b', 'a', 'c', 'b', 'a', 'c', 'c', 'c'};
        System.out.println(findMostFrequentElements(strArray));
    }
    
    public static <T> T findMostFrequentElements(T[] array) {
        HashMap<T, Integer> map = new HashMap<>();
        
        T maxKey = null;
        int maxVal = 0;
        
        for (T elem : array) {
            int counter = map.containsKey(elem) ? map.get(elem) + 1 : 1;
            map.put(elem, counter);
            
            if (map.get(elem) > maxVal) {
                maxKey = elem;
                maxVal = map.get(elem);
            }
        }
        
        System.out.println(map);
        
        return maxKey;
    }
    
}
