import java.util.*;

enum Mode {
	BINARY,
	OCTAL,
	HEXADECIMAL
}

public class Main {
	static String convert(int decimal, int base) {
		if (decimal == 0) return "0";
		
		boolean isNegative = decimal < 0;
		decimal = Math.abs(decimal);
		
		char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		String result = "";
		
		while (decimal > 0) {
			result = digits[decimal % base] + result;
			decimal /= base;
		}
		
		return isNegative ? "-" + result : result;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Mode mode = Mode.BINARY;
		
		System.out.println("OPTIONS:");
		System.out.println("  binary");
		System.out.println("  octal");
		System.out.println("  hexadecimal");
		System.out.println("  exit\n");
		
		inputLoop: while (true) {
			System.out.print(String.format("(%s): ", mode));
			String input = scanner.nextLine().trim();
			
			switch (input.toUpperCase()) {
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
