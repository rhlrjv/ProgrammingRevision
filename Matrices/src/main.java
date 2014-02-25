
public class main {

	public static void main(String[] args) {
		int[][] a = new int[][]{{1,2,6,7},{3,4,10,100},{1,2,6,7},{1,2,6,7},{3,4,10,100},{1,2,6,7}};
		Matrix myMat = new Matrix(a, 6,4);
		//myMat.print();
		
		FileHelper fh = new FileHelper("matrix.txt");
		//fh.readFile().print();
		fh.writeFile(myMat);
		fh.readFile().print();
		
		Matrix.add(myMat, myMat).print();
		
	}

}
