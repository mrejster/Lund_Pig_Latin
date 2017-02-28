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
	
	public static String translateMany(String input){
        String[] words = input.split("\\s+");
        String[] space = input.split("\\w+");
        String pigLatin = "";
        for(int i = 0; i < words.length; i++){
             pigLatin += space[i] + translate(words[i]);
        }
        return pigLatin;
    }
	
	public static String translate(String input){
		char[] X = input.toCharArray();
		char[] Y = new char[X.length];
		int j = 0; 
		if (isvowel(X[0])) {
			return input + "way";
	  } else {
			while ( !isvowel(X[j]) ) {
				j = j+1;
				}
			for ( int k=0; k<X.length-j; k++ ) {
				Y[k]=X[k+j];
				}
			for ( int i=0; i<j; i++ ) {
				Y[X.length-j+i]=X[i];
				}
			}
	
		return new String(Y)+"ay";
	}
	
	public static boolean isvowel(char input){
		return input== 'a'|| input=='e' || input=='i'|| input=='o'|| input=='u';
	}
	

}
