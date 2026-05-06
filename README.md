# Financial Planner
 
A Java console application that helps users make everyday financial decisions. The app brings three calculators together in one place — no spreadsheet or financial advisor needed.
 
---
 
## Features
 
- **Roth IRA Calculator** — estimates how much your retirement account will grow based on your starting balance, monthly contributions, and expected rate of return
- **Car Loan Calculator** — calculates your monthly car payment and flags it if it exceeds 15% of your salary
- **Mortgage Calculator** — calculates your fixed monthly mortgage payment using the standard amortization formula
- **Input Validation** — all three calculators share a central validation system that catches bad input and re-prompts the user instead of crashing
---

## How It Works
 
When you run the app, you are greeted with a menu:
 
```
Hi, welcome to your financial planner!
 
Please select an option:
1. Roth IRA Calculator
2. Car Loan Calculator
3. Mortgage Calculator
4. Exit
```
 
Type a number to select a calculator. The app keeps running until you choose **Exit**.
 
### Roth IRA Calculator
 
Asks for your name, starting balance, current age, retirement age, monthly contribution, and expected annual return rate. Uses the compound interest formula to project your account value at retirement.
 
### Car Loan Calculator
 
Asks for the car price, down payment, interest rate, loan term in months, and your salary. Calculates the monthly payment and warns you if it is above the recommended 15% of your monthly salary.
 
### Mortgage Calculator
 
Asks for the home price, down payment, loan term in years, and annual interest rate. Applies the standard amortization formula to calculate your fixed monthly payment.
 
---
 
## Code Structure
 
All code lives in a single file, `App.java`, organized as static methods:
 
| Method | Description |
|---|---|
| `main()` | Entry point — runs the menu loop and routes to each calculator |
| `roth()` | Roth IRA calculation logic |
| `carLoanCalculator()` | Car loan calculation logic |
| `mortgageCalculator()` | Mortgage calculation logic |
| `getStringInput()` | Shared helper — validates non-empty string input |
| `getDoubleInput()` | Shared helper — validates decimal number input with a minimum |
| `getIntInput()` | Shared helper — validates integer input with a minimum |
 
---
