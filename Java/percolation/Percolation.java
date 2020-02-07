public class Percolation {

    private WeightedQuickUnion wqu;
    private boolean[] openGrid;
    private int gridSideSize;
    private int numOfElements;
    private int numOfOpenSites;
    private int virtualTopElem;
    private int virtualBottomElem;

    /**
     * Creates n-by-n grid, with all sites initially blocked.
     * @param n the size of the site of the n * n grid
     */
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N must be greater than zero.");
        }

        numOfElements = n * n;
        wqu = new WeightedQuickUnion(numOfElements + 2); // Increased with the top and bottom virtual elements
        // The array is defined as a class field, so the default value of its elements is false.
        openGrid = new boolean[numOfElements];
        gridSideSize = n;
        // Put the virtual elements to the end of the array
        virtualBottomElem = numOfElements;
        virtualTopElem = numOfElements + 1;
    }

    // Only for testing purposes
    public WeightedQuickUnion getWqu() {
        return wqu;
    }

    public boolean[] getOpenGrid() {
        return openGrid;
    }

    public int getGridSideSize() {
        return gridSideSize;
    }

    public int getNumOfElements() {
        return numOfElements;
    }

    public int getVirtualTopElem() {
        return virtualTopElem;
    }

    public int getVirtualBottomElem() {
        return virtualBottomElem;
    }

    // Returns the number of open sites.
    public int numberOfOpenSites() {
        return numOfOpenSites;
    }

    // Opens the site (row, col) if it is not open already.
    public void open(int row, int col) {
        isValid(row, col);

        if (isOpen(row, col)) {
            return;
        }

        int siteNumber = convertRowColToSiteNum(row, col);
        openGrid[siteNumber] = true;
        ++numOfOpenSites;

        // If the current open element is on the upper edge of the  grid, connect it to the virtual top element.
        if (row == 0) {
            wqu.union(siteNumber, virtualTopElem);
        }

        // If the current open element is on the bottom edge of the  grid, connect it to the virtual bottom element.
        if (row == gridSideSize -1) {
            wqu.union(siteNumber, virtualBottomElem);
        }

        // Checking if the neighbour elements exist and are open or not. If so, connect them to the current element.
        int neighbourSiteNumber = 0;
        // Right next element
        if (col < gridSideSize-1) { // There must be right element(s)
            neighbourSiteNumber = convertRowColToSiteNum(row, col + 1);
            wqu.union(siteNumber, neighbourSiteNumber);
        }

        // Left next element
        if (col > 0) { // There must be left element(s)
            neighbourSiteNumber = convertRowColToSiteNum(row, col-1);
            wqu.union(siteNumber, neighbourSiteNumber);
        }

        // Upper element
        if (row > 0) { // There must be upper element(s)
            neighbourSiteNumber = convertRowColToSiteNum(row-1, col);
            wqu.union(siteNumber, neighbourSiteNumber);
        }

        // Bottom element
        if (row < gridSideSize-1) { // There must be bottom element(s)
            neighbourSiteNumber = convertRowColToSiteNum(row + 1, col);
            wqu.union(siteNumber, neighbourSiteNumber);
        }
    }

    // Is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        isValid(row, col);
        int siteNumber = convertRowColToSiteNum(row, col);
        return openGrid[siteNumber];
    }

    // Is the site (row, col) full?
    // A full site is an open site that can be connected to an open site in the top row via a chain of neghbouring
    public boolean isFull(int row, int col) {
        isValid(row, col);
        if (isOpen(row, col)) {
            int siteNumber = convertRowColToSiteNum(row, col);
            if (wqu.connected(siteNumber, virtualTopElem)) {
                return true;
            }
        }
        return false;
    }

    // Does the system percolate?
    public boolean percolates() {
        return wqu.connected(virtualBottomElem, virtualTopElem);
    }

    // Helper function to convert (row, num) coordinates to the number of the site in the grid.
    private int convertRowColToSiteNum(int row, int col) {
        isValid(row, col);
        int siteNumber = row * gridSideSize + col;
        return siteNumber;
    }

    // Validate the coordinates of the site
    private void isValid(int row, int col) {
        if (row < 0 || row >= gridSideSize || col < 0 || col >= gridSideSize) {
            throw new IllegalArgumentException("The coordinate is not valid.");
        }
    }

}
