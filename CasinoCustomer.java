//Maria Tsatsari
//AM 4907
public class CasinoCustomer
{
   
    private String onoma;
    private double xrimata;
    

    
    public CasinoCustomer(String o, double x)
    {
        onoma=o;
        xrimata = x;
    }

   
    public void payBet(double p)
    {
       
        xrimata -=p;
    }
    
    public void collectBet(double p)
    {
       
        xrimata +=p;
    }
    
    public boolean canCover(double p)
    {
        if(p<=xrimata) return true;
        else return false;
    }
    
    public boolean isBroke()
    {
        
        return xrimata<1;
    }
    
    public String toString()
    {
        return onoma;
    }
    public void printState()
    {
     System.out.println("Name:"+onoma+" Money:"+xrimata);   
    }
}
