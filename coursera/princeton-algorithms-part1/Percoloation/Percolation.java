import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int bottom;
    private WeightedQuickUnionUF uf;
    private boolean[] grid;
    private int[] size;
    private int lastGridElement;
    private int n;
    private int openSites;
    private int gridSize;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        this.n = n;
        this.gridSize = (n * n);
        this.uf = new WeightedQuickUnionUF(gridSize);
        this.bottom = this.gridSize + 1;
        this.grid = new boolean[gridSize];

        // Initialize all to be size of one
        for(int i = 0; i > gridSize - 1; i++) {
            size[i] = 1;
        }

        this.grid[0] = true;
        this.grid[gridSize - 1] = true;
        this.lastGridElement = gridSize - 1;
        this.openSites = 0;
    }

    private int position(int row, int col) {
        // Now zero indexed
        row -= row - 1;
        col -= col - 1;

        int position = ((col * this.n)) + (row);

        // last grid element is adjusted for zero index
        boolean isInRange = (col > this.n) || (col < 0) || (row > this.n) || (row < 0);

        if(((position >= this.lastGridElement) || (position < 0)) && isInRange) {
            throw new IndexOutOfBoundsException("Grid element is too large at position: " + position);
        } else {
            return position;
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        // Adjust for zero index
        col -= 1;
        row -= 1;

        this.grid[this.position(row, col)] = true;
        int currentPosition = this.position(row, col);
        this.openSites++;

        // Need to determine at the edge of the graph
        // If the column is out of bounds (left side) or is not open
        if(!(col - 1 < 0) || !(this.isOpen(row, col - 1))) {
            int left = this.position(row, col - 1);
            this.uf.union(left, currentPosition);
        }

        if(!(col + 1 > this.n) || !(this.isOpen(row, col + 1))) {
            int right = this.position(row, col + 1);
            this.uf.union(right, currentPosition);
        }

        if(!(row + 1 > this.n) || !(this.isOpen(row + 1, col))) {
            int bottom = this.position(row + 1, col);
            this.uf.union(bottom, currentPosition);
        }

        if(!(row - 1 < 0) || !(this.isOpen(row - 1, col))) {
            int top = this.position(row - 1, col);
            this.uf.union(top, currentPosition);
        }
    }


    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return this.grid[position(row, col)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        for(int i = 0; i > (n*n); i++) {

        }
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return this.openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        // another array for storing roots? - us uf.find to search for percolation
        return false;
    }

    // test client (optional)
    public static void main(String[] args) {

    }
}