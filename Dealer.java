//Maria Tsatsari
//AM 4907

public class Dealer
{
    private River R;
    private Hand H;
        
    public Dealer(River r)
    {
        
        R=r;
        H=new Hand();
    }
    

  
    
    public Hand getHand()
    {
     return H;   
    }
    
    public void draw()
    {
        
        H.addCard(R.nextCard());
    }
    
    public void deal (Player p)
    {
        p.getHand().addCard(R.nextCard());
    }
    
    public void play()
    {
      while(H.score()<17)
      {
          draw();
      }
        
    }
    
    
    public void sattle(Player p)
    {
       if( H.isBlackjack())
       {
         if(!p.getHand().isBlackjack()) p.loses();  
        }
        else
        {
         if(p.getHand().isBlackjack())
         {
             p.winsBlackJack();
         }
         else
         {
             if(!H.isBust())
             {
              if(p.getHand().isBust()) p.loses();   
              else{   
                if(H.score()<p.getHand().score())
                {
                  p.wins();
                }
                else
                {
                 p.loses(); 
                }
              }
             }
             else
             {
                 if(!p.getHand().isBust()) p.wins();
             }
         }
            
        }
       
    }
    
    
    
    
    
    public String toString()
    {
        return "Dealer: "+H.toString();
        
    }
    
    
    public static void main(String arg[])
    {
        River T=new River(1);
        Dealer D=new Dealer(T);
        
        D.play();
        System.out.println(D);
        
        Player P=new Player(new CasinoCustomer("Maria",50));
        
        D.deal(P);
        D.deal(P);
        
        System.out.println(P);
    }
}
