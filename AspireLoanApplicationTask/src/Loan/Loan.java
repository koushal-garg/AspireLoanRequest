package Loan;

import Constants.Enums.LoanStatus;
import Loan.RePayment.RePayment;
import User.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Loan {
    public String id;
    public double amount;
    public int noOfTermDays;
    public LoanStatus status;
    public Date createdDate;
    public List<RePayment> rePayments = new ArrayList<>();
    public User user;

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

    public int getNoOfTermDays() {
        return noOfTermDays;
    }

    public void setNoOfTermDays(int noOfTermDays) {
        this.noOfTermDays = noOfTermDays;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<RePayment> getRePayments() {
        return rePayments;
    }

    public void setRePayments(List<RePayment> rePayments) {
        this.rePayments = rePayments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
