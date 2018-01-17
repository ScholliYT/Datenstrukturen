public class Knoten
{
   private Object inhalt;
   private Knoten knoten;
       
   public Knoten(Object inhalt, Knoten knoten)
   {
      this.inhalt = inhalt;
      this.knoten = knoten;
   }
   
   public Object getInhalt()
   {
      return inhalt;
   }
   
   public Knoten getZeiger()
   {
      return knoten;
   }
   
   public void setZeiger(Knoten neu)
   {
      knoten = neu;
   }
   
   public void setInhalt(Object neu)
   {
      inhalt = neu;
   }
}