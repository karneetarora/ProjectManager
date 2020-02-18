/**
 * Team Class is the container class that holds team members in an expandable
 * array and manages removals of members. Methods inculde: find(TeamMember m),
 * grow(), isEmpty(), add(TeamMember m), remove(TeamMember m),
 * contains(TeamMember m), print().
 * 
 * @author Manel Bermad, Karneet Arora
 */
public class Team {
	private final int NOT_FOUND = -1;
	private final int GROW_SIZE = 4;
	private TeamMember[] team;
	private int numMembers;

	/**
	 * Constructor for Team class, initializes an array of size 4 team members.
	 */
	public Team() {
		team = new TeamMember[GROW_SIZE];
		numMembers = 0;
	}

	/**
	 * locates the index of member in team
	 * 
	 * @param a member
	 * @return index of member if found, else: -1
	 */

	private int find(TeamMember m) {
		for (int i = 0; i < numMembers; i++) {
			if (team[i].equals(m)) {
				return i;
			}
		}
		return NOT_FOUND;
	}

	/**
	 * Grows array holding team members by 4 cells if no space left by moving
	 * members from old array to new one.
	 */

	private void grow() {
		TeamMember[] newArray = new TeamMember[team.length + 4];
		int index = 0;
		for (TeamMember m : team) {
			newArray[index] = team[index];
			index++;
		}
		team = newArray;
	}

	/**
	 * checks if team has 0 members
	 * 
	 * @return true if team is empty, false otherwise
	 */

	public boolean isEmpty() {
		return (numMembers == 0);
	}

	/**
	 * adds a new member to the team
	 * 
	 * @param a member
	 */

	public void add(TeamMember m) {

		if (team.length == numMembers) {
			grow();
			team[numMembers] = m;
			numMembers++;
		} else {
			team[numMembers] = m;
			numMembers++;

		}
	}

	/**
	 * removes member from team if it exists
	 * 
	 * @param a member
	 * @return true if removed, false if not.
	 */

	public boolean remove(TeamMember m) {
		int indexToRemove = find(m);
		if (numMembers == 1) {
			team[indexToRemove] = null;
		} else {
			team[indexToRemove] = team[numMembers - 1];
			team[numMembers - 1] = null;
		}
		numMembers--;
		return true;
	}

	/**
	 * checks if member exists in team
	 * 
	 * @param team Member consisting of a name and a date
	 * @return whether or not m is a member of team
	 */
	public boolean contains(TeamMember m) {
		if (find(m) == NOT_FOUND) {
			return false;
		}
		return true;
	}

	/**
	 * print() prints the content (team members) of the team.
	 */
	public void print() {
		for (int i = 0; i < numMembers; i++) {
			System.out.println(team[i].toString());
		}
	}

}
