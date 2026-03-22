import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
    public static double roth(Scanner scnr){ // ROTH IRA CALCULATOR
        String name = "";
        int ageS = 0, ageR = 0, yearstoInvest = 0; // Formula variables
        double startBal = 0.0, monthC = 0.0, rate = 0.0, tax = 0.0, finalBal = 0.0;
        boolean inputValid = false;
        
        while (!inputValid){ // loop until user input is valid
            try {
                scnr.nextLine(); // when user input 1,2,3 there is still a newline cuz input is an integer
                System.out.println("Welcome to the Roth IRA Calculator! Please enter the following information:");
                System.out.print("Name: ");
                name = scnr.nextLine();
                System.out.print("Starting Balance: ");
                startBal = scnr.nextDouble();
                System.out.print("Starting Age: ");
                ageS = scnr.nextInt();
                System.out.print("Retirement Age: ");
                ageR = scnr.nextInt();

                while (ageR < ageS) {
                    System.out.println("Retirement age must be greater than starting age. Please enter a valid retirement age.");
                    ageR = scnr.nextInt();
                }
                
                System.out.print("Monthly Contribution $: ");
                monthC = scnr.nextDouble();
                System.out.print("Expected Annual Rate of Return %: ");
                rate = scnr.nextDouble();
                
                while (rate < 0) {
                    System.out.println("Please enter a positive number for the expected rate of return.");
                    rate = scnr.nextDouble();
                }
                //System.out.print("Tax Rate %: "); // roth ira is tax free, could add to traditional ira
                //tax = scnr.nextDouble();

                // Formula:
                //Starting Balance * ((1 + Annual Return/12)^(Retirement Age - Starting Age)*12) + Monthly Contribution Amount * ((1 + Annual Return/12) ^ (Retirement Age - Current Age)*12 -1) / (Annual Return/12))
                
                yearstoInvest = ageR - ageS;
                rate = rate / 100; // convert % to decimal
                tax = tax / 100;
                finalBal = startBal * Math.pow((1 + rate/12), yearstoInvest*12) + monthC * (Math.pow((1 + rate/12), yearstoInvest*12) - 1) / (rate/12); // without tax
                //finalBal = finalBal * (1 - tax); // with tax
                System.out.printf("Hello %s! Your Roth IRA will be worth $%.2f at age %d.\n", name, finalBal, ageR);
                System.out.println("Press 1 for another calculation or 3 to exit.");
                inputValid = true; // stop loop
                return finalBal;
            }
            catch (InputMismatchException e) {
                System.out.println("Please enter valid datatype - String for name, Integer for age, Double for balance, contribution, rate, and tax.");        
                scnr.nextLine(); // flush and reset input
            }
        }
        return finalBal;
    }
    
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
                        scnr.nextLine(); 
                        roth(scnr); // method for Roth IRA calculator
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
