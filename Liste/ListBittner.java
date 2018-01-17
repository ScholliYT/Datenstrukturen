public class ListBittner extends ListBaseClass
{
   private Knoten anfang;
   private Knoten ende;
   private Knoten aktuell;
   
   public ListBittner()
   {
      anfang = null;
      ende = null;
      aktuell = null;
   }
   
   @Override
   public boolean isEmpty()
   {
      return anfang == null;
   }
   
   @Override
   public boolean hasAccess()
   {
      return aktuell != null;
   }
   
   @Override
   public void next()
   {
      if(hasAccess())
      {
         aktuell = aktuell.getZeiger();
      }
   }
   
   @Override
   public void toFirst()
   { 
      aktuell = anfang;
   }
   
   @Override
   public void toLast()
   {
      aktuell = ende;  
   }
   
   @Override
   public Object getObject()
   {
      if(hasAccess())
      {
         return aktuell.getInhalt();
      }
      else
      {
         return null;
      }  
   }
   
   @Override
   public void setObject(Object pObject)
   {
      if(hasAccess() && pObject != null)
      {
         aktuell.setInhalt(pObject);
      }
   }
   
   @Override
   public void append(Object pObject)
   {
      if(pObject != null)
      {
         Knoten neu = new Knoten(pObject, null);
         
         if(isEmpty())
         {
            anfang = neu;
         }
         else
         {
            ende.setZeiger(neu);
         }
         ende = neu;         
      }
   }
   
   public void insertSara(Object pObject)
   {
      if(isEmpty())
      {
         append(pObject);
      }
      else if(pObject != null && hasAccess())
      {
         Knoten neu = new Knoten(pObject, aktuell);
         if(anfang == aktuell)
         {
            anfang = neu;
         }
         else
         {
            Knoten temp = anfang;
            while(temp.getZeiger() != aktuell)
            {
               temp = temp.getZeiger();
            }
            temp.setZeiger(neu);
         }
      }
   }
   
   @Override
   public void insert(Object pObject) //Tom
   {
      if(isEmpty())
      {
         append(pObject);  
      }  
      else if(pObject != null && hasAccess())
      {
         Knoten oldAkt = new Knoten(aktuell.getInhalt(),aktuell.getZeiger());
         aktuell.setInhalt(pObject);
         aktuell.setZeiger(oldAkt);
         aktuell = oldAkt;
      }
   }
      
   @Override
   public void concat(ListBaseClass pList)
   {
      if(pList != null)
      {
         pList.toFirst();
         while(!pList.isEmpty())
         {
            append(pList.getObject());
            pList.remove();
         }
      }
   }
   
   @Override
   public void remove()
   {
      if(hasAccess() && !isEmpty())
      {
         if(aktuell == anfang)
         {
            anfang = anfang.getZeiger();
            aktuell = anfang;
         }
         else if(aktuell == ende)
         {
            Knoten hilf = anfang;
            while(hilf.getZeiger() != aktuell)
            {
               hilf = hilf.getZeiger();
            }
            hilf.setZeiger(null);
            ende = hilf;
            aktuell = null;
         }
         else
         {
            aktuell.setInhalt(aktuell.getZeiger().getInhalt());  
            if(aktuell.getZeiger() != null)
            {
               aktuell.setZeiger(aktuell.getZeiger().getZeiger());
            }
            else
            {
               ende = aktuell;
            }
         }
         if(anfang == null)
         {
            ende = null;
         }
      }
   }
}