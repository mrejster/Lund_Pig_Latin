import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a word");
		scanner.hasNext();
		String input = scanner.next();
		System.out.println("The translation of '" + input +"' is:");
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
		int[] Xint = detectCase(input);
		int sum = Xint[X.length];
		int firstLetterCase = Xint[0];
		
		if (isvowel(X[0])) {
			if (sum==X.length){
				return input+"WAY";
			}else{
				return input+"way";	
			}	
	    }else{
	    	if (sum==X.length){
	    		Y = swipeChars(X);
	    		return new String(Y) + "AY";
			}else if (sum==1 && firstLetterCase==1){
				X[0]=Character.toLowerCase(X[0]);
				Y = swipeChars(X);
				Y[0] = Character.toUpperCase(Y[0]);
				return new String(Y)+"ay";
			}else{
				Y = swipeChars(X);
				return new String(Y)+"ay";
			}
		}
			
	}
	
	
	public static char[] swipeChars(char[] input){
		char[] X = input;
		char[] W = new char[X.length];
		int j=0;
		while ( !isvowel(X[j]) ) {
			j = j+1;
		}
		for ( int k=0; k<X.length-j; k++ ) {
			W[k]=X[k+j];
		}
		for ( int i=0; i<j; i++ ) {
			W[X.length-j+i]=X[i];
		}
		return W;
	}
	

     public static int[] detectCase(String input){
		char[] X = input.toCharArray();
		char[] Z = new char[X.length];
		int[] Xint = new int[X.length+1];
		int sum=0;
		for ( int i=0; i<X.length; i++ ){
			if ( Character.isUpperCase(X[i]) ){
				Xint[i]=1;
				sum=sum+1;
			}else{
				Xint[i]=0;
			}	
		}
		Xint[X.length]=sum;
		return Xint;
	}
		
	
	public static boolean isvowel(char input){
		return input== 'a'|| input=='e' || input=='i'|| input=='o'|| input=='u' || input=='A' || input=='E' || input=='I' || input=='O' || input=='U';
	}
	

}
