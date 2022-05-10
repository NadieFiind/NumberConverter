import java.util.*;

enum Mode {
	BINARY,
	OCTAL,
	HEXADECIMAL
}

public class Main {
	static String convert(int decimal, int base) {
		char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		String result = "";
		
		while (decimal > 0) {
			result = digits[decimal % base] + result;
			decimal /= base;
		}
		
		return result;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Mode mode = Mode.BINARY;
		
		inputLoop: while (true) {
			System.out.print(mode + ": ");
			String input = scanner.nextLine();
			
			switch (input) {
				case "EXIT":
					break inputLoop;
				case "BINARY":
					mode = Mode.BINARY;
					break;
				case "OCTAL":
					mode = Mode.OCTAL;
					break;
				case "HEXADECIMAL":
					mode = Mode.HEXADECIMAL;
					break;
				default:
					try {
						int decimal = Integer.parseInt(input);
						int base;
						
						switch (mode) {
							case BINARY:
								base = 2;
								break;
							case OCTAL:
								base = 8;
								break;
							case HEXADECIMAL:
								base = 16;
								break;
							default:
								base = 2;
						}
						
						System.out.println(convert(decimal, base));
					} catch (NumberFormatException error) {
						System.out.println("Invalid input.");
					}
			}
		}
	}
}
