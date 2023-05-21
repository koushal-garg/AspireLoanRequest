package Loan;

import Constants.Enums.LoanRePaymentFrequency;
import Constants.Enums.LoanRePaymentStatus;
import Constants.Enums.LoanStatus;
import Loan.RePayment.RePayment;
import User.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoanController {
    /**
     * This function take required attributes and return loan object.
     * */
    public Loan createLoan(double amount, int noOfTermDays, LoanRePaymentFrequency loanRePaymentFrequency, User user, String loanId) {
        Loan loan = new Loan();
        loan.setAmount(amount);
        loan.setNoOfTermDays(noOfTermDays);
        loan.setStatus(LoanStatus.PENDING);
        loan.setCreatedDate(new Date());
        loan.setUser(user);
        loan.setId(loanId);
        // creating and setting loan rePayment in Loan Object.
        loan.setRePayments(createLoanRepayment(amount, noOfTermDays, loanRePaymentFrequency));
        return loan;
    }

    /**
     * This function take required attributes and return Loan RePayment List for a particular Loan.
     * Currently we are handling weekly rePayment frequency but we can handle other frequency also here according to requirement.
     * */
    public List<RePayment> createLoanRepayment(double amount, int noOfTermDays, LoanRePaymentFrequency loanRePaymentFrequency) {
        List<RePayment> rePayments = new ArrayList<>();
        if(loanRePaymentFrequency.equals(LoanRePaymentFrequency.WEEKLY)) {
            double rePaymentAmount = amount/noOfTermDays;
            Date date = new Date();
            for(int i=0;i<noOfTermDays;i++) {
                RePayment rePayment = new RePayment();
                rePayment.setAmount(rePaymentAmount);
                rePayment.setId(Integer.toString(i+1));
                long time = date.getTime() + (i+1)*7*24*60*60*1000;
                rePayment.setRePaymentDate(new Date(time));
                rePayment.setStatus(LoanRePaymentStatus.PENDING);
                rePayments.add(rePayment);
            }
        }
        return rePayments;
    }

    /**
     * This function print loan details. we can print other loan details as per requirement.
     * */
    public void printLoan(Loan loan) {
        System.out.println();
        System.out.println("------------------Loan Details as below------------------");
        System.out.println("Loan Id: " + loan.getId());
        System.out.println("Loan Amount: " + loan.getAmount());
        System.out.println("Loan Status: " + loan.getStatus());
        List<RePayment> rePayments = loan.getRePayments();
        for(RePayment rePayment: rePayments) {
            System.out.println("RePayment Id = " + rePayment.getId() + ", Repayment Amount = " + rePayment.getAmount() + ", Repayment Status = " + rePayment.getStatus() + ", Date = " + rePayment.getRePaymentDate());
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println();
    }

    /**
     * Admin can approve loan by using this function call.
     * Currently, we are not validating user here for approval but if required we can take userId as input and can validate user before approval.
     * */
    public void approveLoan(Loan loan) {
        // we can have required validation here before approval.
        // after all approval logic we will change loan status as Approved.
        loan.setStatus(LoanStatus.APPROVED);
    }

    /**
     * By this function we can add rePayment for a particular loan. and will update loan status if all repayment becomes paid.
     * Currently, we don't have any validation on amount but we can take amount as input and put appropriate validation here and throw proper
     * error as per requirement.
     * */
    public void addRePayment(Loan loan, String rePaymentId) {
        List<RePayment> rePayments = loan.getRePayments();
        int countOfPaidRePayment = 0;
        for (RePayment rePayment : rePayments) {
            if (rePayment.getId().equals(rePaymentId)) {
                rePayment.setStatus(LoanRePaymentStatus.PAID);
            }
            if (rePayment.getStatus().equals(LoanRePaymentStatus.PAID)) {
                countOfPaidRePayment++;
            }
        }
        // If all RePayment becomes PAID then we will mark loan status as PAID also.
        if(countOfPaidRePayment == rePayments.size()) {
            loan.setStatus(LoanStatus.PAID);
        }
    }
}
