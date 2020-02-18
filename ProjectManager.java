/** ProjectManager Class - parses through the input and runs the correct method
 * Methods include - add(), remove(), print()
 @author Manel Bermad, Karneet Arora 
 */


import java.util.Scanner;

public class ProjectManager
{
   Scanner stdin;
   Team cs213;
   String command, name, date;  
   /**
    * run() starts the program by allocating space for a team object and parsing through input.
    * 
    */
   public void run()
   {
      cs213 = new Team(); 
      boolean done = false;
      while ( !done )
      {
    	 System.out.println("Enter your input:");
    	 stdin =  new Scanner(System.in);
    	 int lineSize = 0;
    	 String line = "";
    	 
    	 
    	 while(stdin.hasNextLine()){
    		 line = stdin.nextLine();
    		 String w[]= line.split(" ");
    		 
    		 lineSize = w.length;

             if(lineSize == 3){
            	 command= w[0];
            	 name = w[1];
            	 date = w[2];
            	 
                 switch (command)  
                 {   
                    case "A": add();
        		      break; 
                    case "R":remove();
                    	break;
                    default: 
                    	System.out.println("Command '"+command+"' not supported!");           
                 }  
             
             }else if(lineSize == 1){
            	 command= w[0];
            	 switch (command)   
                 {   
                    case "P": print(); 
        		      break;               
                    case "Q": print(); 
                    		  System.out.println("The team is ready to go!"); 
                    		  stdin.close();
    	 					  done = true;
                    		  System.exit(0);
                    	break;
                    default: 
                    	System.out.println("Command '"+command+"' not supported!");
                 }  
             
             }else{
            	 System.out.println("Wrong size of input!");
             }
            
    	 }
         
    	 }

   }
   /**
    * add() adds a member to the team if it is well formated and if it doesn't exist already.
    * */
   
   private void add()
   {
	   Date d = new Date(date);
	   if(d.isValid()){
		   TeamMember member = new TeamMember(name, d);
		   if(cs213.contains(member)){
			   System.out.println( name + " "+ date + " is already in the team.");
		   }else{
			   cs213.add(member);
			   System.out.println( name + " "+ date + " has joined the team.");
		   }
	   }else{
		   System.out.println( date + " is not a valid date!");
	   }
	   
   }
   /**
    * remove() removes the specified member from team if it is well formatted and if it exists*/
   private void remove()
   {
	   Date d = new Date(date);
	   if(d.isValid()){
		   TeamMember member = new TeamMember(name, d);
		   
		   if(cs213.contains(member)){ 
			   cs213.remove(member);
			   System.out.println( name + " "+ date + " has left the team."); // do you copy these lines in the team methods or keep them here?
		   }else{
			   
			   System.out.println( name + " "+ date + " is not a team member.");
		   }
	   }else{
		   System.out.println( date + " is not a valid date!");
	   }	   
   }
   
   /**
    * print() outputs the content (team members) of the team
    */
   private void print()
   {
	   if (cs213.isEmpty()){
		   System.out.println("We have 0 team members!");
	   }else{
		   System.out.println("We have the following team members:");
		   cs213.print();
		   System.out.println("-- end of the list --");
	   } 
 
   }   



} //ProjectManager


/*
 * 
R Lily 11/27/2011
r Lily 11/27/2011
p
P
A Lily 2/29/2011
A Lily 4/31/2011
A Lily 6/31/2011
A Lily 9/31/2011
A Lily 11/31/2011
A Lily 2/28/2011
A Chang 4/30/2008
A Stone 2/29/2000
A Brown 6/32/1995
A Brown 6/0/1995
A Brown 6/1/1995
P
A Mary 1/31/1997
A Mary 1/31/1997 
A Eric 3/31/2011
R Eric 3/30/2011
P
R Eric 3/31/2000
R Eric 3/31/2011
P
A John 13/1/2016
A John 0/1/2016
A John 12/30/2012
A April 9/30/1999
A Chris 10/31/2013
A Eric 2/29/2012
R Mary 1/31/1997
P
A Chang 5/1/2012
A Chang 7/31/2012
a Chang 7/31/2012
R Chris 11/30/2012
P
R Lily 2/28/2011
R Chang 4/30/2008
R Eric 2/29/2012
R Stone 2/29/2000
q
Q
*/
