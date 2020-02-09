/**
  
 @author  
 */
public class Date 
{
   private int  day;
   private int  month;
   private int  year;
   
   public Date(String d)
   {
      //use StringTokenizer to parse the String and create a Date object     
   }
   
   public Date(Date d)
   {
      //this is a constructor
   }      
	
   public boolean isValid()
   {
     switch(month)
     {
	   case(Month.JAN):
	   case(Month.MAR):
	   case(Month.MAY):
	   case(Month.JUL):
	   case(Month.OCT):
	   case(Month.DEC):
	     if(day < 0 | day > 31) 
	     {
		   return false;  
	     }
	     break; 
	   case(Month.APR):
	   case(Month.JUN):
	   case(Month.AUG):
	   case(Month.SEP):
	   case(Month.NOV):
	     if(day < 0 | day > 30)
	     {
	       return false;
	     }
	     break; 
       case(Month.FEB):
	     if(year % 4 == 0) 
	     { 
	       if(year % 100 == 0)
	       {
	         if(year % 400 == 0) 
	         {
	    	   if(day < 0 | day > 29) 
	    	   {
	    	     return false;  	 
	    	   }
	    	 }
	    	 else
	    	 { 
	    	   if(day < 0 | day > 28) 
	    	   {
		         return false;  	 
		       } 
	    	 }
	       }  
	       else
	       { 
	         if(day < 0 | day > 29) 
	         {
	    	   return false;  	 
	         }
	       }
	    }
	    else
	      if(day < 0 | day > 28) 
	      {
		    return false; 	 
		  }  
	    break; 
      default:
    	return false;  	  
     }
     return true; 
   }  
   
   @Override
   public String toString()
   {
       //use the format "month/day/year"
   }
   
   @Override
   public boolean equals(Object obj)
   {
       
   }  
}
 
