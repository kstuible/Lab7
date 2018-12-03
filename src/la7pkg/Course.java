package la7pkg;

public class Course<E> implements ICourse {

	String dept;
	String courseNum;
	int cap;
	int stuInCourse;
	String stuName;
	
	public Course(String department, String number, int capacity) {
		dept = department;
		courseNum = number;
		cap = capacity;
	}
	
	@Override
	public boolean isFull() {

		if(stuInCourse < cap) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void addStudent(String name) {
		
		
	}

	@Override
	public void printClassList() {
		
		
	}

}
