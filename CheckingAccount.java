class CheckingAccount {
    private double balance;
    private int number;
    
    public CheckingAccount(int number) {
       this.number = number;
    }
    
    public void deposit(double amount) {
       balance += amount;
    }
    
    public void withdraw(double amount) throws InsufficientAmountException {
       if(amount <= balance) {
          balance -= amount;
       }else {
          double needs = amount - balance;
          throw new InsufficientAmountException(needs);
       }
    } 
    
 }
 class BankDemo {
    public static void doOperations() {
        CheckingAccount c = new CheckingAccount(101);      
        c.deposit(500.00);       
        try {         
            c.withdraw(100.00);          
            c.withdraw(600.00);
        } catch (InsufficientAmountException e) {
            System.out.println(e.getMessage());
            System.out.println("Please, deposit at least $" + e.getAmount());
            e.printStackTrace();
        }
    }
}

class InsufficientAmountException extends Exception {
    private double amount;

    public InsufficientAmountException(double amount) {
        this.amount = amount;
    }

    @Override
    public String getMessage() {
        return "Sorry, but you are short $" + amount;
    }

    public double getAmount(double amount) {
        return amount;
    }
}
