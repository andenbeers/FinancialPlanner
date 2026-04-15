import java.util.Scanner;
import java.util.InputMismatchException;

public class App {


    public static void roth(Scanner scnr) {
        String name = "";
        int ageS = 0, ageR = 0, yearstoInvest = 0;
        double startBal = 0.0, monthC = 0.0, rate = 0.0, tax = 0.0, finalBal = 0.0;
        boolean inputValid = false;

        while (!inputValid) {
            try {
                System.out.println("Welcome to the Roth IRA Calculator! Please enter the following information:");

                while (true) {
                    try {
                         System.out.print("Name: ");
                        name = scnr.nextLine();
                            if (name.trim().isEmpty()) {
                                throw new IllegalArgumentException("Name cannot be empty.");
                            }
                        break; // exit loop if input is valid
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid string for the name.");
                        scnr.nextLine();
                }
                    catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
            }
               
                while (true) {
                    try {
                        System.out.print("Starting Balance: ");
                        startBal = scnr.nextDouble();
                        if (startBal < 0) {
                            throw new IllegalArgumentException("Starting balance cannot be negative.");
                        }
                        break; // exit loop if input is valid
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid number for the starting balance.");
                        scnr.nextLine();
                }
                    catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
            }
            
                while (true) {
                    try {
                        System.out.print("Starting Age: ");
                        ageS = scnr.nextInt();
                        if (ageS < 0) {
                            throw new IllegalArgumentException("Starting age cannot be negative.");
                        }
                        break; // exit loop if input is valid
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid number for the starting age.");
                        scnr.nextLine();
                }
                    catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
            }

                while (true) {
                    try {
                        System.out.print("Retirement Age: ");
                        ageR = scnr.nextInt();
                        if (ageR < 0) {
                            throw new IllegalArgumentException("Retirement age cannot be negative.");
                        }
                        if (ageR <= ageS) {
                            throw new IllegalArgumentException("Retirement age must be greater than starting age.");
                        }
                        break; // exit loop if input is valid
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid number for the retirement age.");
                        scnr.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                while (true) {
                    try {
                        System.out.print("Monthly Contribution $: ");
                        monthC = scnr.nextDouble();
                        if (monthC < 0) {
                            throw new IllegalArgumentException("Monthly contribution cannot be negative.");
                        }
                        break; // exit loop if input is valid
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid number for the monthly contribution.");
                        scnr.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                while (true) {
                    try {
                        System.out.print("Expected Annual Rate of Return %: ");
                        rate = scnr.nextDouble();
                        if (rate < 0) {
                            throw new IllegalArgumentException("Expected annual rate of return cannot be negative.");
                        }
                        break; // exit loop if input is valid
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid number for the expected annual rate of return.");
                        scnr.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                yearstoInvest = ageR - ageS;
                rate = rate / 100;
                tax = tax / 100;
                finalBal = startBal * Math.pow((1 + rate / 12), yearstoInvest * 12)
                        + monthC * (Math.pow((1 + rate / 12), yearstoInvest * 12) - 1) / (rate / 12);

                System.out.printf("Hello %s! Your Roth IRA will be worth $%.2f at age %d.\n", name, finalBal, ageR);
                inputValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter valid input.");
                scnr.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in); // create once, outside the loop
        System.out.println("Hi, welcome to your financial planner!");

        while (true) { // single loop handles everything
            System.out.println("\nPlease select an option:");
            System.out.println("1. Roth IRA Calculator\n2. Loan Calculator\n3. Exit");

            try {
                int input = scnr.nextInt();

                while (input < 1 || input > 3) {
                    System.out.println("Please enter 1, 2, or 3");
                    input = scnr.nextInt();
                }

                switch (input) {
                    case 1:
                        scnr.nextLine(); // consume newline before passing to roth()
                        roth(scnr);
                        break;
                    case 2:
                        scnr.nextLine();
                        // loan(scnr);
                        break;
                    case 3:
                        System.out.println("Goodbye!");
                        scnr.close();
                        return; // exit the program
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter 1, 2, or 3");
                scnr.nextLine();
            }
        }
    }
}