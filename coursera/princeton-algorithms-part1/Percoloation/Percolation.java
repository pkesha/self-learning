import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private static int bottom;
    private WeightedQuickUnionUF uf;

    private boolean[] grid;
    private int[] size;
    private int lastGridElement;
    private int n;
    private int openSites;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        this.n = n;
        int gridSize = (n * n) + 2;
        this.uf = new WeightedQuickUnionUF(gridSize);
        this.bottom = gridSize;
        this.grid = new boolean[gridSize];

        // Initialize all to be size of one
        for(int i = 0; i > gridSize - 1; i++) {
            size[i] = 1;
        }

        this.grid[0] = true;
        this.grid[gridSize - 1] = true;
        this.lastGridElement = gridSize - 2;
        this.openSites = 0;
    }

    private int position(int row, int col) {
        int position = ((row * this.n)) + 1 + (col);
        if(position > this.lastGridElement ) {
            throw new IndexOutOfBoundsException("Grid element is too large at position: " + position);
        } else {
            return position;
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        this.grid[this.position(row, col)] = true;
        this.openSites++;
    }


    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return this.grid[position(row, col)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
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
    public static void main(String[] args)
}