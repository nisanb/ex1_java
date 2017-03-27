import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

	private static Integer studentMistakes, minBorder, maxBorder, totalCorrect = 0;
	private static Random r = new Random();
	private static String solution;

	public static void main(String[] args) throws IOException, InterruptedException {
		args = new String[] { "1", "100", "200" };
		// Take care of arguments exception
		if (args.length != 3) {
			System.out.println("Invalid number of arguments.");
			return;
		}

		// Define Arguments
		studentMistakes = Integer.parseInt(args[0]);
		minBorder = Integer.parseInt(args[1]);
		maxBorder = Integer.parseInt(args[2]);
		Scanner reader = new Scanner(System.in);

		// Menu
		while (true) {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

			System.out.println("Please use the below menu to perform tasks:");
			System.out.println("(S) - Start Over");
			System.out.println("(I) - Insert new variable");
			System.out.println("(W) - Show most wins in row");
			System.out.println("(Q) - Quits");
			System.out.println("\n\nEnter choice: ");
			char ch = String.valueOf(reader.next().charAt(0)).toUpperCase().toCharArray()[0];

			switch (ch) {
			case 'S': // This will calculate a random number and let the student
						// solve

				if (studentMistakes == 0) {
					System.out.println("It seems like you have no more mistakes left.");
					System.out.println("Returning...");
					Thread.sleep(3000);
					continue;
				}
				Integer numToCalculate = r.nextInt(maxBorder) + minBorder;
				System.out.println("The number for your excercise is: " + numToCalculate);
				System.out.print("Please convert it to ");

				switch (r.nextInt(4) + 1) {
				case 1:
					System.out.print("Binary(" + binary(numToCalculate) + ")");
					solution = binary(numToCalculate);
					break;
				case 2:
					System.out.print("Octal(" + octal(numToCalculate) + ")");
					solution = octal(numToCalculate);
					break;
				case 3:
					System.out.print("HexaDecimal(" + hexadecimal(numToCalculate) + ")");
					solution = hexadecimal(numToCalculate);
					break;
				case 4:
					System.out.print("Quanterary(" + quaternary(numToCalculate) + ")");
					solution = quaternary(numToCalculate);
					break;
				}
				System.out.print(": ");
				String in = reader.next();
				if (in.equals(solution)) {
					System.out.println("Nice!");
					totalCorrect++;
				} else {
					System.out.println("Sorry, you have mistaken.");
					studentMistakes--;
					totalCorrect = 0;
				}

				break;
			case 'I': // This will let the student insert new variables
				System.out.println("Please insert number of mistakes: ");
				studentMistakes = Integer.parseInt(reader.next());
				System.out.println("Please insert lower bound of number randomizer: ");
				minBorder = Integer.parseInt(reader.next());
				System.out.println("Please insert max bound of number randomizer: ");
				maxBorder = Integer.parseInt(reader.next());

				break;
			case 'W': // This will show most wins in a row
				System.out.println("\nTotal correct answers in a row so far: " + totalCorrect);
				break;
			case 'Q': // Print to the student the most wins in a row and quit
				System.out.println("\nTotal correct answers in a row so far: " + totalCorrect);
				return;

			default:
				System.out.println("Please enter a valid key !\nReturning..");
				break;
			}

			System.out.println("Restarting application..");
			Thread.sleep(3000);
		}

	}

	// This method convert decimal to binary base
	public static String binary(int num) {
		return Integer.toBinaryString(num);
	}

	// This method convert decimal to octal base
	public static String octal(int num) {
		return Integer.toString(num, 8);
	}

	// This method convert decimal to hexadecimal base
	public static String hexadecimal(int num) {
		return Integer.toString(num, 16);
	}

	// This method convert decimal to quaternary base
	public static String quaternary(int num) {
		return Integer.toString(num, 4);
	}

}
