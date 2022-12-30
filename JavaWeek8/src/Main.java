import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void findPalindrome() throws FileNotFoundException
    {
        //opening text file to read data
        File file = new File("/Users/gorgasali/Desktop/Java404/Project-1/JavaWeek8/src/dictionary.txt");
        Scanner input = new Scanner(file);
        while (input.hasNextLine()){
            String line = input.nextLine();
            // String variable to store reverse word
            String rev = "";
            // loop to reverse words
            for (int i = line.length() - 1; i >= 0; i--) {
                rev = rev + line.charAt(i);
            }

            // Checking if original and reverse words are equal
            if (line.equals(rev)) {
                // Printing all palindrome words
                System.out.println(line);
            }

        }
        input.close();
    }
    public static void printBtoM() throws FileNotFoundException {
        int count =0;               //variable to store vowels
        String longestWord = "";    //variable to store longest word
        File file = new File("/Users/gorgasali/Desktop/Java404/Project-1/JavaWeek8/src/dictionary.txt");
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            // checking words from b to m with ascii code
            for(char i =98; i<= 109; i++ ){
                // This checks first letter of the word
                if (line.startsWith(String.valueOf(i))) {
                    if (line.length() >= longestWord.length()){
                        longestWord = line;
                    }
                    // using regex to count all the vowels
                    Pattern pattern = Pattern.compile("(?i)[aeiouy]");
                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        count++;
                }
            }
            }
        }
        // Printing output of this method
        System.out.println("From 'b' to 'm' there are: " + count + " vowels.");
        System.out.println("'" + longestWord + "' is the longest word in the range from 'b' to 'm'.");
    }




    public static void mostWords() throws FileNotFoundException {
        HashMap<String, ArrayList<String>> words = new HashMap<String, ArrayList<String>>();
        int count = 0;
        ArrayList<String> values = new ArrayList<String>();
        File file = new File("/Users/gorgasali/Desktop/Java404/Project-1/JavaWeek8/src/dictionary.txt");
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String line = input.nextLine();
                if (words.containsKey(String.valueOf(line.charAt(0)))) {
                    words.get(String.valueOf(line.charAt(0))).add(line);
                } else {
                    words.put(String.valueOf(line.charAt(0)), new ArrayList<String>());
                    words.get(String.valueOf(line.charAt(0))).add(line);
                }

        }
        int mostWords = 0;
        int group = 0;
        for (char i = 97 ; i <= 122; i++){
            if (words.get(String.valueOf(i)).size() >= mostWords){
                mostWords = words.get(String.valueOf(i)).size();
                group = i;
            }

        }

        System.out.println("Group: " + (char) group + " is the largest group with: " + mostWords + " words");
        input.close();
    }
    public static void main(String[] args) throws FileNotFoundException {
       // findPalindrome();
        printBtoM();
       // mostWords();
    }

}