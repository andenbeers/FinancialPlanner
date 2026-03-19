import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hi, welcome to your financial planner!");

        // MENU SYSTEM
        System.out.println("Please select an option:");
        System.out.println("1. Roth IRA Calculator\n2. Loan Calculator\n3. Exit"); // could add more in the future
        Scanner scnr = new Scanner(System.in);
        int input = 0;
        while(input != 3) { // 3 for exit
            try { // might throw an InputMismatchException
                input = scnr.nextInt(); // user input

                while (input < 1 || input > 3) { // user input is not 1, 2 or 3 --> keep trying until they do
                    System.out.println("Please enter 1, 2, or 3");
                    input = scnr.nextInt(); 
                }
             
                switch(input) { // 1,2,3 for options -- could add more cases for more features in the future
                    case 1:
                        scnr.nextLine(); // when user input 1,2,3 there is still a newline cuz input is an integer
                        //roth(scnr); -- method for Roth IRA calculator
                        break;
                    case 2:
                        scnr.nextLine();
                        //loan(scnr); -- method for loan calculator
                        break;
                    case 3: // exit
                        System.out.println("Goodbye!");
                        break;
                }
            
            }
            catch (InputMismatchException ex) { // catch if user input is not an integer
                System.out.println("Please enter 1, 2, or 3");
                scnr.next(); // flush and reset input
            }
        }
    }

}
