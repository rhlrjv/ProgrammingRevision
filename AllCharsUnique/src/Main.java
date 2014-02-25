import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Enter the String : ");
		BufferedReader inBR = new BufferedReader(new InputStreamReader(
				System.in));

		String InputString = null;

		try {
			InputString = inBR.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out
					.println("IO error trying to read string! Please retry : ");

			InputString = null;
			try {
				InputString = inBR.readLine();
			} catch (IOException e1) {
				System.out.println("Repeated IO error. Quiting program");
				System.exit(1);
			}
		}

		System.out.print("String contains Email : ");
		if (hasEmail(InputString))
			System.out.println("True");
		else
			System.out.println("False");

		System.out.print("String is all unique : ");
		if (allUnique(InputString))
			System.out.println("True");
		else
			System.out.println("False");

		System.out.println("Reversed String : "
				+ strReverse(InputString.toCharArray()));
		
		System.out.println("Without Duplicates: "
				+ RemoveDuplicates(InputString.toCharArray()));
	}

	private static boolean hasEmail(String Str) {

		boolean result = false;
		try {
			String regex = "([a-z0-9_.-]+)@([0-9a-z.-]+).([a-z.]{2,6})";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(Str);
			if (matcher.find()) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("regex error");
		}
		return result;
	}

	private static boolean allUnique(String Str) {
		boolean[] chars = new boolean[26];
		for (int i = 0; i < Str.length(); i++) {
			int ch = Str.charAt(i);
			if (ch >= 'a' && ch <= 'z') {
				ch = ch - 'a';
			} else if (ch >= 'A' && ch <= 'Z') {
				ch = ch - 'A';
			} else
				continue;

			if (chars[ch])
				return false;
			else
				chars[ch] = true;
		}
		return true;
	}

	private static String strReverse(char[] Str) {
		// StringBuffer SB = new StringBuffer(Str);
		// return SB.reverse().toString();
		int l = Str.length;
		for (int i = 0, j = l - 1; i < j; i++, j--) {
			Str[i] += Str[j];
			Str[j] = (char) (Str[i] - Str[j]);
			Str[i] -= Str[j];
		}
		return String.valueOf(Str);
	}

	private static String RemoveDuplicates(char[] Str) {
		if (Str == null)
			return "Error: Emply String";

		int l = Str.length;

		if (l > 1) {
			boolean[] chars = new boolean[26];

			for (int i = 0; i < l;) {
				int ch = Str[i];
				if (ch >= 'a' && ch <= 'z') {
					ch = ch - 'a';
				} else if (ch >= 'A' && ch <= 'Z') {
					ch = ch - 'A';
				} else{
					i++;
					continue;
				}
					

				if (chars[ch]) { // already present
					for (int j = i; j < l - 1; j++) {
						// left shift
						Str[j] = Str[j + 1];
					}
					l = l-1;
					if(i > l-1)
						break;
				} else {
					chars[ch] = true;
					i++;
				}
			}
		}
		return String.valueOf(Str).substring(0,l);
	}
}
