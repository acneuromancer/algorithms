import java.util.ArrayList;
import java.util.List;


public class CommonElements {
    
    public List<Integer> process1(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < a.length; ++i) {
            int j = 0;
            while (j < b.length && a[i] >= b[j]) {
                if (a[i] == b[j]) {
                    result.add(a[i]);
                    break;
                }
                j++;
            }
        }
        
        return result;
    }
    
    public List<Integer> process2(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>();
        
        int p1 = 0;
        int p2 = 0;
        
        while (p1 < a.length && p2 < b.length) {
            if (a[p1] == b[p2]) {
                result.add(a[p1]);
                p1++;
                p2++;
            } else if (a[p1] > b[p2]) {
                p2++;
            } else {
                p1++;
            }
        }
        
        return result;
    }
    
    
    public static void main(String[] args) {
        CommonElements app = new CommonElements();
        int[] a = {1, 3, 4, 6, 7, 9};
        int[] b = {1, 2, 4, 5, 9, 10};
        System.out.println(app.process2(a, b));
        System.out.println(app.process2(a, b));
    }
    
}
