import java.util.Scanner;
import java.util.InputMismatchException;

public class App {

    private static String getStringInput(Scanner scnr, String prompt) {
        while (true) {
          try {
              System.out.print(prompt);
              String input = scnr.nextLine();
                if (input.trim().isEmpty()) throw new IllegalArgumentException("Input cannot be empty.");
                  return input;
            }
           
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    private static double getDoubleInput(Scanner scnr, String prompt, double min) {
        while (true) {
          try {
             System.out.print(prompt);
             double input = scnr.nextDouble();
               if (input < min) throw new IllegalArgumentException("Value must be at least " + min + ".");
                  return input;
            }

            catch (InputMismatchException e) {
               System.out.println("Please enter a valid number.");
               scnr.nextLine();
            }

            catch (IllegalArgumentException e) {
              System.out.println(e.getMessage());
            }
        }
    }

    private static int getIntInput(Scanner scnr, String prompt, int min) {
        while (true) {
           try {
            System.out.print(prompt);
            int input = scnr.nextInt();
            if (input < min) throw new IllegalArgumentException("Value must be at least " + min + ".");
            return input;
           }
          
           catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            scnr.nextLine();
           }
         
          catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
           }
        }
    }
    
    public static void roth(Scanner scnr) {
        String name = "";
        int ageS = 0, ageR = 0, yearstoInvest = 0;
        double startBal = 0.0, monthC = 0.0, rate = 0.0, tax = 0.0, finalBal = 0.0;
        boolean inputValid = false;

        while (!inputValid) {
            try {
                System.out.println("Welcome to the Roth IRA Calculator! Please enter the following information:");

                name     = getStringInput(scnr, "Name: ");
                startBal = getDoubleInput(scnr, "Starting Balance: ", 0);
                ageS     = getIntInput(scnr, "Starting Age: ", 0);
                ageR     = getIntInput(scnr, "Retirement Age: ", ageS + 1); // enforces > ageS
                monthC   = getDoubleInput(scnr, "Monthly Contribution $: ", 0);
                rate     = getDoubleInput(scnr, "Expected Annual Rate of Return %: ", 0);

                yearstoInvest = ageR - ageS;
                rate = rate / 100;
                tax = tax / 100;
                finalBal = startBal * Math.pow((1 + rate / 12), yearstoInvest * 12)
                        + monthC * (Math.pow((1 + rate / 12), yearstoInvest * 12) - 1) / (rate / 12);

                System.out.printf("Hello %s! Your Roth IRA will be worth $%.2f at age %d.\n", name, finalBal, ageR);
                inputValid = true;
            }
            
            catch (InputMismatchException e) {
                System.out.println("Please enter valid input.");
                scnr.nextLine();
            }
        }
    }

    public static void mortgageCalculator(Scanner scnr) {
        int homePrice, downPayment, loanTerm;
        double interestRate, loanAmount, monthlyInterestRate, monthlyPayments, mortgageAmount;
        boolean inputValid = false;

        while (!inputValid) {
            try {
                // Find home price, down payment, loan term, and interest rate from user input
                System.out.println("Welcome to the Mortgage Calculator! Please enter the following information:");
                homePrice = getIntInput(scnr, "Home Price: ", 0);
                downPayment = getIntInput(scnr, "Down Payment: ", 0);
                loanTerm = getIntInput(scnr, "Loan Term in years: ", 0);
                interestRate = getDoubleInput(scnr, "Annual Interest Rate as a decimal %: ", 0);
                
                // Find loan amount, monthly interest rate, number of monthly payments, and mortgage amount
                loanAmount = homePrice - downPayment;
                monthlyInterestRate = (interestRate / 100.0) / 12.0;
                monthlyPayments = loanTerm * 12;
                mortgageAmount = loanAmount * (monthlyInterestRate * Math.pow (1 + monthlyInterestRate, monthlyPayments)) / (Math.pow(1 + monthlyInterestRate, monthlyPayments) - 1);
                
                // Output mortgage amount to user
                System.out.printf("Your monthly mortgage payment will be $%.2f.\n", mortgageAmount);
                inputValid = true;
            }
            // catch invalid input
            catch (InputMismatchException e) {
                System.out.println("Please enter valid input.");
                scnr.nextLine();
            }
        }
    }

    public static void carLoanCalculator(Scanner scnr) {
        double CarPrice = 0.0; 
        double DownPayment = 0.0; 
        double InterestRate = 0.0; 
        double MonthlyRate = 0.0;
        double MonthlyPayment = 0.0;
        double LoanAmount = 0.0;
        int LoanTerm = 0;  //loan term in months
        int Salary = 0;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the total price of the car please");
        CarPrice = sc.nextDouble(); 
        System.out.println("Enter the down payment please");
        DownPayment = sc.nextDouble();
        System.out.println("Enter the interest rate please ");
        InterestRate = sc.nextDouble();
        System.out.println("Enter the term of the loan in months please");
        LoanTerm = sc.nextInt();
        System.out.println("Enter your salary please ");
        Salary = sc.nextInt();
        Double IdealPayment = 0.15*Salary;
        
        if (CarPrice <= 0 || InterestRate < 0 || LoanTerm <= 0 || DownPayment < 0){
            System.out.println("Please enter correct values");
        }
        else {
            LoanAmount = CarPrice - DownPayment;
            if (LoanAmount <= 0){
                System.out.println("please input correct values");
            }
            else {
                if (InterestRate == 0){
                    MonthlyPayment = LoanAmount/LoanTerm;
                    System.out.println("The monthly payment would be "+MonthlyPayment);
                    if (MonthlyPayment > IdealPayment){
                        System.out.println("Your monthly payment is too high! try other options such as increasing the down payment");
                    }
                }
                else {
                    MonthlyRate = InterestRate /(12*100);
                    MonthlyPayment = (LoanAmount * MonthlyRate * Math.pow(1 + MonthlyRate, LoanTerm)) 
                        / (Math.pow(1 + MonthlyRate, LoanTerm) - 1);
                    System.out.println("The monthly payment would be "+MonthlyPayment);
                    if (MonthlyPayment > IdealPayment){
                        
                        System.out.println("Your monthly payment is too high! try other options such as increasing the down payment");
                    }
                    
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in); // create once, outside the loop
        System.out.println("Hi, welcome to your financial planner!");

        while (true) { // single loop handles everything
            System.out.println("\nPlease select an option:");
            System.out.println("1. Roth IRA Calculator\n2. Loan Calculator\n3. Mortgage Calculator\n4. Exit");

            try {
                int input = scnr.nextInt();

                 while (input < 1 || input > 4) {
                    System.out.println("Please enter 1, 2, 3, or 4");
                    input = scnr.nextInt();
                 }

                switch (input) {
                    case 1:
                        scnr.nextLine(); // consume newline before passing to roth()
                        roth(scnr);
                        break;
                    case 2:
                        scnr.nextLine();
                        carLoanCalculator(scnr);
                        break;
                    
                    case 3:
                        scnr.nextLine();
                        mortgageCalculator(scnr);
                        break;
                    case 4:
                        System.out.println("Goodbye!");
                        scnr.close();
                        return; // exit the program
                }
            } 
            catch (InputMismatchException ex) {
                System.out.println("Please enter 1, 2, 3, or 4");
                scnr.nextLine();
            }
        }
    }
}