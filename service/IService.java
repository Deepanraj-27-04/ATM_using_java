package service;
import iservice.AccountService;

public class IService implements AccountService{
    
    public Integer balance = 0;

    @Override
    public void deposit(Integer amount)
    {
            this.balance += amount;
            System.out.println("BAlance changed"); 
            System.out.println(this.balance);
            System.out.println(amount);        
    }
    @Override
    public boolean withdraw(Integer amount)
    {
        boolean isWithdraw= false;
        try {
            this.balance=this.balance-amount;
            isWithdraw=true;
        } catch (Exception e) {
           System.out.println("Exception is raised while withdraw"+e.getMessage());
        }
        return isWithdraw;
    }

    @Override
    public Integer getBalance()    {
        System.out.println(this.balance);
        Integer b = this.balance;
        return b;
    }
}
