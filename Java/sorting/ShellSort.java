package algorithms.sort;

public class ShellSort {

    public void sort(int[] numbers) {
        int n = numbers.length;
        int gap = n / 2;

        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int currentValue = numbers[i];
                int j = i;
                while (j >= gap && numbers[j-gap] > currentValue) {
                    numbers[j] = numbers[j-gap];
                    j -= gap;
                }
                numbers[j] = currentValue;
            }
            gap /= 2;
        }
    }

    public void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numbers = {-100, 10, -300, 80, 50, 45, -1000};
        ShellSort shell = new ShellSort();
        shell.sort(numbers);
        shell.printArray(numbers);
    }

}
