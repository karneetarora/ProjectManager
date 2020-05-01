# ProjectManager

About: The objective of the program is to create a growable container for a Team so it could hold Team Member objects and their specific data field entries, name and start date. The program takes in commands such as: Add, Remove, Print or Quit. 

  Commands - 
  
    Add ( A ) - add a new team member; input ex: "A John 12/12/2012"
  
    Remove ( R ) - remove a team member; input ex: "R John 12/12/2012"
  
    Print ( P ) - print all team members on the team, displays "We have 0 team members!" if team is empty
  
    Quit ( Q ) - display team members on team, display "The team is ready to go!", and terminate the program 
  

Background: This project is an assignment for Software Methodology (CS213) and was completed by my partner and I. The professor provided the bare minimum, such as: the names for the files, classes, and methods. We were also provided a sample input/output test cases which we had to match. We were not allowed to use Java Library Classes. 



Break-Down: 
- Date Class - parses through a String and creates a date object. Prior to the creation of the date object, the fields of the date are checked to ensure it is a proper date. The class returns the an object date. 
- Month Class - common constants used in the other classes, predefined by the professor. 
- Prog1 Class - calls the projectManager class to start the program. 
- ProjectManager Class - parses through the input in, which is in the form of a String, and carries out the appropriate commands and calls the date class to check the date input. 
- Team Class - container class that holds the teamMembers in an expadable array. 
- TeamMember - saves the field entries of a team member. 

