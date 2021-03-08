import java.awt.Color;

public class MandelGrid {
	private Complex[][] grid;
	private double[][] converganceGrid;
	private int resolution;

	public MandelGrid(Complex c1, Complex c2, int res, int maxIterations) {
		this.resolution = res;
		this.grid = new Complex[res][res];
		this.converganceGrid = new double[res][res];

		if (c1.re > c2.re) {
			Complex temp = c1;
			c1 = c2;
			c2 = temp;
		}
		if (c1.im > c2.im) {
			double temp = c1.im;
			c1.im = c2.im;
			c2.im = temp;
		}
		
		double reInc = (c2.re - c1.re) / (grid.length);
		double imInc = (c2.im - c1.im) / (grid.length);

		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid[x].length; y++) {
				grid[x][y] = new Complex(c1.re + reInc * x, c1.im + imInc * y);
				converganceGrid[x][y] = grid[x][y].converge(maxIterations);
			}
		}
	}

	public void drawGrid(Graphics g) {
		g.setBlockSize(1);
		for (int x = 0; x < converganceGrid.length; x++) {
			for (int y = 0; y < converganceGrid[x].length; y++) {
				g.dot(x, y, new Color((int) (255 * converganceGrid[x][y]), 0, 0));
			}
		}
	}

	public Complex getElm(int x, int y) {
		return grid[x][y];
	}

	public int getResolution() {
		return resolution;
	}
}
