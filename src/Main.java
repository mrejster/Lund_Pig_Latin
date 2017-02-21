import java.util.Scanner;
public class Main {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a word");
		scanner.hasNext();
		String input = scanner.next();
		System.out.println("The translation of ' " + input +" ' is:");
		System.out.println(translate(input));
	}
	
	public static String translate(String input){
		return "igpay";
	}
	
}