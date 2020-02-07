public class Main {

    private static Percolation percolation;

    public static void main(String[] args) {
        percolation = new Percolation(3);
        // test1();
        // test2();
        test3();
    }

    public static void test1() {
        System.out.println("Number of open sites = " + percolation.numberOfOpenSites());
        System.out.println("Grid side size = " + percolation.getGridSideSize());
        System.out.println("Number of elements = " + percolation.getNumOfElements());
        System.out.println("Virtual bottom element = " + percolation.getVirtualBottomElem());
        System.out.println("Virtual top element = " + percolation.getVirtualTopElem());
        System.out.println("Weighted quick union = " + percolation.getWqu());
    }

    private static void test2() {
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 3; ++col) {
                percolation.open(row, col);
            }
            printIsOpen();
        }

        System.out.println(percolation.percolates());
    }

    private static void test3() {
        System.out.println(percolation.percolates());

        percolation.open(0, 0);
        percolation.open(1, 0);
        percolation.open(1, 1);
        percolation.open(2, 1);
        percolation.open(2, 2);

        printIsOpen();
        System.out.println("Number of open sites: " + percolation.numberOfOpenSites());
        System.out.println(percolation.percolates());
        System.out.format("isFull(%d, %d) = %b%n", 2, 2, percolation.isFull(2, 2)) ;
        System.out.format("isFull(%d, %d) = %b%n", 2, 1, percolation.isFull(1, 2)) ;
    }

    private static void printIsOpen() {
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 3; ++col) {
                System.out.format("isOpen(%d, %d) = %b\n", row, col, percolation.isOpen(row, col));
            }
        }
        System.out.println();
    }

}
