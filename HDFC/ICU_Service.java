package HDFC;

import java.util.Scanner;


import service.IAuthenticate;
import service.IService;

public class ICU_Service implements Service {
    Scanner sc =new Scanner(System.in);
    IService op= new IService();

    // Integer amount;

    Integer pin;

    @Override
    public void service()
    {
        while(true)
        {
            showmenu();
            Integer choice=sc.nextInt();
            performOperation(choice);
        }
        
    }
    private void showmenu()
    {
        System.out.println("1- Deposit");
        System.out.println("2- Withdraw");
        System.out.println("3- Balance");
        System.out.println("4- Reset_pin");
        System.out.println("5- exit");
    }
    private void performOperation(Integer choice)
    {
        IAuthenticate auth=new IAuthenticate();
        
        switch(choice)
        {
            case 1:
             pin =readPIN();
            if(auth.pin_verification(pin)){
                 Integer amount=readAmount();
                if(amountValid(amount))
                {
                    op.deposit(amount);
                    System.out.println("in icu "+op.balance);
                    System.out.println("Amount is deposit");
                }
                else System.out.println("Amount is invalid");
                
            }
            else{
                System.out.println("invalid pin");
            }
                break;
            
            case 2:
             pin =readPIN();
            if(auth.pin_verification(pin))
            {
                Integer a=readAmount();
                if(amountValid(a))
                {
                    if(op.withdraw(a))
                        System.out.println("amount is withdraw");
                }
            }
            else
            {
                System.out.println("invalid pin");
            }
            break;

            case 3:
             pin =readPIN();
            if(auth.pin_verification(pin))
            {
                // Integer b = op.getBalance();
               System.out.println("balance amount : "+op.getBalance()); 
            }
            else
            {
                System.out.println("invalid pin");
            }
            break;

            case 4:
            pin=readPIN();
            if(auth.pin_verification(pin))
            {
              Integer new_pin=readPIN();
              if(validatePIN(new_pin)){

              if(auth.reset_pin(new_pin))
                System.out.println("pin is changed");
            }
            
                else
                System.out.println("pin is not valid");

              
            }
            else
                {System.out.println("invalid pin enter ");
            }
            break;
           

            case 5:
            System.exit(0);
            default:
            System.out.println("Invalid choice");
            break;
        }
    }
    private boolean amountValid(Integer amount)
    {
        return (amount>0)? true : false;
    }
    private Integer readAmount()
    {   System.out.println("enter the amount :");
        return sc.nextInt();
    }
    private Integer readPIN()
    {
        System.out.println("enter the pin :");
        return sc.nextInt();
    }
    private boolean validatePIN(Integer pin)
    {
        return ((pin>999) && (pin <=9999)? true : false);
    }
    
}
