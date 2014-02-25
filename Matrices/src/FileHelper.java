import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHelper {

	private static File file;
	private static BufferedReader reader = null;

	public FileHelper(String s) {
		file = new File(s);
		if(!file.exists())
		{
			System.out.println("No file found! Abort.");
			System.exit(0);
		}
	}

	public static void writeFile(Matrix m){
		int[][] matrix = m.getMatrix();
		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter(new FileWriter(file));
		} catch (IOException e) {
			System.out.println("error initializing file for write");
		}
		
		try {
			writer.write(String.valueOf(m.getRows()) + "\n");
			writer.write(String.valueOf(m.getCols()) + "\n");
			
			for (int i=0;i<m.getRows();i++){
				for (int j=0;j<m.getCols();j++){
					writer.write(String.valueOf(matrix[i][j]) + " ");
				}
				writer.write("\n");
			}
		} catch (IOException e) {
			System.out.println("error while write");
		}
		try {
			writer.close();
		} catch (IOException e) {
		}
	}
	
	
	public static Matrix readFile() {
		String line;
		int m=0, n=0;
		int[][] inMat ;
		Matrix matrix = null;
		String[] inputStrings;
		
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			System.out.println("error initializing file");
			return null;
		}
		
		try {
			m = Integer.parseInt(reader.readLine());
			n = Integer.parseInt(reader.readLine());
			inMat =  new int[m][n];
			inputStrings = new String[n];
			
			for (int i=0;i<m;i++){
				line = reader.readLine();
				inputStrings = line.split(" ");
				for (int j=0;j<n;j++){
					try {
						inMat[i][j] = Integer.parseInt(inputStrings[j]);
					} catch (NumberFormatException e) {
						System.out.println("File Error: non integer format");
					}
					matrix = new Matrix(inMat , m ,n);
				}
			}
		} catch (IOException e) {
			System.out.println("error reading file @ readline");
			return null;
		}
		
		try {
			reader.close();
		} catch (IOException e) {
			System.out.println("error closing file");
		}
		return matrix;
	}
}
