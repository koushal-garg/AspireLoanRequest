import Constants.Enums.LoanRePaymentFrequency;
import Constants.Enums.UserRole;
import Loan.Loan;
import User.User;
import Loan.LoanController;
import User.UserController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        LoanController loanController = new LoanController();
        Scanner scanner = new Scanner(System.in);


        // User creation in system.
        System.out.println("We are creating a user in system for customer.");
        System.out.println("Please Enter userId");
        String userId = scanner.nextLine();
        System.out.println("Please Enter username");
        String userName = scanner.nextLine();
        User user = userController.createUser(userId, userName, UserRole.CUSTOMER);
        System.out.println("User is created with these details: " + user.toString());


        // creating a loan request.
        System.out.println("We are creating a loan request now.");
        System.out.println("Please Enter loan Id");
        String loanId = scanner.nextLine();
        System.out.println("Please Enter loan amount");
        double loanAmount = scanner.nextDouble();
        System.out.println("Please Enter no of term days");
        int noOfTermDays = scanner.nextInt();
        Loan loan = loanController.createLoan(loanAmount, noOfTermDays, LoanRePaymentFrequency.WEEKLY, user, loanId);
        System.out.println("loan is created.");
        loanController.printLoan(loan);


        // admin approving the loan here.
        System.out.println("Please Enter 1 for loan approval.");
        int approval = scanner.nextInt();
        loanController.approveLoan(loan);
        System.out.println("Loan got approved.");


        // show loan details to user.
        loanController.printLoan(loan);


        // adding repayment of loan
        for(int i=0;i<noOfTermDays;i++) {
            System.out.println("Please Enter " + (i+1) + " for " + (i+1) + " RePayment.");
            int rePayment = scanner.nextInt();
            loanController.addRePayment(loan, Integer.toString(i+1));
            loanController.printLoan(loan);
        }

        // printing loan details after all operations.
        loanController.printLoan(loan);
        scanner.close();
    }
}