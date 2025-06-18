//Maria Tsatsari
//AM 4907
import java.util.*;
public class Player
{
   
    private CasinoCustomer P;
    private Hand H;
    double bet;
    

    /**
     * Constructor for objects of class Player
     */
    public Player(CasinoCustomer p)
    {
        P=p;
        H=new Hand();
        
    }
    
    
    public Player(CasinoCustomer p, Hand h1, double b)
    {
        P=p;
        H=h1;
        bet=b;
        
    }

   
    public Hand getHand(){ return H;}
    public CasinoCustomer getCasinoCustomer() { return P; }
    public double getBet() {return bet;}
    
    public void setHand(Hand h1){ H=h1;}
    public void setCasinoCustomer(CasinoCustomer c){ P=c;}
    public void setBet(double b){ bet=b;}
    
    public void wins()
    {
        System.out.println("Win Player "+P );
        P.collectBet(bet);
        
    }
    
    public void winsBlackJack()
    {
        System.out.println("Win BlackJack Player "+P );
        P.collectBet(bet*1.5);
        
    }
    
    public void loses()
    {
        System.out.println("Loses Player "+P );
        P.payBet(bet);
        
    }
    
    public void placeBet()
    {
        Scanner in=new Scanner(System.in);
        P.printState();
        
        double b;
        boolean f;
        do{
            f=true;
            System.out.println("Give Bet:");
            b=in.nextDouble();
            
            if( P.canCover(b) && b>=1) f=false;
            
        }while (f);
        bet=b;
    }
    
    public void doubleBet()
    {
     bet=2*bet;   
    }
    
    public boolean wantsToDouble()
    {
        Scanner in=new Scanner(System.in);
        
        if(P.canCover(2*bet))
        {
            System.out.println("Do you want to double (give Y for yes):");
            String b=in.nextLine();
            if(b.equals("Y")) return true;
            else return false;
            
        }
        else return false;
    }
    
    
    public boolean wantsToSplit()
    {
        Scanner in=new Scanner(System.in);
        
        if(P.canCover(2*bet))
        {
            System.out.println("Do you want to Split (give Y for yes):");
            String b=in.nextLine();
            if(b.equals("Y")) return true;
            else return false;
            
        }
        else return false;
    }
    
    
    public String toString()
    {
        String s="";
        s="Name: "+P.toString()+" Hand:"+H.toString();
        return s;
    }
    
    public static void main (String arg[])
    {
        CasinoCustomer C=new CasinoCustomer("Maria",50);
        Player P=new Player(C);
        
        P.placeBet();
        
        P.wantsToSplit();
        P.wantsToDouble();
        
        P.wins();
        P.getCasinoCustomer().printState();
        P.winsBlackJack();
        P.getCasinoCustomer().printState();
        P.loses();
        P.getCasinoCustomer().printState();
        
    }
    
}
