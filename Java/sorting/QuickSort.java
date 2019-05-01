package algorithms.sort;

public class QuickSort {

    public void sort(int[] numbers) {
        sortHelper(numbers, 0, numbers.length-1);
    }

    public void sortHelper(int[] numbers, int first, int last) {
        if (first < last) {
            int splitPoint = partition(numbers, first, last);
            sortHelper(numbers, first, splitPoint-1);
            sortHelper(numbers, splitPoint+1, last);
        }
    }

    public int partition(int[] numbers, int first, int last) {
        int pivotValue = numbers[first];
        int leftMark = first + 1;
        int rightMark = last;
        boolean done = false;

        while (!done) {
            while (leftMark <= rightMark && numbers[leftMark] <= pivotValue) {
                leftMark++;
            }
            while (rightMark >= leftMark && numbers[rightMark] >= pivotValue) {
                rightMark--;
            }
            if (rightMark < leftMark) {
                done = true;
            } else {
                int temp = numbers[leftMark];
                numbers[leftMark] = numbers[rightMark];
                numbers[rightMark] = temp;
            }
        }

        int temp = numbers[first];
        numbers[first] = numbers[rightMark];
        numbers[rightMark] = temp;

        return rightMark;
    }

    public void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        final int[] numbers = {3000, 10, -500, 9, 15, 300, 250};
        QuickSort app = new QuickSort();
        app.sort(numbers);
        app.printArray(numbers);
    }

}
