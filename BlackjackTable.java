//Maria Tsatsari
//AM 4907
import java.util.*;
public class BlackjackTable
{
  
    private River R;
    CasinoCustomer C[];
    int n;

   
    public BlackjackTable(int np)
    {
        n=np;
        createCasinoCustomer();
    }
    
    private void createCasinoCustomer()
    {
        
        C=new CasinoCustomer[n];
        for (int i=0;i<n;i++)
        {
            Scanner in=new Scanner(System.in);
            System.out.println("Give name of player"+i+" :");
            String s=in.nextLine();
            
            System.out.println("Give money of player"+i+" :");
            double d=in.nextDouble();
            
            C[i]=new CasinoCustomer(s,d);
        }
        
    }

    
    public void play()
    {
       River R=new River(6);
       
       do {
           int bn=0;
           if(R.shouldRestart())
           {
               R.restart();
           }
           
           Round rnd=new Round(R);
           
           for (int i=0;i<n;i++)
           {
               if(C[i].isBroke()) bn++;
               else rnd.addPlayer(C[i]);
           }
           
           if(bn==n) break;
           rnd.playRound();
       
       } while(true);
       
       System.out.println("Game Over");
    }
    
    
    
    public static void main(String arg[])
    {
        Scanner in=new Scanner(System.in);
        
        System.out.println("Give number of players:");
        int np=in.nextInt();
       
        BlackjackTable Game=new BlackjackTable(np);
        Game.play();
        
        
        
        
    }
}
