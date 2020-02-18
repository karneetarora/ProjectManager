
/** Date Class - parses through a string and creates a date object
 * Checks if the format of the date and the date itself are correct 
 * Methods include - isValid(), toString(), and equals(), 
 * @author: Karneet Arora, Manel Bermad
 */

import java.util.StringTokenizer;

public class Date {
	private int day;
	private int month;
	private int year;

	public Date(String d) {
		// use StringTokenizer to parse the String and create a Date object
		String delimiter = "/";
		boolean parse = true;
		StringTokenizer token = new StringTokenizer(d, delimiter);
		for (int i = 0; i < d.length(); i++) {
			if (d.charAt(i) != delimiter.charAt(0) && !Character.isDigit(d.charAt(i))) {
				// If the date is in improper format - the date is set to 0/0/0
				d = "0/0/0";
				parse = false;
			}
		}
		if (parse) {
			try {
				month = Integer.parseInt(token.nextToken());
			} catch (NumberFormatException monthError) {
				month = 0;
			}
			try {
				day = Integer.parseInt(token.nextToken());
			} catch (NumberFormatException dayError) {
				day = 0;
			}
			try {
				year = Integer.parseInt(token.nextToken());
			} catch (NumberFormatException yearError) {
				year = 0;
			}
		}
	}

	/**
	 * This is a constructor that equates the field entries of the object to that of
	 * the field entries of the instance object
	 * 
	 * @param date object
	 */
	public Date(Date d) {
		// this is a constructor
		this.day = d.day;
		this.month = d.month;
		this.year = d.year;
	}

	/**
	 * isValid() checks to see if the date entered is a valid date It checks the
	 * month, day, and year For the month of February, it checks if the year is a
	 * leap year
	 * 
	 * @return true if the date entered is valid, false otherwise
	 */
	public boolean isValid() {
		boolean leapYear = false;
		switch (month) {
		case (Month.JAN):
		case (Month.MAR):
		case (Month.MAY):
		case (Month.JUL):
		case (Month.OCT):
		case (Month.DEC):
			if (day < 1 || day > Month.DAYS_ODD) {
				return false;
			}
			break;
		case (Month.APR):
		case (Month.JUN):
		case (Month.AUG):
		case (Month.SEP):
		case (Month.NOV):
			if (day < 1 || day > Month.DAYS_EVEN) {
				return false;
			}
			break;
		case (Month.FEB):
			// must check if the year is a leap year as the days in February would vary
			if (year % Month.QUADRENNIAL == 0) {
				if (year % Month.CENTENNIAL == 0) {
					if (year % Month.QUATERCENTENNIAL == 0)
						leapYear = true;
				} else {
					leapYear = true;
				}
			}
			if (leapYear) {
				if (day < 1 || day > 29)
					return false;
			} else {
				if (day < 1 || day > Month.DAYS_FEB)
					return false;
			}
			break;
		default:
			return false;
		}
		if (year > 10000 || year < 999) {
			return false;
		}
		return true;
	}

	/**
	 * toString() method parses the date entered into a proper formatted date and
	 * saves it as a string
	 * 
	 * @return date
	 */
	@Override
	public String toString() {
		// use the format "month/day/year"
		return month + "/" + day + "/" + year;
	}

	@Override
	/**
	 * equals(obj) method takes in an object as a parameter and checks to see if
	 * that particular object is an instance of the class and then proceeds to check
	 * if the data fields are equivalent
	 * 
	 * @param object being compared
	 * @return true if objects are equal, false otherwise
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Date) {
			Date tempDate = (Date) obj;
			if (this.month == tempDate.month) {
				if (this.day == tempDate.day) {
					if (this.year == tempDate.year) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// testbed main; you must include test cases that exercise
		// the constructor and all methods in this class.

		// test case #1 - checks logic of isValid() and toString()
		Date d1 = new Date("12/24/1997");
		System.out.println("Date is valid: " + d1.isValid());
		System.out.println("Date as string: " + d1.toString() + "\n");

		// test case #2 - checks logic of leap year
		String leapYearExample = "02/29/2016";
		Date feb = new Date(leapYearExample);
		System.out.println("Date inputted: " + leapYearExample);
		System.out.println("Date is valid: " + feb.isValid() + "\n");

		// test case #3 - checks logic of leap year
		String nonLeapYear = "02/29/2017";
		Date feb1 = new Date(nonLeapYear);
		System.out.println("Date inputted: " + nonLeapYear);
		System.out.println("Date is valid: " + feb1.isValid() + "\n");

		// test case #4 - compare two objects with using the equals() method
		System.out.println("First Date is: " + d1.toString()); // date is 12/24/1997
		System.out.println("Second Date is: " + leapYearExample.toString()); // date is 02/29/2016
		System.out.println("The dates are equal: " + d1.equals(feb) + "\n");

		// test case #5 - test isValid() method with the use of letters
		String letters = "ab/28/2020";
		Date test5 = new Date(letters);
		System.out.println("Date inputted: " + letters);
		System.out.println("Date as string: " + test5.isValid() + "\n");

		// test case #6 - test improper punctuation marks
		String improperFormat = "09-11-2021";
		Date test6 = new Date(improperFormat);
		System.out.println("Date inputted: " + improperFormat);
		System.out.println("Date is valid: " + test6.isValid() + "\n");

		// test case #7 - test equals() method compares this obj to d1
		String xmasEve = "12/24/1997";
		Date test7 = new Date(xmasEve);
		System.out.println("Date inputted: " + xmasEve);
		System.out.println("Date being compared to: " + d1.toString()); // d1 = 12/24/1997
		System.out.println("Dates are equal: " + test7.equals(d1) + "\n");
	}
}
