package algorithms.sort;

public class MergeSort {

    public void sort(int[] numbers) {
        int n = numbers.length;

        if (n > 1) {
            int mid = n / 2;
            int[] leftHalf = new int[mid];
            int[] rightHalf = new int[n-mid];
            System.arraycopy(numbers, 0, leftHalf, 0, mid);
            System.arraycopy(numbers, mid, rightHalf, 0,n-mid);

            sort(leftHalf);
            sort(rightHalf);

            int i, j, k;
            i = j = k = 0;

            while(i < leftHalf.length && j < rightHalf.length) {
                if (leftHalf[i] < rightHalf[j]) {
                    numbers[k] = leftHalf[i];
                    i++;
                } else {
                    numbers[k] = rightHalf[j];
                    j++;
                }
                k++;
            }

            while (i < leftHalf.length) {
                numbers[k] = leftHalf[i];
                i++;
                k++;
            }

            while (j < rightHalf.length) {
                numbers[k] = rightHalf[j];
                j++;
                k++;
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
        int[] numbers = {-300, 5, -1000, 50, 40, 6, -1000};
        MergeSort app = new MergeSort();
        app.sort(numbers);
        app.printArray(numbers);
    }

}
