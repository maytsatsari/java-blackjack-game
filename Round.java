//Maria Tsatsari 
//AM 4907
import java.util.*;
public class Round
{
   
    private Dealer D;
    ArrayList<Player> P;
    ArrayList<Player> PS;

    
    public Round(River R)
    {
        D=new Dealer(R);
        P=new ArrayList<Player>();
        PS=new ArrayList<Player>();
        
        
    }

    
    public void addPlayer(CasinoCustomer C)
    {
       
       P.add(new Player(C));
         
    }
    
    public void playRound()
    {
     for (Player p : P)
     {
         p.placeBet();
         
     }
     
     for (Player p : P)
     {
         D.deal(p);
         
         
     }
     D.draw();
     
     System.out.println(D);
     
      for (Player p : P)
     {
         D.deal(p);
         
         
     }
     D.draw();
     
     for (Player p: P)
     {
         System.out.println(p);
     }
     System.out.println(D);
     
     if(D.getHand().isBlackjack())
     {
         for (Player p : P)
         {
             D.sattle(p);
         }
     }
     else
     {
        
         for (Player p : P)
         {
             if(p.getHand().isBlackjack())
             {
                 D.sattle(p);
             }
             else
             {
                 playPlayer(p);
             }
         }
         D.play();
         System.out.println(D);
         for (Player p: PS)
         {
             D.sattle(p);
         }
     }
     
    }
    
    
    private void playNormalHand(Player p)
    {
        Scanner in=new Scanner(System.in);
        while(true) {
            System.out.println(p);
            System.out.println("Score:"+p.getHand().score());
            System.out.println("Do you want a new card (Y for yes)?");
            String y=in.nextLine();
            if(y.equals("Y"))
            {
             D.deal(p);
             if(p.getHand().isBust())
             {
                 System.out.println(p+" Bust!");
                 System.out.println("Score:"+p.getHand().score());
                 D.sattle(p);
                 break;
             }
             
            }
            else
            {
             PS.add(p);
             break;   
                
            }
        }
        
    }
    
    private void playDoubleHand(Player p)
    {
        
       
        System.out.println(p);
        System.out.println("Score:"+p.getHand().score());

            p.doubleBet();
            D.deal(p);
             
             PS.add(p);
                
                
            
        
    }
    
    private void playSplitHand(Player p)
    {
        
       
        System.out.println(p);
        System.out.println("Score:"+p.getHand().score());
     
        if(p.wantsToSplit())
        {
            Hand H2[]=new Hand[2];
            H2=p.getHand().split();
            
            Player P1=new Player(p.getCasinoCustomer() ,H2[0],p.getBet());
            Player P2=new Player(p.getCasinoCustomer() ,H2[1],p.getBet());
            playNormalHand(P1);
            playNormalHand(P2);
            
            D.deal(p);
             
             PS.add(p);
                
                
            
        }
        
    }
    
    
    private void playPlayer(Player p)
    {
        Scanner in=new Scanner(System.in);
        if(p.getHand().canSplit())
        {
            System.out.println("Do you want to split (Y for yes)?");
            
            String y=in.nextLine();
            if(y.equals("Y"))
            {
                
                    playSplitHand(p);
                
            }
            
        }
        else
        {
           if(p.getHand().canSplit())
           {
                System.out.println("Do you want to double (Y for yes)?");
                
                String y=in.nextLine();
                if(y.equals("Y"))
                {
                    
                        playDoubleHand(p);
                    
                }
            
           }
           else
           {
               playNormalHand(p);
               
           }
            
        }
        
        
    }
    
    public static void main(String arg[])
    {
        River T=new River(6);
        Round R=new Round(T);
        CasinoCustomer c=new CasinoCustomer("Maria",100);
        
        R.addPlayer(c);
        R.playRound();
    }
}
