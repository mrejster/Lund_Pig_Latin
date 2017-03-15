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
        if (args.length == 0){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter a sentence" + ANSI_BLUE);
            scanner.hasNext();
            String input = scanner.nextLine();
            System.out.println(ANSI_RESET + "The translation of ' " + ANSI_GREEN  + input + ANSI_RESET + " ' is:");
            System.out.println( ANSI_RED + translateMany(input) + ANSI_RESET);
        } else if (args.length == 1){
            File f = new File(args[0]);
            if(f.exists()){ 
                System.out.println(translateFile(args[0]));
            }
            else {
                System.out.println(translateMany(args[0]));
            }
        } else {
             translationToFile(args[1],translateFile(args[0]));
        }
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

    
    public static String readFile(String path)
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
        char[] inputChars = input.toCharArray();
        char[] swipedChars = new char[inputChars.length];
        int j = 0;
        int[] letterCaseArray = detectCase(input);
        int sum = letterCaseArray[inputChars.length];
        int firstLetterCase = letterCaseArray[0];
        if (isvowel(inputChars[0])) {
            if (sum == inputChars.length){
                return input+"WAY";
            }else{
                return input+"way";
            }	
        }else{
            if (sum == inputChars.length){
                swipedChars = swipeChars(inputChars);
                return new String(swipedChars) + "AY";
            }else if (sum == 1 && firstLetterCase == 1){
                inputChars[0] = Character.toLowerCase(inputChars[0]);
                swipedChars = swipeChars(inputChars);
                swipedChars[0] = Character.toUpperCase(swipedChars[0]);
                return new String(swipedChars)+"ay";
            }else{
                swipedChars = swipeChars(inputChars);
                return new String(swipedChars)+"ay";
            }
        }
    }


    public static char[] swipeChars(char[] input){
        char[] inputChars = input;
        char[] swipedChars = new char[inputChars.length];
        int j = 0;
        while (!isvowel(inputChars[j]) && j < inputChars.length-1){
            j = j+1;
        }
        for (int k = 0; k<inputChars.length-j; k++){
            swipedChars[k] = inputChars[k+j];
        }
        for (int i = 0; i<j; i++){
            swipedChars[inputChars.length-j+i] = inputChars[i];
        }
        return swipedChars;
    }


    public static int[] detectCase(String input){
        char[] inputChars = input.toCharArray();
        int[] letterCaseArray = new int[inputChars.length+1];
        int sum = 0;
        for ( int i = 0; i<inputChars.length; i++ ){
            if (Character.isUpperCase(inputChars[i])){
                letterCaseArray[i] = 1;
                sum = sum+1;
            }else{
                letterCaseArray[i] = 0;
            }	
        }
        letterCaseArray[inputChars.length] = sum;
        return letterCaseArray;
    }


    public static boolean isvowel(char input){
        return input== 'a'|| input=='e' || input=='i'|| input=='o'|| input=='u' || input=='y' ||
            input=='A' || input=='E' || input=='I' || input=='O' || input=='U' || input=='Y';
    }


}
