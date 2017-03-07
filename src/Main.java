import java.util.Scanner;
import java.util.*;
import java.nio.*;
import java.nio.file.*;
import java.io.*;

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

    public static String translateFile(String file){
        try{
            return translateMany(readFile(file));
        }catch(IOException e){

        }
        return "";

    }

    public static void translationToFile(String file, String translation){
        try{
            Files.write(Paths.get(file),translation.getBytes());
        }catch(IOException e){

        }
    }

    static String readFile(String path) 
        throws IOException 
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
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
        while ( !isvowel(X[j]) && j < X.length-1  ) {
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
        return input== 'a'|| input=='e' || input=='i'|| input=='o'|| input=='u' || input=='y' ||
            input=='A' || input=='E' || input=='I' || input=='O' || input=='U' || input=='Y';
    }


}
