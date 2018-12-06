package la7pkg;

public class Course<E> implements ICourse {

	String dept;
	int courseNum;
	int cap;
	int stuInCourse;
	String stuName;
	LinkedList<String> roster = new LinkedList<String>();

	/**
	 * Course constructor
	 * 
	 * @param department  course department
	 * @param number   course number
	 * @param capacity   course capacity
	 */
	public Course(String department, int number, int capacity) {
		dept = department;
		courseNum = number;
		cap = capacity;
	}
	
	
	/**
	 * Determines if the capacity for this course has been reached.
	 * 
	 * @return true/false   boolean
	 */
	@Override
	public boolean isFull() {

		if(stuInCourse <= cap) {
			return false;
		} else {
			return true;
		}
	}


	/**
	 * Adds student to class roster if its not full
	 * and increments the number of students in the course.
	 * 
	 * @param name   name of student
	 */
	@Override
	public void addStudent(String name) {
		if(!isFull()) {
			roster.add(name);
			stuInCourse++;
		}
	}

	/**
	 * Prints the roster for this course.
	 */
	@Override
	public void printClassList() {
		for(int i = 0; i < roster.size(); i++) {
			System.out.println(roster.get(i));
		}
		
	}
	
	/**
	 * compares two objects.
	 * 
	 * @param arg0  object
	 */
	@Override
	public boolean equals(Object arg0) {
		return  this.equals(arg0);
	}

}
