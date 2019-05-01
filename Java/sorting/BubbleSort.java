package algorithms.sort;

public class BubbleSort {

    public void sort(int[] numbers) {
        int n = numbers.length;

        for (int i = n-1; i > 0; --i) {
            for (int j = 0; j < i; j++) {
                if (numbers[j] > numbers[j+1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
    }

    public void improvedSort(int[] numbers) {
        int n = numbers.length;

        while(true) {
            boolean swapped = false;

            for (int i = 0; i < n-1; i++) {
                if (numbers[i] > numbers[i+1]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i+1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }


    public void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numbers = {-5, 10, -100, 30, 7, 1000, 900};

        BubbleSort bs = new BubbleSort();
        bs.improvedSort(numbers);
        bs.printArray(numbers);
    }

}
