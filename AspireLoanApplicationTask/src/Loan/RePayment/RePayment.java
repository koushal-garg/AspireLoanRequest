package Loan.RePayment;

import Constants.Enums.LoanRePaymentStatus;

import java.util.Date;

public class RePayment {
    public String id;
    public double amount;
    public Date rePaymentDate;
    public LoanRePaymentStatus status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getRePaymentDate() {
        return rePaymentDate;
    }

    public void setRePaymentDate(Date rePaymentDate) {
        this.rePaymentDate = rePaymentDate;
    }

    public LoanRePaymentStatus getStatus() {
        return status;
    }

    public void setStatus(LoanRePaymentStatus status) {
        this.status = status;
    }
}
