//Maria Tsatsari
//AM 4907
public class Card
{
    public String value;

    public Card(String v)
    {
       value=v;
    }
    
    public boolean isAce()
    {
     if (value.equals("1")) return true;
     else return false;
    }
    
    public boolean equals(Card c)
    {
     return this.value.equals(c.value);
         
        
    }

 
    public int getValue()
    {
        try {
            return Integer.parseInt(value);
        }
        catch(NumberFormatException e)
        {
         return 10;   
        }
    }
    
    
    public String toString()
    {
     return value;   
    }
}
