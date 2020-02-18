/**
 * TeamMember class contains saves the field entries for a teamMember Methods
 * Include: getStartDate(), equals(obj), and toString()
 * 
 * @author Manel Bermad, Karneet Arora
 */
public class TeamMember {
	private String name;
	private Date startDate;

	/**
	 * TeamMember() is a constructor that saves the field entries to the local
	 * variables
	 * 
	 * @param name being added
	 * @param date team member started
	 */
	public TeamMember(String nm, Date date) {
		name = nm;
		startDate = date;
	}

	/**
	 * getStartDate() simply returns the start date
	 * 
	 * @return start date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * equals(TeamMember obj) takes in the param obj and compares it with the with
	 * another instance
	 * 
	 * @param obj being compared
	 * @return true if equivalent, false otherwise
	 */
	public boolean equals(TeamMember obj) {
		if (this == obj) {
			return true;
		} else {
			String n1 = this.name;
			String n2 = obj.name;
			Date d1 = this.startDate;
			Date d2 = obj.getStartDate();
			int nameComparaison = n1.compareTo(n2);
			boolean dateComparaison = d1.equals(d2);
			return (nameComparaison == 0 && dateComparaison);
		}
	}

	/**
	 * toString() takes the name and start date and returns it as a String
	 * 
	 * @return string that with name + startDate
	 */
	public String toString() {
		return this.name + " " + this.startDate;
	}

	public static void main(String[] args) {
		// Test Case #1 - invoke constructor and display
		String example = "12/24/1997";
		Date d = new Date(example);
		TeamMember John = new TeamMember("John", d);
		System.out.println(John.toString() + "\n");

		// Test Case #2 - invoke equals() method
		String example2 = "12/23/1997";
		Date date2 = new Date(example2);
		TeamMember John2 = new TeamMember("John", date2);
		System.out.println("Team Member Info:" + John2.toString());
		System.out.println("Other Team Member: " + John.toString());
		System.out.println("Objects are equal: " + John2.equals(John) + "\n");

		// Test Case #3 - invoke the getStartDate() method
		String example3 = "02/17/2020";
		Date date3 = new Date(example3);
		TeamMember Johnny = new TeamMember("Johnny", date3);
		System.out.println("Team Member Name: " + Johnny.name);
		System.out.println("Start Date: " + Johnny.getStartDate() + "\n");

		// Test Case #4 - compare 2 completely different objects with .equals()
		System.out.println("Team Member Info: " + John2.toString());
		System.out.println("Other Team Member: " + Johnny.toString());
		System.out.println("Objects are equal: " + John2.equals(Johnny) + "\n");

	}

}
