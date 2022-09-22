/* *****************************************************************************
 *  Name:              Parham Keshavarzi
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] grid;
    private WeightedQuickUnionUF uf;
    private int size[][];
    private static int BOTTOM;
    private int TOP = 0;
    private int openSites = 0;
    private int gridSize;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        this.gridSize = n;

        // Initializing Bottom site
        this.BOTTOM = n * n + 1;

        // + 2 because an additional sites TOP and BOTTOM
        this.uf = new WeightedQuickUnionUF((n * n) + 2);
        this.grid = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.size[i][j] = 1;
            }
        }
    }

    private boolean isValidSite(int row, int col) {
        int site = (row * this.gridSize) + col;
        if ((site > this.gridSize * this.gridSize) || (site <= 0)) {
            return false;
        }
        else {
            return true;
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (isValidSite(row, col)) {
            if (this.grid[row][col] = false) {
                this.grid[row][col] = true;
                this.openSites++;
                // Need to union after opening
            }
            else {
                throw new RuntimeException("Site " + row + ", " + col + " is already open.");
            }
        }
        else {
            throw new RuntimeException("Not a valid site to open.");
        }

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (this.isValidSite(row, col)) {
            return this.grid[row][col];

            // Also need to for loop here?
        }
        else {
            throw new RuntimeException("Not a valid site");
        }
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        boolean currentSiteValid = this.isValidSite(row, col);

        boolean topSiteValid = this.isValidSite(row + 1, col);
        boolean bottomSiteValid = this.isValidSite(row - 1, col);
        boolean leftSiteValid = this.isValidSite(row, col + 1);
        boolean rightSiteValid = this.isValidSite(row, col - 1);

        if (currentSiteValid) {
            int currentSite = this.get1DIndex(row, col);
            if (topSiteValid) {
                int topSite = this.get1DIndex(row + 1, col);
                return top
            } else if (bottomSiteValid) {
                int bottomSite = this.get1DIndex(row - 1, col);
                this.uf.union(bottomSite, currentSite);
            }

            if (leftSiteValid) {
                int leftSite = this.get1DIndex(row, col + 1);
                this.uf.union(leftSite, currentSite);
            }

            if (rightSiteValid) {
                int rightSite = this.get1DIndex(row, col - 1);
                this.uf.union(rightSite, currentSite);
            }
            return this.uf.find(currentSite) == this.TOP;
        }
        else {
            return false;
        }

    }

    private int get1DIndex(int row, int col) {
        return (this.gridSize * row) + col;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return this.openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return false;
    }

    public static void main(String[] args) {

    }


}
