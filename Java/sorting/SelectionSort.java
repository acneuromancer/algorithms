package algorithms.sort;

public class SelectionSort {

    public void min(int[] numbers) {
        int n = numbers.length;

        for (int i = 0; i < n-1; i++) {
            int minIdx = i;
            for (int j = i+1; j < n; j++) {
                if (numbers[j] < numbers[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = numbers[minIdx];
            numbers[minIdx] = numbers[i];
            numbers[i] = temp;
        }
    }

    public void max(int[] numbers) {
        int n = numbers.length;

        for (int i = n-1; i > 0; i--) {
            int maxIdx = i;
            for (int j = 0; j < i; j++) {
                if (numbers[j] > numbers[maxIdx]) {
                    maxIdx = j;
                }
            }
            int temp = numbers[maxIdx];
            numbers[maxIdx] = numbers[i];
            numbers[i] = temp;
        }
    }

    public void printArray(int[] array) {
        for (int n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numbers = {-100, 10, -300, 80, 50, 45, -1000};
        SelectionSort selection = new SelectionSort();
        selection.max(numbers);
        selection.printArray(numbers);
    }

}
