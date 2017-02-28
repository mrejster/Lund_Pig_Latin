import java.util.Scanner;
public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
   

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a sentence" + ANSI_BLUE);
        scanner.hasNext();
        String input = scanner.nextLine();
        System.out.println(ANSI_RESET + "The translation of ' " + ANSI_GREEN  + input + ANSI_RESET + " ' is:");
        System.out.println( ANSI_RED + translateMany(input) + ANSI_RESET);
    }

    public static String translateMany(String input){
        char[] chars = input.toCharArray();
        String pigLatin = "";

        String tmpWord = "";
        for(int i = 0; i< chars.length; i++){
            if((chars[i] + "").matches("\\W")){
                if(tmpWord.length() > 0){
                    pigLatin += translate(tmpWord); 
                    tmpWord = "";
                }
                pigLatin += chars[i];
            } else{
                tmpWord += chars[i];
            }
        }
        if(tmpWord.length() > 0){
            pigLatin += translate(tmpWord); 
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
