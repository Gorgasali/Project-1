import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise2 {
    public static void checkInput () {
        Scanner strNum =new Scanner(System.in);
        System.out.println("Enter a number to check your input that many times");
        int n= strNum.nextInt();
            // Regex patterns to define input
            final Pattern emailPattern = Pattern.compile("^(.+)@(.+)$");
            final Pattern phoneNumberPattern = Pattern.compile("^\\((\\d{3})\\)\\d{3}-\\d{4}$");
            final Pattern addressPattern = Pattern.compile("^(\\d{1,}) [a-zA-Z0-9\\s]+(\\,)? [a-zA-Z]+(\\,)? [A-Z]{2} [0-9]{5,6}$");
            System.out.println("You entered the following strings:");
            for (int i = 1; i <= n; i++) {
                System.out.println("Enter string #" + i);
                Scanner inStr = new Scanner(System.in);
                String str = inStr.nextLine();
                Matcher email_Matcher = emailPattern.matcher(str);
                Matcher phone_Number_Matcher = phoneNumberPattern.matcher(str);
                Matcher Address_Pattern = addressPattern.matcher(str);
                if (email_Matcher.matches()) {
                    String username = email_Matcher.group();
                    System.out.println("Your input: \"" + username + "\" is an email");
                } else if (phone_Number_Matcher.matches()) {
                    String areaCode = phone_Number_Matcher.group(1);
                    System.out.println("Your input is a phone number with area code (" + areaCode + ")");
                } else if (Address_Pattern.matches()) {
                    String address = Address_Pattern.group();
                    System.out.println("It's an address: " + address);
                } else System.out.println("NO MATCH");
            }
       // }

    }

    public static void main(String[] args) {
        checkInput();
    }

    }


