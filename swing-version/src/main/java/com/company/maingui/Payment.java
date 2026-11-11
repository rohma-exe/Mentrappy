package com.company.maingui;
/**
 *
 * @author ProBook
 */
public class Payment {
    private String cardNumber;
    private String expirationDate;
    private String cvv;
    private int amount;
    private boolean paymentSuccessful;

    public Payment(){
        this.cardNumber = " ";
        this.expirationDate = " ";
        this.cvv = " ";
        this.paymentSuccessful = false;
    }

    public Payment(String c, String e, String v, int a){
        this.cardNumber = c;
        this.expirationDate = e;
        this.cvv = v;
        this.amount = a;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
    public void setAmount(int amount){
        this.amount = amount;
    }

    public boolean checkCard(String n){
        if (n.length() == 16 ){
            return false;
        }
        return true;
    }
    public boolean checkExpiry(String n){
        if (n.matches("\\d{2}/\\d{2}") ){
            return false;
        }
        return true;
    }
    public boolean checkCvv(String n){
        if (n.length() == 3){
            return false;
        }
        return true;
    }
    public boolean checkAmount(String n){
        int number = Integer.parseInt(n);
        if (number > 0){
            return false;
        }
        return true;
    }
public void paymentStatus(boolean paymentSuccessful){
        // Display the payment result
        if (paymentSuccessful) {
            System.out.println("\nPayment Successful.");
        } else {
            System.out.println("Payment failed. Please try again.");
        }
    }


}
