package service;


import iservice.Authentigate;
public class IAuthenticate implements Authentigate{
    Integer passcode=1234;
    @Override
    public boolean pin_verification (Integer pin)
    {
        return (this.passcode.equals(pin)? true : false);
    }
    @Override
    public boolean reset_pin (Integer pin){
        boolean isReset=false;
        try {
            
            this.passcode=pin;
            isReset=true;
        } catch (Exception e) {
            System.out.println("Exception is raised while changing pin"+e.getMessage());
        }
        return isReset;
    }
}
