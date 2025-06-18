//Maria Tsatsari
//AM 4907
import java.util.*;
public class Hand
{
    
    ArrayList<Card> A;

    
    public Hand()
    {
        
        A=new ArrayList<Card>();
    }

    
    public void addCard(Card c)
    {
        
        A.add(c);
    }
    
    public int score()
    {
        int s=0;
        int assoi=0;
        for (Card c:A)
        {
            if(c.isAce()) assoi++;
            s+=c.getValue();
        }
        
        if(assoi>0 && s<=21 && s+10<=21){
           s=s+10;  
        }
        
        return s;
    }
    
    public boolean canSplit()
    {
        
        if(A.size()!=2) return false;
        
        if(A.get(0).equals(A.get(1))) return true;
        else return false;
        
        
    }
    
    public Hand[] split()
    {
        Hand H[]=new Hand[2];
        H[0]=new Hand();
        H[1]=new Hand();
        H[0].addCard(A.get(0));
        H[1].addCard(A.get(1));
        
        return H;
        
        
    }
    
    
    public boolean isBlackjack()
    {
       if(A.size()==2){
           if(score()==21) return true;
           else return false;
        }
        else
        {
         return false;   
        }
        
    }
    
    public boolean isBust()
    {
     return score()>21;   
    }
    
    public String toString()
    {
        String s="";
        for (Card c: A)
        {
         s=s+c.toString()+" ";   
        }
        return s;
    }
    
    public static void main (String arg[])
    {
        Hand H=new Hand();
        Hand H2[];
       
        H.addCard(new Card("1"));
        H.addCard(new Card("1"));
        System.out.println(H.toString());
        System.out.println("Score:"+H.score());
        System.out.println("CanSplit:"+H.canSplit());
        
        H2=H.split();
        
        System.out.println(H2[0].toString());
        System.out.println(H2[1].toString());
        
        H2[0].addCard(new Card("K"));
         
        System.out.println(H2[0].toString());
        System.out.println("Score:"+H2[0].score());
        System.out.println("IsBlackjack:"+H2[0].isBlackjack());
        
        H2[0].addCard(new Card("1"));
         
        System.out.println(H2[0].toString());
        System.out.println("Score:"+H2[0].score());
        
        H2[0].addCard(new Card("10"));
         
        System.out.println(H2[0].toString());
        System.out.println("Score:"+H2[0].score());
        System.out.println("IsBust:"+H2[0].isBust());
        
    }
}
