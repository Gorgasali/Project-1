import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class emailProject {
    private static String first_name;
    private static String last_name;
    private  static String department_name;
    public static void userInput() throws IOException {
//        //Getting user info and store it in hashmap
        //First name
        Scanner name = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        first_name = name.nextLine();
        //Last name
        Scanner lastName = new Scanner(System.in);
        System.out.println("Enter your last name: ");
        last_name = lastName.nextLine();
        //Department
        Scanner department = new Scanner(System.in);
        System.out.println("Enter your department: ");
        department_name = department.nextLine();
    }
    // This method is used to create random password
    public static String randomPassword() throws IOException {
        Random rand = new Random();

        String password = rand.ints(48, 123).limit(16)
                .mapToObj(c -> (char)c).collect(StringBuffer::new, StringBuffer::append, StringBuffer::append)
                .toString();
        return password;

    }
    //This method is used to change or leave default password
    public static void changePassword() throws IOException {
        String newPassword = randomPassword();
        System.out.println("\nThis is recommended password: " + newPassword);
        Scanner respond = new Scanner(System.in);
        System.out.println("\nDo you want to change a password? y/n ");
        String respondStr = respond.nextLine();

        if (respondStr.equalsIgnoreCase("y")) {
            System.out.println("Enter new password: ");
            Scanner newPass = new Scanner(System.in);
            newPassword = newPass.nextLine();
        }
        System.out.println("Your password is: " + newPassword);
    }
    // This method is used to print information
    public static  void getInfo(String first_name, String last_name, String department_name) throws IOException {
        String fullName = first_name + " " +  last_name;
        String email = first_name + last_name + "." + department_name + "@company.com";
        //Printing full name and email
        System.out.println("username: " + fullName);
        System.out.println("your email: " + email.toLowerCase());
    }
    public static void main(String[] args) throws IOException {
        userInput();
        changePassword();
        getInfo(first_name,last_name,department_name);
    }
}