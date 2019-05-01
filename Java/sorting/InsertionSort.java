package algorithms.sort;

public class InsertionSort {

    public void sort(int[] numbers) {
        int n = numbers.length;

        for (int i = 1; i < n; i++) {
            int currentValue = numbers[i];
            int pos = i;
            while(pos > 0 && numbers[pos-1] > currentValue) {
                numbers[pos] = numbers[pos-1];
                --pos;
            }
            numbers[pos] = currentValue;
        }
    }

    public void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        final int[] numbers = {3000, 10, -500, 9, 15, 300, 250};
        InsertionSort insertion = new InsertionSort();
        insertion.sort(numbers);
        insertion.printArray(numbers);
    }

}
