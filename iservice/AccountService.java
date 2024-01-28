package iservice;
public interface AccountService {
   public  void deposit(Integer amount);
   public boolean withdraw(Integer amount);
   public Integer getBalance();

}
