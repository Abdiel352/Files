/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ccountrecordgui;

/**
 *
 * @author abdie
 */

public class AccountRecordGUI{
    private int account;
    private String firstName;
    private String lastName;
    private double balance;

    public AccountRecordGUI() {
        this(0, "", "", 0.0);
    }

    public AccountRecordGUI(int acct, String first, String last, double bal) {
        setAccount(acct);
        setFirstName(first);
        setLastName(last);
        setBalance(bal);
    }

    public void setAccount(int acct) {
        account = acct;
    }

    public int getAccount() {
        return account;
    }

    public void setFirstName(String first) {
        firstName = first;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String last) {
        lastName = last;
    }

    public String getLastName() {
        return lastName;
    }

    public void setBalance(double bal) {
        balance = bal;
    }

    public double getBalance() {
        return balance;
    }
}
