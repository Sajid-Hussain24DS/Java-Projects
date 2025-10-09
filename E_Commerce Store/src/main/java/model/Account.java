 package model;

public class Account {
    private int accId;
    private String bank;
    private String accountNumber;
    private String totalBalance;

    public Account() {}

    public Account(int accId, String bank, String accountNumber, String totalBalance) {
        this.accId = accId;
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.totalBalance = totalBalance;
    }

    // Getters and Setters
    public int getAccId() { return accId; }
    public void setAccId(int accId) { this.accId = accId; }

    public String getBank() { return bank; }
    public void setBank(String bank) { this.bank = bank; }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getTotalBalance() { return totalBalance; }
    public void setTotalBalance(String totalBalance) { this.totalBalance = totalBalance; }

    @Override
    public String toString() {
        return "Account [accId=" + accId + ", bank=" + bank +
                ", accountNumber=" + accountNumber + ", totalBalance=" + totalBalance + "]";
    }
}
