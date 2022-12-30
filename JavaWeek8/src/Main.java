import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("/Users/gorgasali/Desktop/Java404/Project-1/JavaWeek8/src.dictionary.txt");
        Scanner input = new Scanner(file);
        while (input.hasNextLine()){
            String line = input.nextLine();
            System.out.println(line);
        }
        input.close();
    }
}