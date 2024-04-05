package atm;

class Customer {

    String name;
    int accNo;
    int balance;
    int pin;

    Customer(int accNo, int pin, String name, int balance) {
        this.accNo = accNo;
        this.pin = pin;
        this.name = name;
        this.balance = balance;
    }

    public String withdraw(int amount) {
        if (balance >= amount) {
            this.balance -= amount;
            return "Withdrawal Successful!";
        } else {
            return "Insufficient Balance";
        }
    }

    public String deposit(int amount) {
        this.balance += amount;
        return "Deposit Successful!";
    }

    public String pinChange(int pin) {
        this.pin = pin;
        return "Pin Changed Successfully";
    }

    public String checkBalance() {
        return "Current Balance: " + this.balance;
    }
}
