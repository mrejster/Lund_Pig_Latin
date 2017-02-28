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
        char[] X = input.toCharArray();
        char[] Y = new char[X.length];
        if (isvowel(X[0])) {
            return input + "way";
        } else {
            for (int i=0; i<X.length-1;i++){
                Y[i] = X[i+1];
            }
            Y[X.length-1] = X[0];
        }
        return new String(Y)+"ay";
    }

    public static boolean isvowel(char input){
        return input== 'a'|| input=='e' || input=='i'|| input=='o'|| input=='u';
    }



}
