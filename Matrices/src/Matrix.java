public class Matrix {

	private int[][] matrix;
	private int m, n;

	public Matrix() {
	}

	public Matrix(int[][] mat, int l1, int l2) {
		this.matrix = mat;
		this.m = l1;
		this.n = l2;
	}

	public int getRows() {
		return this.m;
	}

	public int getCols() {
		return this.n;
	}

	public int[][] getMatrix() {
		return this.matrix;
	}

	public void print() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j]);
				System.out.print("  ");
			}
			System.out.print("\n");
		}
	}

	//static function
	public static Matrix add(Matrix a, Matrix b) {
		if (a.getRows() == b.getRows() && a.getCols() == b.getCols()) {
			int[][] matrix = a.getMatrix();
			for (int i = 0; i< a.getRows();i++)
				for (int j =0 ;j<a.getCols();j++)
					matrix[i][j] += b.getMatrix()[i][j];
			return new Matrix(matrix, a.getRows(),a.getCols());
		} else
			return null;
	}

}
