import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.print("Enter date in dd/mm/yyyy format: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        sc.close();

        Date givenDate = Date.CreateDate(input);
        if(givenDate.equals(givenDate.ReverseDate())) {
            System.out.println("Given date is Palindrome");
            return;
        }
        System.out.println("Given date is not Palindrome");
        return;
    }
}
