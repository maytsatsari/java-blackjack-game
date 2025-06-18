//Maria Tsatsari
//AM 4907
public class River
{
   
    private int n; // arithmos apo trapoules
    private Card C[];
    private int cardsLeft;
    private int numberOfCards;
   
    public River(int n1)
    {
        n=n1;
        numberOfCards=52*n;
        C=new Card[numberOfCards];
        cardsLeft=numberOfCards;
        
        for (int i=0;i<numberOfCards;i++)
        {
          if(i%13<10) C[i]=new Card((i%13+1)+"");
          if(i%13==10) C[i]=new Card("Q");
          if(i%13==11) C[i]=new Card("J");
          if(i%13==12) C[i]=new Card("K");
          
          
            
        }
        
        
        
    }
    
    public Card nextCard()
    {
        int x=(int) Math.floor(Math.random() * cardsLeft);
        Card tmp=C[cardsLeft-1];
        C[cardsLeft-1]=C[x];
        C[x]=tmp;
        cardsLeft--;
        if(cardsLeft!=0)
        return C[cardsLeft];
        else
        return null;
        
    }
    
    
    public boolean shouldRestart()
    {
        
        if(cardsLeft<numberOfCards/4)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
   
    public void restart()
    {
        cardsLeft=numberOfCards;
      
    }
    
    
    
    public static void main(String args[])
    {
        River R=new River(1);
        while(!R.shouldRestart())
        {
           Card c=R.nextCard();
           System.out.println(c.toString());   
            
        }
        R.restart();
        System.out.println("Restart");
        while(true)
        {
         Card c=R.nextCard();
         if(c==null) break;
         System.out.println(c.toString());
            
        }
    }
}
