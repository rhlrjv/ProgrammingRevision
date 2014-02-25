import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

// ******************* start of file Intro.java ******************

// the overall class name must match the file prefix; i.e. the name of
// this file must be Intro.java

// usage:  java Intro nums

// introductory program; reads integers from the command line,
// storing them in a linear linked list, maintaining ascending order,
	// and then prints out the final list to the screen
	
	public class Intro
	
	{ // standalone Java programs must have a main() function, which is the
	// point where execution begins

	public static void main(String[] Args) {

		int NumElements = Args.length;

		for (int I = 0; I < NumElements; I++) {
			int Num;
			Num = ConvertArg(Args[I]);
			// create a new node
			NumNode NN = new NumNode(Num);
			NN.Insert();
		}

		System.out.println("final sorted list:");
		NumNode.PrintList();

	}

	static int ConvertArg(String Arg)

	{
		DataInputStream In = new DataInputStream(System.in);
		InputStreamReader Ins = new InputStreamReader(In);
		BufferedReader Inb = new BufferedReader(Ins);
		while (true) {
			try {
				int N = Integer.parseInt(Arg);
				return N;
			} catch (NumberFormatException NFE) {
				System.out.println("bad command-line argument--" + NFE);
				System.out.println("enter number again, or type q for quit");
				try {
					Arg = Inb.readLine();
				} catch (IOException IOE) {
					System.out.println("failed to read correction--" + IOE);
					System.exit(1);
				}
				if (Arg.equals("q"))
					System.exit(1);
			}
		}
	}

}
