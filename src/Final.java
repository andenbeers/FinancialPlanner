
import java.util.Scanner;
class CarLoan {
    public static void main(String[] args) {
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
}