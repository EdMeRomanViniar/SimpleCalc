package edme.rv;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcAppl {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a new expression: ");
		String input = scanner.nextLine();

		try {
			String result = calc(input);
			System.out.println("Result: " + result);
		} catch (IllegalArgumentException | ArithmeticException e) {
			System.out.println("Error: " + e.getMessage());
		}

		scanner.close();
	}

	public static String calc(String input) {
		if (!isValidExpression(input)) {
			throw new IllegalArgumentException("wrong input value. try again!");
		}

		String regex = "[\\+\\-\\*/]";
		String[] myNumbers = input.split(regex);
		int a = Integer.parseInt(myNumbers[0]);
		int b = Integer.parseInt(myNumbers[1]);
		int res = 0;
		if (input.contains("+")) {
			res = a + b;
		}
		if (input.contains("-")) {
			res = a - b;
		}
		if (input.contains("*")) {
			res = a * b;
		}
		if (input.contains("/")) {
			res = a / b;
		}
		String result = res + "";
		return result;
	}

	public static boolean isValidExpression(String input) {
		String regex = "^(10|[1-9])\\s*[\\+\\-\\*/]\\s*(10|[1-9])$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}

}
