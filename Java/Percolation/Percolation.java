
/**
 * 
 * @author Adam Walker
 *
 * Percolation is used to find under what conditions a liquid or gas will drain
 * thorugh a porous material. An example when this would be used is in a system 
 * with insulated and metallic materials. Percolation would be used to find the 
 * percentage of metallic material needed to be an electrical conductor
 *
 * Time Complexity: O(N^2)
 *
 */

// Models an N-by-N percolation system.
public class Percolation {
    private final boolean[][] grid;
    private int openSites;
    private WeightedQuickUnionUF wquf;
    private int N;
    private int bottomSite;

    // Create an N-by-N grid, with all sites blocked.
    //...
    public Percolation(int N) {

        this.N = N;
        this.openSites = 0;
        grid = new boolean[N][N];
        wquf = new WeightedQuickUnionUF(N * N + 2);
        bottomSite = N * N + 1;

        //set whole grid to closed(false)
        for (boolean[] row : grid) {
            for (boolean column : row) {
                column = false;
            }
        }
        for (int i = 0; i <= N - 1; i++) {
            wquf.union(0, encode(0, i));
            wquf.union(bottomSite, encode(N - 1, i));

        }

    }

    // Open site (row, col) if it is not open already.
    public void open(int row, int col) {
        if (row < 0 || col < 0 || row > N || col > N)
            throw new IndexOutOfBoundsException("Row or column out of bounds");

        // if (!isOpen(row, col)) {
        grid[row][col] = true;
        openSites++;
        //  }

        if (N > col && col >= 0 && N > row && row >= 0) {
            if ((row - 1) >= 0 && (row - 1) < N && isOpen(row - 1, col)) {
                wquf.union(encode(row - 1, col), encode(row, col));

            }
            if ((row + 1) >= 0 && (row + 1) < N && isOpen(row + 1, col)) {
                wquf.union(encode(row + 1, col), encode(row, col));

            }
            if ((col - 1) >= 0 && (col - 1) < N && isOpen(row, col - 1)) {
                wquf.union(encode(row, col - 1), encode(row, col));

            }
            if ((col + 1) >= 0 && (col + 1) < N && isOpen(row, col + 1)) {
                wquf.union(encode(row, col + 1), encode(row, col));

            }
        }

    }

    // Is site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 0 || col < 0 || row >= N || col >= N)
            throw new IndexOutOfBoundsException("Row or column out of bounds");

        return grid[row][col];

    }

    // Is site (row, col) full?
    @SuppressWarnings("deprecation")
    public boolean isFull(int row, int col) {
        if (row < 0 || col < 0 && row >= N || col >= N)
            throw new IndexOutOfBoundsException("Row or column out of bounds");
        // if the site is open, connect it
        if (isOpen(row, col)) {
            return wquf.connected(encode(row, col), 0);
        } else
            return false;
    }

    // Number of open sites.
    public int numberOfOpenSites() {
        return openSites;
    }

    // Does the system percolate?
    @SuppressWarnings("deprecation")
    public boolean percolates() {

        return wquf.connected(bottomSite, 0);
    }

    // An integer ID (1...N) for site (row, col).
    private int encode(int row, int col) {

        return (row * N) + col + 1;
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Percolation perc = new Percolation(N);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        System.out.println(perc.numberOfOpenSites() + " open sites");
        if (perc.percolates()) {
        	System.out.println("percolates");
        } else {
        	System.out.println("does not percolate");
        }

        // Check if site (i, j) optionally specified on the command line
        // is full.
        if (args.length == 3) {
            int i = Integer.parseInt(args[1]);
            int j = Integer.parseInt(args[2]);
            System.out.println(perc.isFull(i, j));
        }
    }
}
